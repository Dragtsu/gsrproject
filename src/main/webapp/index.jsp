<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <title>GSR</title>

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

        <script type="text/javascript">
            $(document).ready(function () {
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
                });
            });
        </script>
    </head>
    <body>
        
          <!-- Modal -->
        <div class="modal " id="catalogoModal" role="dialog"  aria-hidden="true">
            <div class="modal-dialog modal-lg" >
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="tituloModal">Modal title</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">   

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary">Save changes</button>
                    </div>
                </div>
            </div>
        </div>
          <!-- Modal -->

      
        <div class="wrapper">
             <nav id="sidebar">
            <div class="sidebar-header">
                <h3></h3>
            </div>

            <ul class="list-unstyled components">
                <p></p>
                <li class="active">
                    <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Unidad</a>
                    <ul class="collapse list-unstyled" id="homeSubmenu">
                        <li>
                            <a id="vehicle" class="link" href="#">Unidades</a>
                        </li>
                        <li>
                            <a id="mantos" href="#">Programas de Mantenimiento</a>
                        </li>  
                        <li>
                            <a id="tManto" class="link" href="#">Tipos Mantenimiento</a>
                        </li>                       
                    </ul>
                </li>
                <li>
                    <a id="worker" class="link" href="#">Trabajador</a>                    
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
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Salir</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>




                <div id="container">


                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#catalogoModal">
                        Launch demo modal
                    </button>

                </div>



            </div>    <!-- CONTENT -->        
        </div>
    </body>
</html>