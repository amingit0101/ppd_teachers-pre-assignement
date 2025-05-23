package util;


import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


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
		Statement stmt =conn.createStatement();
		ResultSet rs;
		if(table.compareTo("Teacher")==0) {
			rs=stmt.executeQuery("select MAX(T_ID) from Teacher");
		}else if(table.compareTo("Persone")==0) {
			rs=stmt.executeQuery("select MAX(Person_id) from Persone");
		}else if(table.compareTo("Assgnements")==0) {
			rs=stmt.executeQuery("select MAX(A_ID) from Assgnements");
		}else if(table.compareTo("Departement")==0) {
			rs=stmt.executeQuery("select MAX(D_id) from Departement");
		}else if(table.compareTo("Departement_dean")==0) {
			rs=stmt.executeQuery("select MAX(DD_ID) from Departement_dean");
		}else if(table.compareTo("Formation")==0) {
			rs=stmt.executeQuery("select MAX(F_id) from Formation");
		}else if(table.compareTo("Module")==0) {
			rs=stmt.executeQuery("select MAX(M_ID) from Module");
		}else if(table.compareTo("Users")==0) {
			rs=stmt.executeQuery("select MAX(user_id) from Users");
		}else if(table.compareTo("choosen_modules")==0) {
			rs=stmt.executeQuery("select MAX(chosen_M_id) from choosen_modules");
		}else if(table.compareTo("college_Dean")==0) {
			rs=stmt.executeQuery("select MAX(CD_ID) from college_Dean");
		}else {
			rs=stmt.executeQuery("select MAX(dep_id) from diplome");
		}
		if(rs.next()) {
			System.out.println(rs.getInt(1)+1);
			return rs.getInt(1)+1;
		}
		else 
			return 1;
	}
}