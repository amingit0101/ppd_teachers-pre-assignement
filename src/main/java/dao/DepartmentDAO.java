package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.*;

public class DepartmentDAO {
	public static void getAllDepartmentInfosFromDataBase(Connection conn,	Department D,int dep_num) throws SQLException {
		if(conn==null ) return ;
		PreparedStatement pstmt=conn.prepareStatement("SELECT * FROM Departement where D_id=? ");
		pstmt.setInt(1,dep_num);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			D.setID(dep_num) ;
			D.setName(rs.getString(2)) ;
			D.setCreation_date(rs.getDate(3));
		}
		pstmt.close();
		DepartmentDeanDAO.getDepartmentDeanInfos(conn, D);
		//D.Teachers=TeacherDAO.getTeachers(conn, D);
	}
}
