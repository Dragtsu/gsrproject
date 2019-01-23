<style>

    .foo {
        float: left;
        width: 20px;
        height: 20px;
        margin: 5px;
        border: 1px solid rgba(0, 0, 0, .2);
    }

    .yellow {
        background: #d39e00;

    }

    .red {
        background: #CF2323;
        color:white;
    }



</style>
<div class="title">  <h4>Vigencia de servicios y mantenimientos</h4></div>
<div>
    <fieldset class="form-group">         
        <legend>Color de alerta:</legend>
        <table>
            <tr><td><div class="foo table-primary"></div></td> <td>Proximo a caducar</td></tr>
            <tr><td><div class="foo table-danger"></div></td><td> Caducado</td></tr>
        </table>

    </fieldset>
</div> 
<input type="hidden" name="table" value="VigenciaServicios" id="tableShow">  
<fieldset>                   
    <table id="bandejaLicencias" class="display table">
        <thead>
        <th>Tipo de servicio</th>
        <th>Id</th>
        <th>Descripcion</th>  
        <th>Fecha programada de realizacion</th>  
        <th>Dias restantes</th> 
        <th>Dias retraso</th> 
        </thead>               
        <tbody>          
        </tbody>
    </table>                    
</fieldset>

<script src="js/onLoad.js" type="text/javascript"></script>


<script   type="text/javascript">


    $("#bandejaLicencias").dataTable({
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
            sZeroRecords: "Sin servicios por caducar",
            sEmptyTable: "Sin servicios por caducar",
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
        },
        "fnRowCallback": function (nRow, aData, iDisplayIndex) {

            if (aData[4] !== "")
            {
                $(nRow).addClass("table-primary");
            } else if (aData[5] !== "")
            {
                $(nRow).addClass("table-danger");
            }
        }
    });

</script>