<!DOCTYPE html>
<html>

    <head>
        <title>GSR</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <meta name="viewport" content="width=device-width initial-scale=1.0 maximum-scale=1.0 user-scalable=yes" />

        <link href="js/css/bootstrap.min.css" rel="stylesheet" type="text/css"/> 
        <link href="js/css/datatables.min.css" rel="stylesheet" type="text/css"/>  
        <link href="js/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <link href="js/jquery-ui.theme.min.css" rel="stylesheet" type="text/css"/>

        <link href="js/css/jquery.mmenu.all.css" rel="stylesheet" type="text/css"/>
        <link href="js/css/jquery.mmenu.themes.css" rel="stylesheet" type="text/css"/>


        <script src="js/jquery.js" type="text/javascript"></script>
        <script src="js/jquery-ui.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>    
        <script src="js/jquery.dataTables.min.js" type="text/javascript"></script>   

        <script src="js/jquery.mmenu.all.js" type="text/javascript"></script>



        <style>

            #menu {
                /* --mm-color-background: #ABA5A5;*/
            }

            h3, .white{
                color: white;
            }
            
            .title{
                padding: 10px 10px 10px 10px;
                margin: 10px 50px 0px 10px;
                  
                background-color: #e3e7ea;
            }
            
            body{                
                background-color: #f1f3f4;
            }

            #callMenu{
                background:url("js/images/menu.png")  no-repeat;
                width:32px; 
                height:32px;
                display: block;
                float: left;
            }

            #callMenu {
                -webkit-user-select: none;
                -khtml-user-select: none;
                -moz-user-select: none;
                -o-user-select: none;
                user-select: none;
            }

            fieldset{
                border: solid 1px #DDD !important;
                padding: 10px 10px 10px 10px;
                margin: 10px 50px 10px 10px;
                border-bottom: none;   
                background-color: #ffffff ;
            }

            legend{
                width:inherit; 
                padding:0 10px; 
                border-bottom:none;
                font-size: 12pt;
            }

            .adjust{

                background-color: red;
                display:inline;
                overflow:hidden;
            }

            .adjust fieldset{
                float:left;                
            }

            #personIcon{
                background:url("js/images/man.png")  no-repeat;
            }

            #logout, #personIcon{                
                width:24px; 
                height:24px;
                display: block;
                float: right;
            }


        </style>

        <script type="text/javascript">
            $(document).ready(function () {

                $('nav#menu').mmenu({
                  /*  extensions: ["theme-dark"]*/
                });

                $("submit").submit(function (e) {
                    e.preventDefault();
                });

                $(".link").click(function () {

                    $.ajax({
                        type: "GET",
                        url: "./GetPage",
                        data: {"table": this.id},
                        success: function (data)
                        {
                            $("#container").empty();
                            $("#container").html(data);
                        }
                    });
                    
                    $("#inicio").click();

                });



            });//Document ready
        </script>
    </head>
    <body>

        <div class="navbar navbar-expand-md navbar-dark bg-dark box-shadow" id="header">
            <div class="col-md-1">
                <a href="#menu"><span id="callMenu"></span></a>
            </div>
            <div class="col-md-9 text-center text-muted">
                <h3 >GSR SERVICIOS CORPORATIVOS INDUSTRIALES</h3> 				
            </div>
            <div class="col-md-2">
                <span class="white"> Usuario Invitado</span><span class="ui-icon ui-icon-caret-1-s"></span><span id="personIcon"></span>
            </div>
        </div>
        
        <div  id="container" class="container">

            <nav id="menu">
                <ul>
                    <li><a id="inicio" href="#">Inicio</a></li>
                    <li><span>Unidad</span>
                        <ul>
                            <li><a id="Unidad" class="link" href="#">Unidades</a></li>
                            <li><a id="ProgramacionServicios" class="link" href="#">Programacion de Servicios</a></li>
                            <li><a id="Servicios" class="link" href="#">Servicios</a></li>
                        </ul>
                    </li>
                    <li><a id="Trabajador" class="link" href="#">Trabajador</a></li>
                    <!--<li class="Divider">Other demos</li>-->
                    <li><a id="AlertasProgramas" class="link" href="#">Alertas de programas</a>  </li>
                    <li><a id="SalidaCampo" class="link" href="#">Salidas a Campo</a>   </li>
                </ul>
            </nav>

            <!-- MODAL -->
            <div class="modal " id="catalogoModal" role="dialog"  aria-hidden="true">
                <div class="modal-dialog modal-lg" >
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="tituloModal"></h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">   

                        </div>
                        <div class="modal-footer">
                            <button type="button"  id="close_modal" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                            <button type="button" id="catalog_row_accept" class="btn btn-primary">Aceptar</button>
                            <input type="hidden"  id="modal-target" input-target=""   />
                        </div>
                    </div>
                </div>
            </div> <!-- MODAL -->           
        </div> <!-- CONTAINER -->
        
    </body>
</html>