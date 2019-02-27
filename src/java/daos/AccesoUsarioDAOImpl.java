package daos;

import beans.datosBean;
import java.sql.*;
import java.util.List;

import beans.usuarioBean;
import java.util.ArrayList;
import mappers.moduloAuxMapper;
import mappers.moduloMapper;

import mappers.usuarioMapper;
import utilidades.Constantes;
import utilidades.ObjPrepareStatement;

public class AccesoUsarioDAOImpl extends OracleDAOFactory implements AccesoUsarioDAO {

    OracleDAOFactory oraDaoFac = new OracleDAOFactory();

    //buscando los datos del USUARIO 
    public usuarioBean consultaAcceso(String cveUsuario, String pswUsuario) throws Exception {

        String query = " select NAMEUSUARIO, PASSWORD, PERFIL, USUARIO, CVE_UNIDAD "
                + " from " + Constantes.TablaUsuarios + " where usuario = '" + cveUsuario + "' AND PASSWORD = '" + pswUsuario + "'";
        Constantes.enviaMensajeConsola(" query consulta folio--> " + query);
        usuarioBean usu = (usuarioBean) oraDaoFac.queryForObject(query, new usuarioMapper());
        return usu;
    }

    public List consultaModulosPerfilMenu(Integer cvePer, String cvemodpadre) throws Exception {
        String query = "SELECT MP.CVEMODULO,NAMEMOD,ACTION,MODPADRE,IMAGEN FROM " + Constantes.TablaModulosPerfiles + " MP "
                + " LEFT OUTER JOIN " + Constantes.TablaModulos + " M ON MP.CVEMODULO=M.CVEMODULO "
                + " WHERE PERFIL='" + cvePer + "' ORDER BY ORDEN";
        System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new moduloMapper());
        return list;
    }

    public List consultaModulosHijosPerfilMenu(Integer cvePer, String cvemodpadre) throws Exception {
        String query = "SELECT MP.CVEMODULO,NAMEMOD,ACTION,MODPADRE FROM " + Constantes.TablaModulosPerfiles + " MP "
                + " LEFT OUTER JOIN " + Constantes.TablaModulos + " M ON MP.CVEMODULO=M.CVEMODULO "
                + " WHERE PERFIL='" + cvePer + "' ORDER BY ORDEN";
        System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new moduloAuxMapper());
        return list;
    }

    public boolean guardaDato(datosBean datos) throws Exception {

//Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
//Crear un objeto de tipo ObjPrepareStatement
        ObjPrepareStatement temporal;
//imprimiendo los valores del objeto tipo CCT...........
        Constantes.enviaMensajeConsola("Entre al DAO del INSERT...................................");

//En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        temporal = new ObjPrepareStatement("CVE_UNIDAD", "STRING", datos.getCVE_CUNIDAD_CONSULTA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("ESTATUS_OBJETIVO", "STRING", "0");
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("ESTATUS_COMENTARIO", "STRING", "0");
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("ESTATUS_FUNCION", "STRING", "0");
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("FECHA_ACT_OBJ", "STRING", " ");
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("FECHA_ACT_COM", "STRING", " ");
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("RES_ACT_OBJ", "STRING", " ");
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("RES_ACT_COM", "STRING", " ");
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("FECHA_DOC", "STRING",datos.getFECHA_DOC());
        arregloCampos.add(temporal);

//Se terminan de adicionar a nuesto ArrayLis los objetos
//Ejecutar la funcion del OracleDAOFactory queryInsert, se deber pasar como parmetros la tabla en donde se insertara
        return oraDaoFac.queryInsert("TBL_DATOS", arregloCampos);
    }

}
