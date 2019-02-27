
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>



<html xmlns="http://www.w3.org/1999/xhtml">

    <script>
        var URLactual = window.location;
        if (URLactual == "http://samgo.edugem.gob.mx/") {
            location.href = "https://samgo.edugem.gob.mx/";
        }
    </script>

    <head>

        <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
                <meta name="description" content="">
                    <meta name="author" content="">

                        <title>Resume - Start Bootstrap Theme</title>

                        <!-- Bootstrap core CSS -->
                        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>

                        <!-- Custom fonts for this template -->
                        <link href="https://fonts.googleapis.com/css?family=Saira+Extra+Condensed:500,700" rel="stylesheet"/>
                        <link href="https://fonts.googleapis.com/css?family=Muli:400,400i,800,800i" rel="stylesheet"/>
                        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"/>

                        <!-- Custom styles for this template -->
                        <link href="css/resume.min.css" rel="stylesheet"/>

                        <script type="text/javascript">

                            function guarda(accion) {

                                document.formulario.action = accion;
                                document.formulario.submit();
                            }


                            //PARA REGRESAR EN DONDE SE QUEDO...........
                            window.onload = function () {
                                var pos = window.name || 0;
                                window.scrollTo(0, pos);
                            }
                            window.onunload = function () {
                                window.name = self.pageYOffset
                                        || (document.documentElement.scrollTop + document.body.scrollTop);
                            }
                        </script>    

                        </head>

                        <body onload="document.getElementById('cveusuario').focus();">

                            <s:form name="formulario"  action="verAcceso">
                                <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="sideNav" style="background: #072146; " >

                                    <a class="navbar-brand js-scroll-trigger" href="#page-top" >

                                        <span class="d-none d-lg-block" >
                                            <img class="img-fluid img-profile rounded-circle mx-auto mb-2" src="img/m.png" alt="" style="z-index: 1;  " >
                                        </span>
                                    </a>

                                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                                        <ul class="navbar-nav">


                                        </ul>
                                    </div>
                                </nav>

                                <div class="container-fluid p-0">





                                    <div style="background: #072146; width: 98%;  margin: auto; height: 120px;  text-align: center; color:white;  font-size: 20px; padding: 20px; text-transform: uppercase; margin-top: 10px; border-radius: 5px;">  <h3 class="mb-0" style="font-size: 40px; color: #95a0b0;"> Plataforma de actualización del manual general de organización de la SEDUC</h3></div>

                                    <div style="    width: 98%;  margin: auto; min-height:  400px; max-height: 500px;  text-align: center; color:white;  font-size: 20px; padding: 20px; text-transform: uppercase; margin-top: 100px;"> 

                                        <div style="width: 70%; margin: auto;">

                                            <hr class="m-0"></hr>
                                            <div style="min-height:270px; max-height: 280px; width: 45%;   border-radius: 15px; margin: auto; margin-top: 60px;  ">

                                                <div class="mb-1" style="width: 100%; height: 40px; color:#072146; margin-bottom: 30px; font-size: 24px;  "><h3 class="mb-0" style="color: #95a0b0;"> <i class="fa fa-user" style="color: #072146;"></i> Acceso</h3></div>


                                                <s:textfield name="cveusuario" id="cveusuario" cssStyle="background-color: #072146;    border: 0; height: 55px; color: white; width:100%; border-radius:20px; padding: 10px; margin:auto; text-align:center " placeholder="Usuario" > </s:textfield>

                                                <s:password name="pasusuario" id="pasusuario" cssStyle="background-color: #072146;    border: 0; height: 55px; color: white; width:100%; border-radius:20px; padding: 10px; margin:auto; margin-top: 20px; text-align:center; " placeholder="Contraseña" > </s:password>

                                                <s:submit cssClass="btn col-12 btn-success" style="margin-top: 35px; height: 50px; border-radius: 10px;" value="Accesar"></s:submit>

                                                </div>
                                                <div class="col-lg-12">
                                                <s:fielderror fieldName="ErrorUsuario" cssClass="alert alert-danger"></s:fielderror>
                                                <s:fielderror fieldName="ErrorPass" cssClass="alert alert-danger"></s:fielderror>
                                                <s:fielderror fieldName="UsuarioNoValido" cssClass="alert alert-danger"></s:fielderror>
                                                </div>   

                                                <hr class="m-0"></hr>
                                            </div>





                                        </div>






                                        <br></br>

                                        <br></br>
                                        <br></br>
                                        <br></br>
                                        <br></br>


                                        <footer class="footer text-center bg-primary"  style="height: 200px;" >



                                            <div class="row" style="width: 100%; ">
                                                <div class="form-group col-lg-4"style="margin: auto; color:white; ; text-align: center; margin-top: 30px; ">

                                                    <div style="width: 100%; height: 25px; display: block; text-decoration: underline; ">Aviso de Privacidad</div>
                                                    <div style="width: 80%; height: 25px; display: block; margin: auto; margin-top: 15px;">Consulta nuestro aviso de privacidad</div>



                                                </div>  

                                                <div class="form-group col-lg-4"style="margin: auto; color:white;  text-align: center; margin-top: 30px;">

                                                    <div style="width: 100%; height: 25px; display: block; text-decoration: underline;">Enlaces de intéres</div>
                                                    <div style="width: 80%; height: 25px; display: block; margin: auto; margin-top: 15px;">Gobierno del Estado de México</div>
                                                    <div style="width: 80%; height: 25px; display: block; margin: auto;">Secretaría de Educación del Estado de México </div>



                                                </div>  

                                                <div class="form-group col-lg-4"style="margin: auto; color:white;  text-align: center; margin-top: 30px;">

                                                    <div style="width: 100%; height: 25px; display: block;  text-decoration: underline;">Acerca del portal</div>
                                                    <div style="width: 100%; height: 10px; display: inline; margin: auto; margin-top: 15px;">Unidad de Desarrollo Administrativo e Informática</div>
                                                    <div style="width: 100%; height: 10px; display: inline; margin: auto; margin-top: 15px;">Para asistencia y soporte técnico sobre este sistema:</div>
                                                    <div style="width: 100%; height: 10px; display: inline; margin: auto; margin-top: 15px;">mesadeservicios@edugem.gob.mx</div>
                                                    <div style="width: 100%; height: 10px; display: inline; margin: auto; margin-top: 15px;">Llamanos (01 722) 2264304</div>


                                                </div>  

                                            </div>

                                        </footer> 



                                    </div>
                            </s:form>

                            <!-- Bootstrap core JavaScript -->
                            <script src="vendor/jquery/jquery.min.js"></script>
                            <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

                            <!-- Plugin JavaScript -->
                            <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

                            <!-- Custom scripts for this template -->
                            <script src="js/resume.min.js"></script>



                        </body>

                        </html>
