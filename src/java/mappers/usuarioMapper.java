package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import beans.usuarioBean;

 

public class usuarioMapper implements Mapper {
	
	public Object mapRow(ResultSet rs) throws SQLException {
		usuarioBean usr = new usuarioBean();

		usr.setNAMEUSUARIO(rs.getString("NAMEUSUARIO"));
		usr.setPASSWORD(rs.getString("PASSWORD"));
		usr.setPERFIL(rs.getInt("PERFIL"));		
		usr.setUSUARIO(rs.getString("USUARIO"));
                usr.setCVE_UNIDAD(rs.getString("CVE_UNIDAD"));
		
		return usr;
	}
	

}


