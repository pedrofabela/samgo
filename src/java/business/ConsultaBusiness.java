/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import beans.datosBean;
import daos.ConsultaDao;
import daos.ConsultaDaoImplement;
import java.util.List;


public class ConsultaBusiness {
    
   private ConsultaDao con;
   public ConsultaBusiness(){
   
   this.con=new ConsultaDaoImplement();
   
   
   }
   
   public List listaDatos(datosBean datos) throws Exception {
        List lista = this.con.listaDatos(datos);
        return lista;
    }
   
    
    
    
    
}
