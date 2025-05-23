package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Department;

public class DepartmentDeanDAO {
	public  static void  getDepartmentDeanInfos(Connection conn,Department D) throws SQLException {
		if(conn==null ) return ;
		
		PreparedStatement pstmt=conn.prepareStatement("SELECT Departement_dean.* , Persone.*  ,diplome.* "
				+ "FROM Departement_dean , Persone , diplome "
				+ "WHERE DD_id=? "
				+ "and Persone.Person_id=Departement_dean.DD_ID "
				+ "and diplome.dep_id=Persone.diplome_id "
				+ "");
		
		pstmt.setInt(1,D.getID());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			D.getDD().setID(rs.getInt(1)) ;
			D.getDD().getP().setID(rs.getInt(4));
			D.getDD().getP().setName(rs.getString(5));
			D.getDD().getP().setPhone(rs.getString(6));
			D.getDD().getP().setBirthday(rs.getDate(7));
			D.getDD().getP().setEmail(rs.getString(8));
			D.getDD().getP().getDiploma().setId(rs.getInt(9));
			D.getDD().getP().getDiploma().setname(rs.getString(11));
		}
	}
}
