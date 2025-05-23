package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.User;

public class UserDAO {
	public static void createNewUserInDB(User U,Connection conn) throws SQLException {
		U.setID(util.DButils.getNewId("Users"));
		PreparedStatement stmt=conn.prepareStatement("insert into Users values(?,?,2)");
		stmt.setInt(1, U.getID());
		stmt.setString(2, U.getPasswd());
		stmt.executeUpdate();
		
	}
	public static void updateUserInDB(User U,Connection conn) throws SQLException {
		PreparedStatement stmt=conn.prepareStatement("Update Users set "
				+ "password= ? ,"
				+ "account_type = ? "
				+ "where user_id =? ");
		stmt.setString(1,U.getPasswd());
		stmt.setInt(2,1);
		stmt.setInt(3,U.getID());
		stmt.executeUpdate();
		
	}
}
