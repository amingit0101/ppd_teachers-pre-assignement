package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.*;

public class TeacherDAO {
	public static ArrayList<Teacher> getTeachersFromDB(Connection conn,Department D) throws SQLException {
		ArrayList<Teacher> teachers=new ArrayList<Teacher>();
		D.Teachers.clear();
		if(conn==null ) return teachers;
		PreparedStatement pstmt=conn.prepareStatement("SELECT Teacher.*,Persone.*,diplome.*,Users.* "
				+ "FROM Teacher,Persone,diplome,Users WHERE "
				+ "Persone.Person_id=Teacher.personal_info and "
				+ "Persone.diplome_id=diplome.dep_id and "
				+ "Teacher.User_account = Users.user_id "
				+ "and Teacher.Departement=?");
		pstmt.setInt(1,D.ID);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			Teacher t=new Teacher();
			t.ID=rs.getInt(1);
			t.P.ID=rs.getInt(2);
			t.status=rs.getString(3);
			t.P.name=rs.getString(7);
			t.P.phone=rs.getString(8);
			t.P.birthday=rs.getDate(9);
			t.P.email=rs.getString(10);
			t.P.diploma.ID=rs.getInt(11);
			t.P.diploma.diploma_name=rs.getString(13);
			t.U.ID=rs.getInt(14);
			t.U.passwd=rs.getString(15);
			teachers.add(t);
			}
		return teachers;
	}
	public static void addTeacherToDB(Connection conn,Teacher t,Department D) throws SQLException {
		PreparedStatement stmt=conn.prepareStatement("insert into Teacher values(?,?,?,?,?)");
		stmt.setInt(1, t.ID);
		stmt.setInt(2, t.P.ID);
		stmt.setString(3, t.status);
		stmt.setInt(4, D.ID);
		stmt.setInt(5, t.U.ID);
		stmt.executeUpdate();
	}
	public static void updateTeacher(Connection conn,Teacher t,Department D) throws SQLException {
		PreparedStatement stmt=conn.prepareStatement("Update Users set "
				+ "password= ? ,"
				+ "account_type = ? "
				+ "where user_id =? ");
		stmt.setString(1,t.U.passwd);
		stmt.setInt(2,1);
		stmt.setInt(3,t.U.ID);
		stmt.executeUpdate();
	}
	public static void removeTeacher(Connection conn,int teacher_num,Department D) throws SQLException{
		PreparedStatement stmt=conn.prepareStatement("delete from Teacher where T_ID=?");
		Teacher t= D.Teachers.get(teacher_num);
		stmt.setInt(1, t.ID);
		stmt.executeUpdate();
		stmt.close();
		stmt=conn.prepareStatement("select T_ID from Teacher where T_ID > ?");
		stmt.setInt(1,t.ID);
		ResultSet rs=stmt.executeQuery();
	    stmt.close();
	    while(rs.next()) {
	    	stmt=conn.prepareStatement("update  Teacher set T_ID=? where T_ID=?");
	    	stmt.setInt(1,rs.getInt(1)+1);
	    	stmt.setInt(2,rs.getInt(1));
	    	stmt.executeUpdate();
	    }
	    stmt.close();	
	}
}
