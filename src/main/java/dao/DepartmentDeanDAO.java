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
		
		pstmt.setInt(1,D.ID);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			D.DD.ID= rs.getInt(1) ;
			D.DD.P.ID=rs.getInt(4);
			D.DD.P.name=rs.getString(5);
			D.DD.P.phone=rs.getString(6);
			D.DD.P.birthday=rs.getDate(7);
			D.DD.P.email=rs.getString(8);
			D.DD.P.diploma.ID=rs.getInt(9);
			D.DD.P.diploma.diploma_name=rs.getString(11);
		}
	}
}
