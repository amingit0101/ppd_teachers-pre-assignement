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
			P.setID(util.DButils.getNewId("Persone"));
			stmt.setInt(1,P.getID());
			stmt.setString(2,P.getName());
			stmt.setString(3,P.getPhone());
			stmt.setDate(4,P.getBirthday());
			stmt.setString(5,P.getEmail());
			stmt.setInt(6,P.getDiploma().getId());
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
			stmt.setString(1,P.getName());
			stmt.setString(2,P.getPhone());
			stmt.setDate(3,P.getBirthday());
			stmt.setString(4,P.getEmail());
			stmt.setInt(5,P.getDiploma().getId());
			stmt.setInt(6,P.getID());
			stmt.executeUpdate();
			stmt.close();
	}
	
	public static boolean createPerson(Connection conn ,Persone P) throws SQLException {
		PreparedStatement stmt =conn.prepareStatement("select Users.account_type "
				+ "from Persone,Users where Persone.email=? ");
		stmt.setString(1,P.getEmail());
		ResultSet rs=stmt.executeQuery();
		if(rs.next()) {
				return false;
		}
		addNewPersonToDB( P, conn);
		return true;
		
	}
}
