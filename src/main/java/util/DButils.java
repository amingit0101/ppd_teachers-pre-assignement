package util;


import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DButils{
	public static final String DBdriver="org.mariadb.jdbc.Driver";
	public static final String DBurl="jdbc:mariadb://localhost:3306/PPD";
	public static final String DBuser="root";
	public static final String DBpasswd="root";
	private static java.sql.Connection conn;
	public static java.sql.Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(DBdriver);
		conn = DriverManager.getConnection(DBurl, DBuser, DBpasswd);
		return conn;
	}
	public static int getNewId(String table) throws SQLException {
		PreparedStatement stmt =conn.prepareStatement("select MAX(T_ID) from ?");
		stmt.setString(1, table);
		ResultSet rs=stmt.executeQuery();
		if(rs.next())
			return rs.getInt(1)+1;
		else 
			return 1;
	}
}