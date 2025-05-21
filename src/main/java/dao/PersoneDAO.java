package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.*;
public class PersoneDAO {
	public static void addNewPersonToDB(Persone P,Connection conn) throws SQLException{
			PreparedStatement stmt=conn.prepareStatement("insert into Persone(Person_id,name,Phone,birthday,email,diplome_id)"
				+ " values(?,?,?,?,?,?)");
			P.ID=util.DButils.getNewId("Persone");
			stmt.setInt(1,P.ID);
			stmt.setString(2,P.name);
			stmt.setString(3,P.phone);
			stmt.setDate(4,P.birthday);
			stmt.setString(5,P.email);
			stmt.setInt(6,P.diploma.ID);
			stmt.executeUpdate();
			stmt.close();
	}
	public static void updatePersonInDB(Persone P,Connection conn) throws SQLException {
		    PreparedStatement stmt=conn.prepareStatement("update Persone set "
				+ "name=? , "
				+ "Phone=? , "
				+ "birthday=? , "
				+ "email= ? , "
				+ "diplome_id=?  "
				+ "where Person_id =? ");
			stmt.setString(1,P.name);
			stmt.setString(2,P.phone);
			stmt.setDate(3,P.birthday);
			stmt.setString(4,P.email);
			stmt.setInt(5,P.diploma.ID);
			stmt.setInt(6,P.ID);
			stmt.executeUpdate();
			stmt.close();
	}
	
	public static void createOrUpdatePerson(Connection conn ,Persone P) throws SQLException {
		PreparedStatement stmt =conn.prepareStatement("select Person_id from Persone where email=? ");
		stmt.setString(1,P.email);
		ResultSet rs=stmt.executeQuery();
		if(rs.next()) {
			P.ID=rs.getInt(1);
			updatePersonInDB( P, conn);
		}else {
			addNewPersonToDB( P, conn);
		}
	}
}
