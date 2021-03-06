$("#tableCatalog").dataTable({
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
        aoData.push({"name": "table", "value": $(".catalogModal")[0].id }, {"name": "sSearch", "value": ""});
    }
});


$('#tableCatalog tbody').on('click', 'tr', function () {

    $(".selected").removeClass("selected");
    $(this).addClass('selected');
    
});

$("#catalog_row_accept").click(function(){         
 
    $("#"+$("#modal-target").attr("input-target")).val(
            $("#tableCatalog .selected").children().eq(0).html()
     );
     
     $("#close_modal").click();
});

$( 'body' ).on( 'click', '#container .bt-catalogo', function(event) {
  
    $("#modal-target").attr("input-target",$(this).attr("input-target"));       
    $("#catalogoModal").modal('show'); 
   
});
