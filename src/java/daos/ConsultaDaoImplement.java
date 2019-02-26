/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import beans.datosBean;
import java.util.List;
import mappers.Mapper;
import mappers.datosMapper;
import utilidades.Constantes;

/**
 *
 * @author pedro
 */
public class ConsultaDaoImplement extends OracleDAOFactory implements ConsultaDao{
    
     OracleDAOFactory oraDaoFac = new OracleDAOFactory();
    
    
     public List listaDatos(datosBean datos) throws Exception {
        String query = "SELECT DATOS.*, CAT.UNIDAD FROM (SELECT CVE_UNIDAD,  OBJETIVO,  FECHA_ACT_OBJ,  RES_ACT_OBJ,  COMENTARIOS,  FECHA_ACT_COM,  RES_ACT_COM,  FECHA_DOC,  ESTATUS_OBJETIVO,  ESTATUS_COMENTARIO,  ESTATUS_FUNCION FROM TBL_DATOS  WHERE CVE_UNIDAD='12345')DATOS JOIN (SELECT CVE_UNIDAD, UNIDAD FROM CAT_UNIDADES )CAT ON DATOS.CVE_UNIDAD=CAT.CVE_UNIDAD";
        Constantes.enviaMensajeConsola("Consulta cct----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new datosMapper());
        return list;
    }
    
    
    
    
    
    
    
}
