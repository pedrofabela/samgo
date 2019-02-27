/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import beans.Navegacion;
import beans.datosBean;
import beans.usuarioBean;
import business.ConsultaBusiness;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionContext;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;



public class ConsultasAccion extends ActionSupport implements SessionAware{
    

     private usuarioBean usuariocons;
    private String cveusuario;
    private String pasusuario;
    private String nomModulo;
    private String modulo;
    private String nombreUsuario;
    private String tabSelect;
    private Map session;
    Navegacion objNaveg; 
    String ligaRegreso= Navegacion.InitialPage;
    String ligaactual="";
     private String TipoError;
    private String TipoException;

      datosBean datos = new datosBean();
    
    
    
    
     private ArrayList<datosBean> ListaDatos = new ArrayList<>();
     private ArrayList<datosBean> ListaFuenciones = new ArrayList<>();
    
    
    
    
    
    
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

     
     
     
      public String iniciDoc() {

        //validando session***********************************************************************
        if (session.get("cveUsuario") != null) {
            String sUsu = (String) session.get("cveUsuario");
        } else {
            addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
            return "SESSION";
        }
        if (session.containsKey("usuario")) {
            usuariocons = (usuarioBean) session.get("usuario");
        } else {
            addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
            return "SESSION";
        }

        try {
            
            
             ConsultaBusiness con = new ConsultaBusiness();
            datos.setCVE_UNIDAD(usuariocons.getCVE_UNIDAD());
             datos.setUSUARIO(usuariocons.getNAMEUSUARIO());
             datos.setCVE_CUNIDAD_CONSULTA(usuariocons.getCVE_UNIDAD());
            
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
                    
                    
                    
                    
                    
                    
                }
             
                ListaFuenciones= (ArrayList<datosBean>) con.listaFunciones(datos);
             
             
            
            
            
            
            

            return "SUCCESS";

        } catch (Exception e) {

            TipoException = e.getMessage();
            return "ERROR";
        }
    }
     
     
       public String guardaObjetivo() {

        //validando session***********************************************************************
        if (session.get("cveUsuario") != null) {
            String sUsu = (String) session.get("cveUsuario");
        } else {
            addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
            return "SESSION";
        }
        if (session.containsKey("usuario")) {
            usuariocons = (usuarioBean) session.get("usuario");
        } else {
            addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
            return "SESSION";
        }

        try {
            
            
             ConsultaBusiness con = new ConsultaBusiness();
            
            String fecha=fecha();
            
             datos.setFECHA(fecha);
             datos.setCVE_UNIDAD(usuariocons.getCVE_UNIDAD());
             datos.setUSUARIO(usuariocons.getNAMEUSUARIO());
             
                 con.actualizaObjetivo(datos);
             
             
            
        iniciDoc();
        
        
            addFieldError("gobj", "Objetivo guardado");
            
           
            

            return "SUCCESS";

        } catch (Exception e) {

            TipoException = e.getMessage();
            return "ERROR";
        }
    }
       
        public String guardaComentario() {

        //validando session***********************************************************************
        if (session.get("cveUsuario") != null) {
            String sUsu = (String) session.get("cveUsuario");
        } else {
            addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
            return "SESSION";
        }
        if (session.containsKey("usuario")) {
            usuariocons = (usuarioBean) session.get("usuario");
        } else {
            addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
            return "SESSION";
        }

        try {
            
            
             ConsultaBusiness con = new ConsultaBusiness();
            
            String fecha=fecha();
            
             datos.setFECHA(fecha);
             datos.setCVE_UNIDAD(usuariocons.getCVE_UNIDAD());
             datos.setUSUARIO(usuariocons.getNAMEUSUARIO());
             
                 con.actualizaComentario(datos);
             
             
            
        iniciDoc();
            
             addFieldError("gcom", "Comentario guardado");

            return "SUCCESS";

        } catch (Exception e) {

            TipoException = e.getMessage();
            return "ERROR";
        }
    }
        
        
        public String nuevafuncion() {

        //validando session***********************************************************************
        if (session.get("cveUsuario") != null) {
            String sUsu = (String) session.get("cveUsuario");
        } else {
            addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
            return "SESSION";
        }
        if (session.containsKey("usuario")) {
            usuariocons = (usuarioBean) session.get("usuario");
        } else {
            addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
            return "SESSION";
        }

        try {
            
            
             ConsultaBusiness con = new ConsultaBusiness();
            
            String fecha=fecha();
            
             datos.setFECHA(fecha);
             datos.setCVE_UNIDAD(usuariocons.getCVE_UNIDAD());
             datos.setUSUARIO(usuariocons.getNAMEUSUARIO());
             
             con.guardaFuncion(datos);
             
             
            
             iniciDoc();
             
             addFieldError("gfun", "Función guardada");
            
            
              datos.setFUNCION("");

            return "SUCCESS";

        } catch (Exception e) {

            TipoException = e.getMessage();
            return "ERROR";
        }
    }
     
        
     public String borrarFuncion() {

        //validando session***********************************************************************
        if (session.get("cveUsuario") != null) {
            String sUsu = (String) session.get("cveUsuario");
        } else {
            addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
            return "SESSION";
        }
        if (session.containsKey("usuario")) {
            usuariocons = (usuarioBean) session.get("usuario");
        } else {
            addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
            return "SESSION";
        }

        try {
            
            
             ConsultaBusiness con = new ConsultaBusiness();
            
            String fecha=fecha();
            
             datos.setFECHA(fecha);
             datos.setCVE_UNIDAD(usuariocons.getCVE_UNIDAD());
             datos.setUSUARIO(usuariocons.getNAMEUSUARIO());
             
             con.eliminarFuncion(datos);
             
             
            
             iniciDoc();
            
              datos.setID_FUNCION("");
              
              addFieldError("bfun", "Función borrada");
            

            return "SUCCESS";

        } catch (Exception e) {

            TipoException = e.getMessage();
            return "ERROR";
        }
    }   
        
        
         public String actualizaFuncion() {

        //validando session***********************************************************************
        if (session.get("cveUsuario") != null) {
            String sUsu = (String) session.get("cveUsuario");
        } else {
            addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
            return "SESSION";
        }
        if (session.containsKey("usuario")) {
            usuariocons = (usuarioBean) session.get("usuario");
        } else {
            addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
            return "SESSION";
        }

        try {
            
            
             ConsultaBusiness con = new ConsultaBusiness();
            
            String fecha=fecha();
            
             datos.setFECHA(fecha);
             datos.setCVE_UNIDAD(usuariocons.getCVE_UNIDAD());
             datos.setUSUARIO(usuariocons.getNAMEUSUARIO());
             
             con.actualizaFuncion(datos);
             
             
            
             iniciDoc();
            
              datos.setID_FUNCION("");
                datos.setACT_FUNCION("");
                  addFieldError("afun", "Función actualizada");
            

            return "SUCCESS";

        } catch (Exception e) {

            TipoException = e.getMessage();
            return "ERROR";
        }
    }   
        
        
        
     
      public  String fecha() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
        return formateador.format(ahora);
    }
     
     
     
     
     
     
     
     
     
     
     
     
    public ArrayList<datosBean> getListaDatos() {
        return ListaDatos;
    }

    public void setListaDatos(ArrayList<datosBean> ListaDatos) {
        this.ListaDatos = ListaDatos;
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

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getTabSelect() {
        return tabSelect;
    }

    public void setTabSelect(String tabSelect) {
        this.tabSelect = tabSelect;
    }

    public String getTipoError() {
        return TipoError;
    }

    public void setTipoError(String TipoError) {
        this.TipoError = TipoError;
    }

    public String getTipoException() {
        return TipoException;
    }

    public void setTipoException(String TipoException) {
        this.TipoException = TipoException;
    }

    public datosBean getDatos() {
        return datos;
    }

    public void setDatos(datosBean datos) {
        this.datos = datos;
    }

    public ArrayList<datosBean> getListaFuenciones() {
        return ListaFuenciones;
    }

    public void setListaFuenciones(ArrayList<datosBean> ListaFuenciones) {
        this.ListaFuenciones = ListaFuenciones;
    }
    
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public Map getSession() {
        return session;
    }

    public void setSession(Map session) {
        this.session = session;
    }

    public Navegacion getObjNaveg() {
        return objNaveg;
    }

    public void setObjNaveg(Navegacion objNaveg) {
        this.objNaveg = objNaveg;
    }

    public String getLigaRegreso() {
        return ligaRegreso;
    }

    public void setLigaRegreso(String ligaRegreso) {
        this.ligaRegreso = ligaRegreso;
    }

   

  

    public String getLigaactual() {
        return ligaactual;
    }

    public void setLigaactual(String ligaactual) {
        this.ligaactual = ligaactual;
    }
    
    
    
    
}
