package action;



//BEANS
import beans.moduloBean;
import beans.moduloAuxBean;
import beans.usuarioBean;
import beans.Navegacion;
import beans.datosBean;
import business.AccesoBusiness;
import business.ConsultaBusiness;
//BUSINESS


//SESION
import java.util.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import utilidades.Constantes;

 
public class Acceso_Action extends ActionSupport implements SessionAware{
    
    //Uusario
    private usuarioBean usuariocons;
    private String cveusuario;
    private String pasusuario;
    private String nomModulo;
    private String modulo;
    private String nombreUsuario;
    
    //LISTAS PERSISTENTES DEL MENU
    public List <moduloBean> modulosAUX = new ArrayList<moduloBean>();
    public List <moduloAuxBean> modulosAUXP = new ArrayList<moduloAuxBean>();

	//SESSIN USUARIO	
   
   // private Map session  = ActionContext.getContext().getSession();
    private String nivelUsuario;	  

    //Exception
    private String TipoError;
    private String TipoException;



    //******************** PARA OBJETO DE NAVEGACIoN ***********************************************
    private Map session;
    Navegacion objNaveg;
    String ligaRegreso = Navegacion.InitialPage;
    String ligaActual =	"";
    
    
    
    
     datosBean datos = new datosBean();
    
    
    
    
     private ArrayList<datosBean> ListaDatos = new ArrayList<>();
     
     private ArrayList<datosBean> ListaFuenciones = new ArrayList<>();

   
     
     
     public ArrayList<datosBean> getListaFuenciones() {
        return ListaFuenciones;
    }

    public void setListaFuenciones(ArrayList<datosBean> ListaFuenciones) {
        this.ListaFuenciones = ListaFuenciones;
    }
     
     

    public String getNivelUsuario() {
        return nivelUsuario;
    }

    public void setNivelUsuario(String nivelUsuario) {
        this.nivelUsuario = nivelUsuario;
    }

    public Navegacion getObjNaveg() {
        return objNaveg;
    }

    public void setObjNaveg(Navegacion objNaveg) {
        this.objNaveg = objNaveg;
    }

    public String getLigaActual() {
        return ligaActual;
    }

    public void setLigaActual(String ligaActual) {
        this.ligaActual = ligaActual;
    }

    public datosBean getDatos() {
        return datos;
    }

    public void setDatos(datosBean datos) {
        this.datos = datos;
    }

    public ArrayList<datosBean> getListaDatos() {
        return ListaDatos;
    }

    public void setListaDatos(ArrayList<datosBean> ListaDatos) {
        this.ListaDatos = ListaDatos;
    }
    
    
    
    
    

    public void setSession(Map session) {
        this.session = session;
    }

    public Map getSession() {
        return session;
    }

    public String getLigaRegreso() {
        return ligaRegreso;
    }

    public void setLigaRegreso(String ligaRegreso) {
        this.ligaRegreso = ligaRegreso;
    }

    private void generaNavegacion(String action, String ligaActual){

        objNaveg = (Navegacion) session.get("navegacion");

        if (objNaveg!=null){
            ligaRegreso = objNaveg.getReturnPath(ligaActual, action);
        }else{
            objNaveg = new Navegacion();
            objNaveg.Push(ligaActual, action);
        }
        session.remove("navegacion");
        session.put("navegacion",objNaveg);
    }
    //******************** TERMINA OBJETO DE NAVEGACIoN **********************************************

    
    public String MuestraMenuPrincipalUsuario() {
        if(cveusuario!=null){
            session.put("cveUsuario", cveusuario);
            session.put("psw", pasusuario);
        }else if(session.get("cveUsuario")!=null){
            cveusuario = (String) session.get("cveUsuario");
            pasusuario = (String) session.get("psw");
        }

        try {

            //Se crea un nuevo objeto de acceco a Business
            AccesoBusiness acceso = new AccesoBusiness();
            usuariocons = acceso.consultaUsuario(cveusuario, pasusuario);

            if(usuariocons!=null){
                
                session.put("usuario",usuariocons);

                //obteniendo el nombre del usuario
                nombreUsuario=  usuariocons.getNAMEUSUARIO();
                
                
                 ConsultaBusiness con = new ConsultaBusiness();
                 
                 datos.setUSUARIO(nombreUsuario);
            
            datos.setCVE_CUNIDAD_CONSULTA(usuariocons.getCVE_UNIDAD());
            
                 
            
            
            
              ListaDatos= (ArrayList<datosBean>) con.listaDatos(datos);
            
            if(ListaDatos.size()>0){
                
                  ListaDatos= (ArrayList<datosBean>) con.listaDatos(datos);
                 
                   
                   Iterator LD =ListaDatos.iterator();
                   
                   
                   datosBean obj;
                   
                 while (LD.hasNext()) {
                    obj = (datosBean) LD.next();
                    
                    datos.setUNIDAD(obj.getUNIDAD());
                    datos.setCVE_UNIDAD(obj.getCVE_UNIDAD());
                    
                    datos.setFECHA_DOC(obj.getFECHA_DOC());
                    datos.setFECHA_ACT_OBJ(obj.getRES_ACT_OBJ()+"-"+obj.getFECHA_ACT_OBJ());
                     datos.setOBJETIVO(obj.getOBJETIVO());
                   datos.setCOMENTARIOS(obj.getCOMENTARIOS());
                   datos.setFECHA_ACT_COM(obj.getRES_ACT_COM()+"-"+obj.getFECHA_ACT_COM());
                    datos.setESTATUS_OBJETIVO(obj.getESTATUS_OBJETIVO());
                     datos.setESTATUS_COMENTARIO(obj.getESTATUS_COMENTARIO());
                      datos.setESTATUS_FUNCION(obj.getESTATUS_FUNCION());
                       datos.setRES_RE(obj.getRES_RE());
                         datos.setRES_AUT(obj.getRES_AUT());
                    
                    
                }
             
                ListaFuenciones= (ArrayList<datosBean>) con.listaFunciones(datos);
                  
            }
            else {
                
                acceso.guardaDato(datos);
                
                
                 ListaDatos= (ArrayList<datosBean>) con.listaDatos(datos);
                 
                   
                   Iterator LD =ListaDatos.iterator();
                   
                   
                   datosBean obj;
                   
                 while (LD.hasNext()) {
                    obj = (datosBean) LD.next();
                    
                    datos.setUNIDAD(obj.getUNIDAD());
                    datos.setCVE_UNIDAD(obj.getCVE_UNIDAD());
                    
                    datos.setFECHA_DOC(obj.getFECHA_DOC());
                    datos.setFECHA_ACT_OBJ(obj.getRES_ACT_OBJ()+"-"+obj.getFECHA_DOC());
                     datos.setOBJETIVO(obj.getOBJETIVO());
                   datos.setCOMENTARIOS(obj.getCOMENTARIOS());
                   datos.setFECHA_ACT_COM(obj.getRES_ACT_COM()+"-"+obj.getFECHA_ACT_COM());
                    
                    
                    
                    
                    
                    
                }
             
                ListaFuenciones= (ArrayList<datosBean>) con.listaFunciones(datos);
                
                
                
                
                
            }
            
            
            
            
            
            
            
            
            
            
          
                   
                 
                  
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                

                
                Constantes.enviaMensajeConsola("voy a successs-----------------------");
                return "SUCCESS";
            }else{
                addFieldError("UsuarioNoValido","Usuario no valido, favor de verificar");
                return "ERROR";
            }
         

        } catch (Exception e) {
            TipoError="SESSION";
            TipoException=e.getMessage();
            return "ERROR";
        }
    }

    
   
    
    
    
	public String verMevu(){
		  try {		
			  		     
			 //...retomando
			 
	     }catch (Exception e) {
				addActionError("Ocurrio un error: "+e );
				return "ERROR";
			}
			return "SUCCESS";
	}
	
    
    @SkipValidation
    public String cerrar(){
        if(session!=null){
            System.out.println("termino la session");
            session.clear();
        }
        return "SUCCESS";
    }


    //VALIDACIONES
    @Override
   public void validate() {

        try {

            if (cveusuario.length() == 0) {
                addFieldError("ErrorUsuario", "Debe Capturar el  Usuario");
            }

            if (pasusuario.length() == 0) {
                addFieldError("ErrorPass", "Debe Capturar la Contraseña del Usuario");
            }

        } catch (Exception ex) {
            TipoError="SESSION";
            TipoException=ex.getMessage();
        }
    }

	public usuarioBean getUsuariocons() {
		return usuariocons;
	}

	public void setUsuariocons(usuarioBean usuariocons) {
		this.usuariocons = usuariocons;
	}

	public String getCveusuario() {
		return cveusuario;
	}

	public void setCveusuario(String cveusuario) {
		this.cveusuario = cveusuario;
	}

	public String getPasusuario() {
		return pasusuario;
	}

	public void setPasusuario(String pasusuario) {
		this.pasusuario = pasusuario;
	}

	public String getNomModulo() {
		return nomModulo;
	}

	public void setNomModulo(String nomModulo) {
		this.nomModulo = nomModulo;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	
	public String getTipoError() {
		return TipoError;
	}

	public void setTipoError(String tipoError) {
		TipoError = tipoError;
	}

	public String getTipoException() {
		return TipoException;
	}

	public void setTipoException(String tipoException) {
		TipoException = tipoException;
	}

	public List<moduloBean> getModulosAUX() {
		return modulosAUX;
	}

	public void setModulosAUX(List<moduloBean> modulosAUX) {
		this.modulosAUX = modulosAUX;
	}

	public List<moduloAuxBean> getModulosAUXP() {
		return modulosAUXP;
	}

	public void setModulosAUXP(List<moduloAuxBean> modulosAUXP) {
		this.modulosAUXP = modulosAUXP;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
}