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
import java.util.ArrayList;
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
            
            
                   ListaDatos= (ArrayList<datosBean>) con.listaDatos(datos);
             
             
            
            
            
            
            

            return "SUCCESS";

        } catch (Exception e) {

            TipoException = e.getMessage();
            return "ERROR";
        }
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
