/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import beans.datosBean;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class cansultaFuncionesMapper implements Mapper{
    
     public Object mapRow(ResultSet rs) throws SQLException {
		datosBean dat = new datosBean();

		
                if (rs.getString("ID_FUNCION") != null) {
            dat.setID_FUNCION(rs.getString("ID_FUNCION").trim());
        } else {
            dat.setID_FUNCION(rs.getString("ID_FUNCION"));
        }
                
                if (rs.getString("CVE_UNIDAD") != null) {
            dat.setCVE_UNIDAD(rs.getString("CVE_UNIDAD").trim());
        } else {
            dat.setCVE_UNIDAD(rs.getString("CVE_UNIDAD"));
        }
                
          if (rs.getString("FUNCION") != null) {
            dat.setFUNCION(rs.getString("FUNCION").trim());
        } else {
            dat.setFUNCION(rs.getString("FUNCION"));
        }
          
		 
                      if (rs.getString("ESTATUS_FUNCION") != null) {
            dat.setESTATUS_FUNCION(rs.getString("ESTATUS_FUNCION").trim());
        } else {
            dat.setESTATUS_FUNCION(rs.getString("ESTATUS_FUNCION"));
        }
         
           
         
                 if (rs.getString("RES_ACT_FUNCION") != null) {
            dat.setRES_ACT_FUNCION(rs.getString("RES_ACT_FUNCION").trim());
        } else {
            dat.setRES_ACT_FUNCION(rs.getString("RES_ACT_FUNCION"));
        }
                
               
                   if (rs.getString("FECHA_ACT_FUNCION") != null) {
            dat.setFECHA_ACT_FUNCION(rs.getString("FECHA_ACT_FUNCION").trim());
        } else {
            dat.setFECHA_ACT_FUNCION(rs.getString("FECHA_ACT_FUNCION"));
        }      
                
            
             
              
               
               
		return dat;
	}
    
}
