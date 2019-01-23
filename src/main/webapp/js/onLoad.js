
var ColsDataTable = {
    ProgramacionServicios: [0, 1, 3, 5, 6, 7, 8]
};

function limpiaFormulario() {
    $("form input:text").val("");
    $("#sDescripcion").val("");
    $("#sSearch").val("");

    $.each($("form input:text"), function () {

        if ($(this).attr("default") !== undefined || $(this).attr("default") !== "") {

            $(this).val($(this).attr("default"));
        }

    });
}

//limpiaFormulario();

function reloadTable() {
    $('.dataTablex').dataTable().api().ajax.reload();
}

$('#sidebarCollapse').on('click', function () {
    $('#sidebar').toggleClass('active');
    $(this).toggleClass('active');
});

function muestraMensaje(mensaje) {

    $("#textAlert").empty();
    $("#textAlert").text(mensaje);
    $("#alerta-modal").modal('show');
    setTimeout(function () {
        $("#cierraAlertaModal").click();
    }, 2000);
}

$("#save").click(function () {

    var InputVacio = false;

    $("form input:text").each(function () {

        if ($.trim($(this).val()) === "") {

            muestraMensaje("El campo:\" " + $("form tr").eq($("form input:text").index($(this))).children().eq(0).html() + "\" debe ser rellenado.");

            InputVacio = true;

            return false;
        }

    });

    if (InputVacio)
        return;

    $(".input-money").each(function () {

        var regexp = /^\d+(\.\d{1,2})?$/;

        if (!regexp.test(this.value)) {

            muestraMensaje("Escriba un monto correcto");
            return false;
        }

    });


    if ($("#cancelarBt").is(":visible"))
        $("#action").val("update");
    else
        $("#action").val("save");

    $.ajax({
        type: "GET",
        url: "./api/save",
        data: $("form").serialize(),
        success: function (data)
        {
            //alert(data.mensaje);
            muestraMensaje(data.mensaje);

            reloadTable();
            limpiaFormulario();
            $('.readOnly').prop('readonly', false);
            $("#cancelarBt").hide();
        }
    });
});

$("#deleteBt").click(function () {

    if ($('.dataTablex').has(".selected").length == 0) {

        muestraMensaje("Debe seleccionar un registro");
        return;
    }

    if (!confirm("¿Está seguro que desea eliminar el registro seleccionado?"))
        return;
    $.ajax({
        type: "GET",
        url: './api/del',
        data: {"table": $("#tableShow").val(), "value": $(".selected td:first-child").html()},
        success: function (data)
        {
            muestraMensaje(data.mensaje);
            reloadTable();
        }
    });
});

$(".dataTablex").dataTable({
    bProcessing: true,
    bAutoWidth: true,
    bRetrive: true,
    bDestroy: true,
    bPaginate: true,
    bLengthChange: false,
    bInfo: true,
    bFilter: false,
    bJQueryUI: true,
    bSort: false,
    oLanguage: {
        sProcessing: "Procesando...",
        sLengthMenu: "Mostrar _MENU_ registros",
        sZeroRecords: "Sin datos",
        sEmptyTable: "Sin datos",
        sLoadingRecords: "Cargando...",
        sInfo: "Registros _START_ al _END_ de _TOTAL_",
        sInfoEmpty: "Registro 0 al 0 de 0",
        sInfoFiltered: "(filtrado de _MAX_ registros)",
        sInfoPostFix: "",
        sInfoThousands: ",",
        sSearch: "Buscar:",
        oPaginate: {
            sFirst: "Primero",
            sPrevious: "Ant.",
            sNext: "Sigte.",
            sLast: "&Uacute;ltimo"
        }
    },
    bServerSide: true,
    sAjaxSource: "./api/data",
    "fnServerParams": function (aoData) {
        aoData.push({"name": "table", "value": $("#tableShow").val()}, {"name": "sSearch", "value": $("#sSearch").val()});
    }
});

$('.dataTablex tbody').on('click', 'tr', function () {

    $(".selected").removeClass('selected');
    $(this).addClass('selected');
});

function editarFormulario(TagActual, ValorCelda) {
 
    if ($(TagActual).is("input") || $(TagActual).is("textarea")) {

        $(TagActual).val(ValorCelda);

        if ($(TagActual).hasClass("input-money")) {

            $(TagActual).val(($(TagActual).val().replace(/,/g, "")));
        }
    } else if ($(TagActual).is("select")) {

        $(TagActual).children().filter(function () {
            return $(this).text() === ValorCelda;

        }).prop("selected", true);
    }
}


$("#updateBt").click(function () {

    if ($('.dataTablex').has(".selected").length === 0) {

        muestraMensaje("Debe seleccionar un registro");
        return;
    }

    var TagActual = null;
    var columnasDataTable = null;

    $.each(ColsDataTable, function (index, value) {

        if ($.trim($("#tableShow").val()) === $.trim(index)) {
            columnasDataTable = value;
        }
    });


    if (columnasDataTable === null)
    {
        $('.selected td').each(function () {

            TagActual = $('form input[type=text], textarea, select').eq($(this).index());
            editarFormulario(TagActual, $(this).html());
        });
    } else {

        $.each(columnasDataTable, function (indexArray, CellIndex) {
//alert( TagActual + " ----"+indexArray+"------"+$('.selected td').eq(CellIndex).html());
            TagActual = $('form input[type=text], textarea, select').eq(indexArray);
            editarFormulario( TagActual,  $('.selected td').eq(CellIndex).html() );
            
        });

    }



    $("#cancelarBt").show();
    $('.readOnly').prop("readonly", true);
});

$("#cancelarBt").click(function () {

    $('.readOnly').prop("readonly", false);
    limpiaFormulario();
    $(this).hide();
});


$("#limpiar").click(function () {
    $("#cancelarBt").click();
});

$("#buscarBt").click(function () {
    reloadTable();
});

$("#limpiaBuscar").click(function () {
    $("#sSearch").val("");
    $("#buscarBt").click();
});

$('.input-number').on('input', function () {
    this.value = this.value.replace(/[^0-9]/g, '');
});

$(".bt-catalogo").click(function () {

    $.ajax({
        type: "GET",
        url: "./GetCatalog",
        dataType: "json",
        async: false,
        data: {"table": this.id},
        success: function (data)
        {
            $("#contenido-catalogo").empty();
            $("#contenido-catalogo").append(data.table);
            $("#contenido-catalogo").append(data.input);
            $("#contenido-catalogo").append(data.script);
        }
    });

});


$.datepicker.regional['es'] = {
    closeText: 'Cerrar',
    prevText: '< Ant',
    nextText: 'Sig >',
    currentText: 'Hoy',
    monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
    monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
    dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
    dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mié', 'Juv', 'Vie', 'Sáb'],
    dayNamesMin: ['Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sá'],
    weekHeader: 'Sm',
    dateFormat: 'yy-mm-dd',
    firstDay: 1,
    isRTL: false,
    showMonthAfterYear: false,
    yearSuffix: ''
};
$.datepicker.setDefaults($.datepicker.regional['es']);

$(".datepicker").datepicker({
    showOn: "button",
    buttonImage: "js/images/calendario.png",
    buttonImageOnly: true
});

$("input[type=button]").addClass("btn btn-primary");


