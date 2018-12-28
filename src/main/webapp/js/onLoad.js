function limpiaFormulario() {
    $("form input:text").val("");
    $("#sDescripcion").val("");
    $("#sSearch").val("");
    $(".tm").val("TM");


}

//limpiaFormulario();

function reloadTable() {
    $('.dataTablex').dataTable().api().ajax.reload();
}

$('#sidebarCollapse').on('click', function () {
    $('#sidebar').toggleClass('active');
    $(this).toggleClass('active');
});

$(".datepicker").datepicker({
    dateFormat: "dd-mm-yy",
    showOn: "button",
    buttonImage: "js/images/calendar.gif",
    buttonImageOnly: true,
    buttonText: "click"
});

$("#save").click(function () {

    var blankValue = false;

    $("form input:text").each(function () {

        if ($.trim($(this).val()) === "") {

            alert("El campo:\" " + $("form tr").eq($("form input:text").index($(this))).children().eq(0).html() + "\" debe ser rellenado.");

            blankValue = true;

            return false;
        }

    });

    if (blankValue)
        return;

    $(".input-money").each(function () {

        var regexp = /^\d+(\.\d{1,2})?$/;

        if (!regexp.test(this.value)) {

            alert("Escriba un monto correcto");
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
            alert(data.mensaje);
            reloadTable();
            limpiaFormulario();
            $('.readOnly').prop('readonly', false);
            $("#cancelarBt").hide();
        }
    });
});

$("#deleteBt").click(function () {

    if ($('.dataTablex').has(".selected").length == 0) {

        alert("Debe seleccionar un registro");
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
            alert(data.mensaje);
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

$("#updateBt").click(function () {

    if ($('.dataTablex').has(".selected").length === 0) {

        alert("Debe seleccionar un registro");
        return;
    }

    $('.selected td').each(function () {

        $('form input[type=text], #sDescripcion, select').eq($(this).index()).val($(this).html());
        //$("#unidad_disponible").val("0");
        $('[name=unidad_disponible]').val(1);
    });

    $(".input-money").val(($(".input-money").val().replace(/,/g, "")));

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
 
    alert("...");
 
    $.ajax({
        type: "GET",
        url: "./GetCatalog",
        data: {"table": this.id},
        success: function (data)
        {
            alert(data);
            //modal-body
        }
    });

});

