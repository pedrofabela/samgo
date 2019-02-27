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

    public List listaFunciones(datosBean datos) throws Exception;

    public boolean actualizaObjetivo(datosBean datos) throws Exception;

    public boolean actualizaComentario(datosBean datos) throws Exception;

    public boolean guardaFuncion(datosBean datos) throws Exception;

    public boolean eliminarFuncion(datosBean datos) throws Exception;

    public boolean actualizaFuncion(datosBean datos) throws Exception;

    public boolean actualizaEstatusFuncion(datosBean datos) throws Exception;
    
    public boolean actualizaFecha(datosBean datos) throws Exception ;

    public boolean actualizaresponsables(datosBean datos) throws Exception;

}
