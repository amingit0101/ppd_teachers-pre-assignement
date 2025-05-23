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
		D.getTeachers().clear();
		if(conn==null ) return teachers;
		PreparedStatement pstmt=conn.prepareStatement("SELECT Teacher.*,Persone.*,diplome.*,Users.* "
				+ "FROM Teacher,Persone,diplome,Users WHERE "
				+ "Persone.Person_id=Teacher.personal_info and "
				+ "Persone.diplome_id=diplome.dep_id and "
				+ "Teacher.User_account = Users.user_id "
				+ "and Teacher.Departement=?");
		pstmt.setInt(1,D.getID());
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			Teacher t=new Teacher();
			t.setID(rs.getInt(1));
			t.getP().setID(rs.getInt(2));
			t.setStatus(rs.getString(3));
			t.getP().setName(rs.getString(7));
			t.getP().setPhone(rs.getString(8));
			t.getP().setBirthday(rs.getDate(9));
			t.getP().setEmail(rs.getString(10));
			t.getP().getDiploma().setId(rs.getInt(11));
			t.getU().setID(rs.getInt(14));
			t.getU().setPasswd(rs.getString(15));
			teachers.add(t);
			}
		return teachers;
	}
	public static void addTeacherToDB(Connection conn,Teacher t,Department D) throws SQLException {
		PreparedStatement stmt=conn.prepareStatement("insert into Teacher values(?,?,?,?,?)");
		t.setID(util.DButils.getNewId("Teacher"));
		stmt.setInt(1, t.getID());
		stmt.setInt(2, t.getP().getID());
		stmt.setString(3, t.getStatus());
		stmt.setInt(4, D.getID());
		stmt.setInt(5, t.getU().getID());
		stmt.executeUpdate();
	}
	public static void updateTeacher(Connection conn,Teacher t,Department D) throws SQLException {
		PreparedStatement stmt=conn.prepareStatement("Update Users set "
				+ "password= ? ,"
				+ "account_type = ? "
				+ "where user_id =? ");
		stmt.setString(1,t.getU().getPasswd());
		stmt.setInt(2,1);
		stmt.setInt(3,t.getU().getID());
		stmt.executeUpdate();
	}
	public static void removeTeacher(Connection conn,int teacher_num,Department D) throws SQLException{

		PreparedStatement stmt=conn.prepareStatement("delete from Teacher where T_ID=?");
		Teacher t= D.getTeachers().get(teacher_num);
		stmt.setInt(1, t.getID());
		stmt.executeUpdate();
		stmt.close();
		stmt=conn.prepareStatement("select T_ID from Teacher where T_ID > ?");
		stmt.setInt(1,t.getID());
		ResultSet rs=stmt.executeQuery();
	    stmt.close();
	    while(rs.next()) {
	    	stmt=conn.prepareStatement("update  Teacher set T_ID=? where T_ID=?");
	    	stmt.setInt(1,rs.getInt(1)-1);
	    	stmt.setInt(2,rs.getInt(1));
	    	stmt.executeUpdate();
	    }
	    D.getTeachers().remove(teacher_num);
	    stmt.close();	
	}
}
