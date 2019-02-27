/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import beans.datosBean;
import beans.usuarioBean;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class datosMapper implements Mapper{
    public Object mapRow(ResultSet rs) throws SQLException {
		datosBean dat = new datosBean();

		
                if (rs.getString("CVE_UNIDAD") != null) {
            dat.setCVE_UNIDAD(rs.getString("CVE_UNIDAD").trim());
        } else {
            dat.setCVE_UNIDAD(rs.getString("CVE_UNIDAD"));
        }
                
                if (rs.getString("UNIDAD") != null) {
            dat.setUNIDAD(rs.getString("UNIDAD").trim());
        } else {
            dat.setUNIDAD(rs.getString("UNIDAD"));
        }
                
          if (rs.getString("OBJETIVO") != null) {
            dat.setOBJETIVO(rs.getString("OBJETIVO").trim());
        } else {
            dat.setOBJETIVO(rs.getString("OBJETIVO"));
        }
          
		 
                      if (rs.getString("FECHA_ACT_OBJ") != null) {
            dat.setFECHA_ACT_OBJ(rs.getString("FECHA_ACT_OBJ").trim());
        } else {
            dat.setFECHA_ACT_OBJ(rs.getString("FECHA_ACT_OBJ"));
        }
         
           
         
                 if (rs.getString("RES_ACT_OBJ") != null) {
            dat.setRES_ACT_OBJ(rs.getString("RES_ACT_OBJ").trim());
        } else {
            dat.setRES_ACT_OBJ(rs.getString("RES_ACT_OBJ"));
        }
                
               
                   if (rs.getString("COMENTARIOS") != null) {
            dat.setCOMENTARIOS(rs.getString("COMENTARIOS").trim());
        } else {
            dat.setCOMENTARIOS(rs.getString("COMENTARIOS"));
        }      
                
            
             
             if (rs.getString("FECHA_ACT_COM") != null) {
            dat.setFECHA_ACT_COM(rs.getString("FECHA_ACT_COM").trim());
        } else {
            dat.setFECHA_ACT_COM(rs.getString("FECHA_ACT_COM"));
        }          
                
                
       
           if (rs.getString("RES_ACT_COM") != null) {
            dat.setRES_ACT_COM(rs.getString("RES_ACT_COM").trim());
        } else {
            dat.setRES_ACT_COM(rs.getString("RES_ACT_COM"));
        }       
        
            
            if (rs.getString("FECHA_DOC") != null) {
            dat.setFECHA_DOC(rs.getString("FECHA_DOC").trim());
        } else {
            dat.setFECHA_DOC(rs.getString("FECHA_DOC"));
        }       
          
            if (rs.getString("ESTATUS_OBJETIVO") != null) {
            dat.setESTATUS_OBJETIVO(rs.getString("ESTATUS_OBJETIVO").trim());
        } else {
            dat.setESTATUS_OBJETIVO(rs.getString("ESTATUS_OBJETIVO"));
        }       
             
		
         if (rs.getString("ESTATUS_COMENTARIO") != null) {
            dat.setESTATUS_COMENTARIO(rs.getString("ESTATUS_COMENTARIO").trim());
        } else {
            dat.setESTATUS_COMENTARIO(rs.getString("ESTATUS_COMENTARIO"));
        }              
                   
               
           if (rs.getString("ESTATUS_FUNCION") != null) {
            dat.setESTATUS_FUNCION(rs.getString("ESTATUS_FUNCION").trim());
        } else {
            dat.setESTATUS_FUNCION(rs.getString("ESTATUS_FUNCION"));
        }   
             if (rs.getString("RES_RE") != null) {
            dat.setRES_RE(rs.getString("RES_RE").trim());
        } else {
            dat.setRES_RE(rs.getString("RES_RE"));
        }   
             if (rs.getString("RES_AUT") != null) {
            dat.setRES_AUT(rs.getString("RES_AUT").trim());
        } else {
            dat.setRES_AUT(rs.getString("RES_AUT"));
        }        
               
               
		return dat;
	}
    
}
