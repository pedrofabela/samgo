
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>

<script type="text/javascript">

   


    function Accion(accion) {

        document.formularioPrincipal.action = accion;
        document.formularioPrincipal.submit();
    }

    
      function borrar(accion, valor) {

                                    document.formularioPrincipal.ID_FUNCION_CAMPO.value = valor;
                                    document.formularioPrincipal.action = accion;
                                    document.formularioPrincipal.target = "_self";
                                    document.formularioPrincipal.submit();

                                }
       function popup(id_funcion, funcion) {
       
      
      location.href ="#popup";
     
        
       
         document.formularioPrincipal.ID_FUNCION_CAMPO.value = id_funcion;
         document.getElementById('ACT_FUNCION').value = funcion;
         
         
         
         
         
    }
    
    window.onload = function() {
            	  var pos = window.name || 0;
            	  window.scrollTo(0, pos);
            	 }
            	 window.onunload = function() {
            	 window.name = self.pageYOffset
            	    || (document.documentElement.scrollTop + document.body.scrollTop);
            	 }
    
    

    //PARA REGRESAR EN DONDE SE QUEDO...........


</script>




<html xmlns="http://www.w3.org/1999/xhtml">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Resume - Start Bootstrap Theme</title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="https://fonts.googleapis.com/css?family=Saira+Extra+Condensed:500,700" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Muli:400,400i,800,800i" rel="stylesheet">
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/resume.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/estilo.css"/>

</head>

    <body id="page-top"> 
        
        <s:form name="formularioPrincipal" id="formularioPrincipal">

  <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="sideNav" style="background: #072146; " >
    
     
      
      
      
      
      <a class="navbar-brand js-scroll-trigger" href="#page-top" >
      <span class="d-block d-lg-none">Clarence Taylor</span>
      <span class="d-none d-lg-block" >
          <img class="img-fluid img-profile rounded-circle mx-auto mb-2" src="img/m.png" alt="" style="z-index: 1;  " >
      </span>
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link js-scroll-trigger" href="#">Inicio</a>
        </li>
        <li class="nav-item">
          <a class="nav-link js-scroll-trigger" href="#experience">Experience</a>
        </li>
       
      </ul>
    </div>
  </nav>

  <div class="container-fluid p-0">
      
      
                  
   
      
      <div style="background: #072146; width: 98%;  margin: auto; height: 120px;  text-align: center; color:white;  font-size: 20px; padding: 20px; text-transform: uppercase; margin-top: 10px; border-radius: 5px;">  <h3 class="mb-0" style="font-size: 40px; color: #95a0b0;"> Sistema de actualización del manual general de organización de la SEDUC</h3></div>

      
      <div style="margin-top: 40px;"> 
      
          
          <div class="mb-1" style="width: 100%; height: 40px; color:#072146; margin-bottom: 30px; font-size: 24px; margin: auto; text-align: center; "><h3 class="mb-0" style="color: #95a0b0;"> Actualización del Manual General de Organización </h3></div>

      
      
                    <hr class="m-0"></hr>
      
      
      
                    <table style="width: 80%; margin: auto; margin-top: 20px;">

                        <tr style="font-weight: bold; background: #e9e8e8; height: 40px;">
                            <td style="width: 25%; ">Código</td>
                            <td style="width: 50%;">Unidad Administrativa</td>
                            <td style="width: 25%;">Fecha</td>

                        </tr>


                        <tr>

                            <td style="width: 25%;"><s:property value="datos.CVE_UNIDAD"></s:property> </td>
                            <td style="width: 50%;"><s:property value="datos.UNIDAD"></s:property> </td>
                            <td style="width: 25%;"><s:property value="datos.FECHA_DOC"></s:property></td>
                        </tr>


                    </table>   
                    
                    
                    
                    
                    <table style="width: 80%; margin: auto; margin-top: 40px; ">

                        <tr style="font-weight: bold; background: #e9e8e8; height: 40px;">
                            <td style="width: 75%; ">Objetivo</td>
                            <td style="width: 25%;"><div style="font-size: 12px; padding: 10px;"><s:radio label="Answer" name="datos.ESTATUS_OBJETIVO" id="ESTATUS_OBJETIVO" list="#{'1':'Actualizado','0':'Sin Cambios '}"  /></div></td>
                            

                        </tr>


                        <tr>

                            <td style="width: 75%;"><s:textarea name="datos.OBJETIVO" id="datos.OBJETIVO" cssStyle="width: 90%; height: 100px;" cols="40" rows="10" ></s:textarea> </td>
                        <td style="width: 25%;"><div style="color:green"> <s:property value="datos.FECHA_ACT_OBJ"></s:property></div></td>
                           
                        </tr>
                            
                        <tr>

                            <td style="width: 75%;"><a href="Javascript:Accion('guardaObjetivo')"><div class="btn btn-success" style="margin-top: 10px;"> Guardar Objetivo</div></a></td>
                            <td style="width: 25%;"> </td>
                           
                        </tr>
                            
                            <tr>
                                <td colspan="2"> <s:fielderror fieldName="gobj" cssClass="alert alert-success" cssStyle="font-size: 12px; margin-top: 00px; margin-botton:40px;"/> </td>
                            </tr>


                    </table>   
                            
                            
        <div class="mb-1" style="width: 100%; height: 40px; color:#072146; margin-bottom: 30px; font-size: 24px; margin: auto; text-align: center; margin-top: 30px;"><h3 class="mb-0" style="color: #95a0b0;"> Funciones </h3>  </div>
  

                            <table style="width: 80%; margin: auto; margin-top: 40px; ">

                                <tr style="font-weight: bold; background: #e9e8e8; height: 40px;">
                                    <td style="width: 70%; ">Nueva Función</td>
                                    <td style="width: 25%;"><div style="font-size: 12px; padding: 10px;"><s:radio label="Answer" name="datos.ESTATUS_FUNCION" id="ESTATUS_FUNCION" list="#{'1':'Actualizado','0':'Sin Cambios '}"  onchange="javascript:Accion('actualizaEstatusFuncion')" /></div></td>


                                </tr>


                                <tr>

                                    <td style="width: 70%;"><s:textarea name="datos.FUNCION" id="datos.FUNCION" cssStyle="width: 90%; height: 100px;" cols="40" rows="10"></s:textarea> </td>
                                <td style="width: 25%;"><a href="Javascript:Accion('nuevafuncion')"><div class="btn btn-success" style="margin-top: 10px;"> Guardar Función</div></a> </td>

                            </tr>
                                
                                <tr>
                                <td colspan="2"> <s:fielderror fieldName="gfun" cssClass="alert alert-success" cssStyle="font-size: 12px; margin-top: 00px; margin-botton:40px;"/> </td>
                            </tr>




                           </table>   

        
        
        
        
        
        
        
        
        
        
        
                                <div style="height: 400px; overflow-y:  scroll; margin-top: 20px;" >
                                
                                <table  style="width:80% !important; margin: auto; margin-top: 10px; ">

                                    <tr style="font-weight: bold;  background: #e9e8e8; height: 40px;">
                                        <td  >Función </td>
                                        <td  >Última Actualización</td>
                                         <td >Modificar</td>
                                          <td >Eliminar</td>
                                        
                                        
                                    </tr>
                                   
                                <s:iterator value="ListaFuenciones" id="ListaFuenciones" status="stat">
                                    <tr style="border: 1px solid #999;">

                                        <td style="width: 50%; "> <div style="text-wrap: normal; padding: 5px;"><s:property value="FUNCION" /> </div> </td>
                                    <td style="width: 30%;" ><div style="text-wrap: normal; padding: 5px; color:green;"><s:property value="RES_ACT_FUNCION" /> -<s:property value="FECHA_ACT_FUNCION"/></div> </td>
                                    <td style="width: 10%;" align="center" ><div style="text-wrap: normal; padding: 5px;"> <a href="Javascript:popup('<s:property value="ID_FUNCION" />','<s:property value="FUNCION" />')"><span class="fa fa-edit" style="font-size: 30px; color: purple;"</span></a></div></td>
                                    <td  align="center"><a href="Javascript:borrar('borrarFuncion','<s:property value="ID_FUNCION"/>')"><i class="fa fa-trash" style="font-size:30px;color:red"></i></a></td>
                                </tr>
                                </s:iterator>
                                
                            </table>   
                                    
             </div>
                            <br></br>
                            <s:fielderror fieldName="afun" cssClass="alert alert-success" cssStyle="font-size: 12px; margin-top: 00px; margin-botton:40px;"/>
                            <s:fielderror fieldName="bfun" cssClass="alert alert-danger" cssStyle="font-size: 12px; margin-top: 00px; margin-botton:40px;"/>
                            
                            
                            <!-- COMENTARIOS -->
                            

                            <div class="mb-1" style="width: 100%; height: 40px; color:#072146; margin-bottom: 30px; font-size: 24px; margin: auto; text-align: center; margin-top: 30px;"><h3 class="mb-0" style="color: #95a0b0;"> Comentario </h3></div>


                            <table style="width: 80%; margin: auto; margin-top: 40px; ">

                                <tr style="font-weight: bold; background: #e9e8e8; height: 40px;">
                                    <td style="width: 75%; ">Comentario</td>
                                    <td style="width: 25%;"><div style="font-size: 12px; padding: 10px;"><s:radio label="Answer" name="datos.ESTATUS_COMENTARIO" id="ESTATUS_COMENTARIO" list="#{'1':'Actualizado','0':'Sin Cambios '}" /></div></td>
                                    


                                </tr>


                                <tr>

                                    <td style="width: 75%;"><s:textarea name="datos.COMENTARIOS" id="datos.COMENTARIOS" cssStyle="width: 90%; height: 100px;" cols="40" rows="10" ></s:textarea> </td>
                                <td style="width: 25%;"><a href="Javascript:Accion('guardaComentario')"><div class="btn btn-success" style="margin-top: 10px;"> Guardar Comentario</div></a> </td>

                            </tr>
                                
                                <tr >
                                    <td style="width: 75%; "><div style="color:green;">Última modificación: <s:property value="datos.FECHA_ACT_COM"></s:property></div></td>
                                    <td style="width: 25%;"></td>
                                    


                                </tr>
                                    
                                     <tr>
                                <td colspan="2"> <s:fielderror fieldName="gcom" cssClass="alert alert-success" cssStyle="font-size: 12px; margin-top: 00px; margin-botton:40px;"/> </td>
                            </tr>




                            </table>     
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
      
      
      </div>
      
           <div class="mb-1" style="width: 100%; height: 40px; color:#072146; margin-bottom: 30px; font-size: 24px; margin: auto; text-align: center; margin-top: 30px;"><h3 class="mb-0" style="color: #95a0b0;"> Responsables </h3></div>

      
                            <table style="width:80%; margin: auto; margin-top: 30px;">
                                
                                <tr>
                                    <td>
                                        <s:textfield name="datos.RES_RE" id="RES_RE" class="form-control" placeholder="Nombre de quien revisa"></s:textfield>
                                    </td>
                                    
                                      <td>
                                          <s:textfield name="datos.RES_AUT" id="RES_AUT" class="form-control" placeholder="Nombre de quien autoriza"></s:textfield>
                                    </td>
                                     <td style="width: 25%;"><a href="Javascript:Accion('guardaResponsables')"><div class="btn btn-success" style="margin-top: 10px;"> Guardar Responsables</div></a> </td>
                                </tr>
                                    <tr>
                                <td colspan="2"> <s:fielderror fieldName="res" cssClass="alert alert-success" cssStyle="font-size: 12px; margin-top: 00px; margin-botton:40px;"/> </td>
                                </tr>
                                
                            </table>
      
     
      

      
                    <hr class="m-0"></hr>
   

   
                    <br></br>
                    
                    <br></br>
                    <br></br>
                    <br></br>
                    <br></br>
                   
                    
                     <div class="modal-wrapper" id="popup">
                                                    <div class="popup-contenedor">
                                                        <h2  style="font-size: 16px;" >Actualización de Función </h2>

                                                        <div style="min-height:350px; max-height: 400px; overflow-y: scroll;" >
                                                            <div id="dvData">
                                                                 
                                                      
                                                           
                                                            
                                                        
                                                            
                                                            
                                                                           <div class="row">
                                                                        
                                                                        
                                                                        
                                                                        
                                                                     
                                                                        
                                                                        
                                                                        <div class="form-group col-lg-4">
                                                                        <label class="col-form-label " for="domicilio" >Función</label>
                                                                        <div class="col-sm-auto  ">
                                                                                  <s:textarea   name="datos.ACT_FUNCION" id="ACT_FUNCION" cols="40" rows="5" ></s:textarea >
                                                                        </div> 
                                                                        
                                                                        
                                                                        
                                                                        </div>  
                                                                        
                                                                    
                                                                        
                                                                   
                                                                      

                                                                          
                                                                            
                                                                            
                                                                            
                                                                      
                                                                    </div>
                                                      
                                                                
                                                                
                                                               
                                                                      <div class="col-sm-auto " style="margin-top: 60px;" >
                                                                                    <a class="btn btn-primary btn-lg" href="Javascript:Accion('actualizaFuncion')" style="background: green; margin-left: 0px;" ><i class="fa fa-user-plus"></i> Actualizar </a>
                                                                            </div>    
                                                                            
                                                                
                                                                
                                                                
                                                                
                                                            </div>
                                                             </div>
                                                            
                                                        <a class="popup-cerrar" href="#">X</a>
                                                    </div>
                                                </div>               
                    
                    
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
                                                <div style="width: 80%; height: 10px; display: block; margin: auto; margin-top: 15px;">Unidad de Desarrollo Administrativo e Informática</div>
                                                <div style="width: 80%; height: 10px; display: block; margin: auto; margin-top: 15px;">Para asistencia y soporte técnico sobre este sistema:</div>
                                                <div style="width: 80%; height: 10px; display: block; margin: auto; margin-top: 15px;">mesadeservicios@edugem.gob.mx</div>
                                                <div style="width: 80%; height: 10px; display: block; margin: auto; margin-top: 15px;">Llamanos (01 722) 2264304</div>


                                            </div>  

                                        </div>

                                    </footer> 

   

  </div>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Plugin JavaScript -->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for this template -->
  <script src="js/resume.min.js"></script>
  
                        <s:textfield name="datos.ID_FUNCION" id="ID_FUNCION_CAMPO" cssStyle="display:none;" />
  
  
  
</s:form>
</body>

</html>
