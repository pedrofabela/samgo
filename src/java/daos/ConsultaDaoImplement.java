/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import beans.datosBean;
import java.util.ArrayList;
import java.util.List;
import mappers.Mapper;
import mappers.cansultaFuncionesMapper;
import mappers.datosMapper;
import utilidades.Constantes;
import utilidades.ObjPrepareStatement;

/**
 *
 * @author pedro
 */
public class ConsultaDaoImplement extends OracleDAOFactory implements ConsultaDao{
    
     OracleDAOFactory oraDaoFac = new OracleDAOFactory();
    
    
     public List listaDatos(datosBean datos) throws Exception {
        String query = "SELECT DATOS.*, CAT.UNIDAD FROM (SELECT CVE_UNIDAD,  OBJETIVO,  FECHA_ACT_OBJ,  RES_ACT_OBJ,  COMENTARIOS,  FECHA_ACT_COM,  RES_ACT_COM,  FECHA_DOC,  ESTATUS_OBJETIVO,  ESTATUS_COMENTARIO,  ESTATUS_FUNCION FROM TBL_DATOS  WHERE CVE_UNIDAD='"+datos.getCVE_CUNIDAD_CONSULTA()+"')DATOS JOIN (SELECT CVE_UNIDAD, UNIDAD FROM CAT_UNIDADES )CAT ON DATOS.CVE_UNIDAD=CAT.CVE_UNIDAD";
        Constantes.enviaMensajeConsola("Consulta cct----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new datosMapper());
        return list;
    }
    
     
     public List listaFunciones(datosBean datos) throws Exception {
        String query = "SELECT ID_FUNCION,  CVE_UNIDAD,  FUNCION,  ESTATUS_FUNCION,  RES_ACT_FUNCION,  FECHA_ACT_FUNCION FROM TBL_FUNCIONES WHERE CVE_UNIDAD='"+datos.getCVE_CUNIDAD_CONSULTA()+"' ORDER BY TO_NUMBER(ID_FUNCION) ASC ";
        Constantes.enviaMensajeConsola("Consulta cct----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new cansultaFuncionesMapper());
        return list;
    }
    
     
      public boolean actualizaObjetivo(datosBean datos ) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("OBJETIVO", "STRING", datos.getOBJETIVO());
            arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("RES_ACT_OBJ", "STRING", datos.getUSUARIO());
        arregloCampos.add(temporal);
         temporal = new ObjPrepareStatement("FECHA_ACT_OBJ", "STRING", datos.getFECHA());
        arregloCampos.add(temporal);
         temporal = new ObjPrepareStatement("ESTATUS_OBJETIVO", "STRING", "1");
        arregloCampos.add(temporal);
         
        
        
        
        String Condicion;
        Condicion = "WHERE CVE_UNIDAD=" + "'" + "" + datos.getCVE_UNIDAD()+ "" + "'" + "";

        //Se terminan de adicionar a nuesto ArrayLis lbjos oetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryUpdate("TBL_DATOS", arregloCampos, Condicion);
    }  
    
    public boolean actualizaComentario(datosBean datos ) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("COMENTARIOS", "STRING", datos.getCOMENTARIOS());
            arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("RES_ACT_COM", "STRING", datos.getUSUARIO());
        arregloCampos.add(temporal);
         temporal = new ObjPrepareStatement("FECHA_ACT_COM", "STRING", datos.getFECHA());
        arregloCampos.add(temporal);
         temporal = new ObjPrepareStatement("ESTATUS_COMENTARIO", "STRING", "1");
        arregloCampos.add(temporal);
         
        
        
        
        String Condicion;
        Condicion = "WHERE CVE_UNIDAD=" + "'" + "" + datos.getCVE_UNIDAD()+ "" + "'" + "";

        //Se terminan de adicionar a nuesto ArrayLis lbjos oetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryUpdate("TBL_DATOS", arregloCampos, Condicion);
    }  
    
    
     public boolean guardaFuncion (datosBean datos) throws Exception {

//Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
//Crear un objeto de tipo ObjPrepareStatement
        ObjPrepareStatement temporal;
//imprimiendo los valores del objeto tipo CCT...........
        Constantes.enviaMensajeConsola("Entre al DAO del INSERT...................................");

//En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        temporal = new ObjPrepareStatement("CVE_UNIDAD", "STRING", datos.getCVE_UNIDAD());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("FUNCION", "STRING", datos.getFUNCION());
        arregloCampos.add(temporal);
         temporal = new ObjPrepareStatement("ESTATUS_FUNCION", "STRING", "1");
        arregloCampos.add(temporal);
         temporal = new ObjPrepareStatement("RES_ACT_FUNCION", "STRING", datos.getUSUARIO());
        arregloCampos.add(temporal);
         temporal = new ObjPrepareStatement("FECHA_ACT_FUNCION", "STRING", datos.getFECHA());
        arregloCampos.add(temporal);
       
       

//Se terminan de adicionar a nuesto ArrayLis los objetos
//Ejecutar la funcion del OracleDAOFactory queryInsert, se deber pasar como parmetros la tabla en donde se insertara
        return oraDaoFac.queryInsert("TBL_FUNCIONES", arregloCampos);
    }
     
     
      public boolean eliminarFuncion(datosBean datos) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar     
         ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        temporal = new ObjPrepareStatement("ID_FUNCION", "STRING", datos.getID_FUNCION());
        arregloCampos.add(temporal);
        
        
        return queryDelete("TBL_FUNCIONES", arregloCampos);
    }
      
       public boolean actualizaFuncion(datosBean datos ) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("FUNCION", "STRING", datos.getACT_FUNCION());
            arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("RES_ACT_FUNCION", "STRING", datos.getUSUARIO());
        arregloCampos.add(temporal);
         temporal = new ObjPrepareStatement("FECHA_ACT_FUNCION", "STRING", datos.getFECHA());
        arregloCampos.add(temporal);
         temporal = new ObjPrepareStatement("ESTATUS_FUNCION", "STRING", "1");
        arregloCampos.add(temporal);
         
        
        
        
        String Condicion;
        Condicion = "WHERE ID_FUNCION=" + "'" + "" + datos.getID_FUNCION()+ "" + "'" + "";

        //Se terminan de adicionar a nuesto ArrayLis lbjos oetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryUpdate("TBL_FUNCIONES", arregloCampos, Condicion);
    }  
    
    
    
}
