<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <title>Collapsible sidebar using Bootstrap 4</title>



        <link href="js/style5.css" rel="stylesheet" type="text/css"/>
        <link href="js/bootstrap.min.css" rel="stylesheet" type="text/css"/>    
        <link href="js/jquery-ui.theme.min.css" rel="stylesheet" type="text/css"/>      
        <link href="js/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <!--<link href="js/jquery-ui.structure.min.css" rel="stylesheet" type="text/css"/>-->
        <link href="js/datatables.min.css" rel="stylesheet" type="text/css"/>


        <script src="js/jquery-3.3.1.js" type="text/javascript"></script>     
        <script src="js/jquery-ui.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script> 
        <script src="js/popper.min.js" type="text/javascript"></script>           
        <script src="js/jquery.dataTables.min.js" type="text/javascript"></script>          

        <style>



            fieldset{
                border: solid 1px #DDD !important;
                padding: 10px 10px 10px 10px;
                margin: 10px 50px 10px 10px;
                border-bottom: none;                
            }

            legend{
                width:inherit; /* Or auto */
                padding:0 10px; /* To give a bit of padding on the left and right */
                border-bottom:none;
            }


            .adjust{

                background-color: red;
                display:inline;
                overflow:hidden;
            }

            .adjust fieldset{
                float:left;                
            }

        </style>

    </head>

    <body>

        <div class="wrapper">

            <nav id="sidebar">
                <div class="sidebar-header">
                    <h3>GSR</h3>
                </div>

                <ul class="">
                    <p>HERE</p>
                    <li class="active">
                        <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Home</a>
                        <ul class="collapse list-unstyled" id="homeSubmenu">
                            <li>
                                <a href="#">Home 1</a>
                            </li>
                            <li>
                                <a href="#">Home 2</a>
                            </li>
                            <li>
                                <a href="#">Home 3</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">Trabajador</a>
                        <a href="#pageSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Pages</a>
                        <ul class="collapse list-unstyled" id="pageSubmenu">
                            <li>
                                <a href="#">Page 1</a>
                            </li>
                            <li>
                                <a href="#">Page 2</a>
                            </li>
                            <li>
                                <a href="#">Page 3</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">Portfolio</a>
                    </li>
                    <li>
                        <a href="#">Contact</a>
                    </li>
                </ul>

                <ul class="list-unstyled CTAs">
                    <li>
                        <a href="https://bootstrapious.com/tutorial/files/sidebar.zip" class="download">Download source</a>
                    </li>
                    <li>
                        <a href="https://bootstrapious.com/p/bootstrap-sidebar" class="article">Back to article</a>
                    </li>
                </ul>
            </nav>


            <div id="content">

                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container-fluid">

                        <button type="button" id="sidebarCollapse" class="navbar-btn">
                            <span></span>
                            <span></span>
                            <span></span>
                        </button>
                        <button class="btn btn-dark d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <i class="fas fa-align-justify"></i>
                        </button>

                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="nav navbar-nav ml-auto">
                                <li class="nav-item active">
                                    <a class="nav-link" href="#">Page</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Page</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Page</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Page</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>

                <h2 id="Titulo">Trabajador</h2>


                <div>

                    <fieldset class="form-group">                        

                        <form>
                            <table>                                
                                <tr><td>Numero Celular:</td><td><input type="text" name="Num_Celular" class="readOnly" maxlength="10"></td></tr>
                                <tr><td>Nombre:</td><td><input type="text" name="Nombre" maxlength="25"></td></tr>
                                <tr><td>Apellido Paterno:</td><td><input type="text" name="Apellido_Paterno" maxlength="15"></td></tr>
                                <tr><td>Apellido Materno:</td><td><input type="text" name="Apellido_Materno" maxlength="15"></td></tr>
                                <tr><td>Fecha Vencimiento Licencia:</td><td><input  type="text" name="Vigencia_Licencia" id="datepicker" readOnly maxlength="10"></td></tr>
                            </table>

                            <div class="adjust">
                                <fieldset>
                                    <input type="hidden" name="table" value="worker" id="tableShow">                                                                      
                                    <input type="button" id="save" value="Guardar"/>
                                    <input type="button" id="limpiar" value="Limpiar"/>
                                    <input type="button" value="Cancelar" id="cancelarBt" style="display:none;">                           
                                </fieldset>
                            </div>
                        </form>
                    </fieldset>
                </div> 


                <fieldset>
                    <div class="adjust">
                        <fieldset>
                            <input type="button" value="Eliminar" id="deleteBt">     
                            <input type="button" value="Modificar" id="updateBt">     
                            <input type="text"   id="sSearch" maxlength="10">
                            <input type="button" value="Buscar" id="buscarBt">  
                            <input type="button" value="Limpiar" id="limpiaBuscar"> 
                            
                        </fieldset>
                    </div>                    
                    <table class="display dataTablex">
                        <thead>
                        <th>Numero Celular</th>
                        <th>Nombre</th>
                        <th>Apellido Paterno</th>
                        <th>Apellido Materno</th>
                        <th>Fecha Vencimiento Licencia</th>
                        </thead>               
                        <tbody></tbody>
                    </table>                    
                </fieldset>

            </div>            
        </div>




        <script type="text/javascript">



            $(document).ready(function () {


                function limpiaFormulario() {
                    $("form input:text").val("");
                    $("#sSearch").val();
                }

                limpiaFormulario();

                function reloadTable() {
                    $('.dataTablex').dataTable().api().ajax.reload();
                }

                $('#sidebarCollapse').on('click', function () {
                    $('#sidebar').toggleClass('active');
                    $(this).toggleClass('active');
                });

                $("#datepicker").datepicker({
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


                    var url = "./api/save";

                    if ($("#cancelarBt").is(":visible"))
                        url = "./api/update";
                    $.ajax({
                        type: "GET",
                        url: url,
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
                    }/*,
                     aoColumns: [
                     {sName: "Num_Celular"},
                     {sName: "Nombre"},
                     {sName: "Apellido_Paterno"},
                     {sName: "Apellido_Materno"},
                     {sName: "Vigencia_Licencia"}
                     ]*/
                });

                $('.dataTablex tbody').on('click', 'tr', function () {

                    $(".selected").removeClass('selected');
                    $(this).addClass('selected');
                });

                $("#updateBt").click(function () {

                    $('.selected td').each(function () {

                        $('form input[type=text]').eq($(this).index()).val($(this).html());
                    });
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

            }); //Document ready
        </script>
    </body>

</html>