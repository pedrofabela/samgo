/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import beans.Navegacion;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionContext;
import java.util.Map;



public class ConsultasAccion extends ActionSupport implements SessionAware{
    

    
    private Map session;
    Navegacion objNaveg; 
    String ligaRegreso= Navegacion.InitialPage;
    String ligaactual="";

    
    
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
