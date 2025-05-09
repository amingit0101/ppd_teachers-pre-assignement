package util;

import java.sql.DriverManager;

import java.sql.SQLException;

import org.mariadb.jdbc.Configuration;
import org.mariadb.jdbc.Connection;
import org.mariadb.jdbc.client.Client;
import org.mariadb.jdbc.client.util.ClosableLock;

public class DBConnection{
	public static final String DBdriver="org.mariadb.jdbc.Driver";
	public static final String DBurl="jdbc:mariadb://localhost:3306/PPD";
	public static final String DBuser="root";
	public static final String DBpasswd="root";
	private java.sql.Connection conn;
	public  java.sql.Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(DBdriver);
		conn = DriverManager.getConnection(DBurl, DBuser, DBpasswd);
		return conn;
	}
}
