/**
 *
 * @author Esteban
 */
 
package daos;

import beans.datosBean;
import java.util.List;
import beans.usuarioBean;

public interface AccesoUsarioDAO {
    
    public usuarioBean consultaAcceso(String cveUsuario, String pswUsuario) throws Exception;
    public List consultaModulosPerfilMenu(Integer cvePer, String cvemodpadre) throws Exception;
    public List consultaModulosHijosPerfilMenu(Integer cvePer, String cvemodpadre) throws Exception;
     public boolean guardaDato(datosBean datos) throws Exception;
    
}