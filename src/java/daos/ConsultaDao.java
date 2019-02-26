/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import beans.datosBean;
import java.util.List;

/**
 *
 * @author pedro
 */
public interface ConsultaDao {
    
    
    
     public List listaDatos(datosBean datos) throws Exception;
     
     
    
}
