package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.*;

public class DiplomaDAO {
	public static ArrayList<Diploma> getDiplomas(Connection conn) throws SQLException {
		ArrayList<Diploma> diplomas= new ArrayList<Diploma>();
		if(conn==null)
			return diplomas;
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT * FROM diplome");
		while(rs.next()) {
			Diploma d=new Diploma();
			d.setId(rs.getInt(1));
			d.setname(rs.getString(2));
			diplomas.add(d);
		}
		return diplomas;
	}
	public static String getDiplomaNameFromId(Connection conn,int ID) throws SQLException {
		PreparedStatement stmt=conn.prepareStatement("select dep_name from diplome where dep_id=? ");
		stmt.setInt(1,ID);
		ResultSet rs=stmt.executeQuery();
		if(rs.next()) {
			return rs.getString(1);
		}else
			return "";
	}
}
