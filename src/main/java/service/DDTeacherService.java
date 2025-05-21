package service;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;
import model.*;



public class DDTeacherService {
	public static void addTeacher(Connection conn,HttpServletRequest request,Department D) throws SQLException {
		Teacher t =new Teacher();
		util.HTTPutil.getTeacherFromRequest(t, request);
		dao.DiplomaDAO.getDiplomaNameFromId(conn, t.P.diploma.ID);
		dao.PersoneDAO.createOrUpdatePerson(conn, t.P);
		dao.UserDAO.createNewUserInDB(t.U, conn);
		dao.TeacherDAO.addTeacherToDB(conn, t, D);
		D.Teachers.add(t);
		//************************************************
	}
	public static void modifyTeacher(Connection conn,
			HttpServletRequest request,int teacher_num,Department D) throws SQLException {
		Teacher t =new Teacher();
		util.HTTPutil.getTeacherFromRequest(t, request);
		dao.DiplomaDAO.getDiplomaNameFromId(conn, t.P.diploma.ID);
		dao.PersoneDAO.createOrUpdatePerson(conn, t.P);
		dao.UserDAO.updateUserInDB(t.U, conn);
		dao.TeacherDAO.updateTeacher(conn, t, D);
		D.Teachers.set(teacher_num, t);
		//************************************************
	}
	
	public static void displayTeachers(PrintWriter out,Connection conn,Department D) throws SQLException {
		DDViews.buildToDisplay_core_head(out);
		DDTeacherViews.build_toDisplay_teachers_table_header(out);
		for(int i=0;i<D.Teachers.size();i++) {
			DDTeacherViews.buildToDisplay_teacher_in_table(D.Teachers,out,i);
		}
		DDTeacherViews.buildToDisplay_under_teachers_list(out);
		DDViews.buildToDisplay_core_end(out);
	}
	public  static void display_add_teacher_form(PrintWriter out,Connection conn) throws SQLException {
		DDViews.buildToDisplay_core_head(out);
		DDTeacherViews.buildToDisplay_add_teacher_form_up_diplome(out);
		DDTeacherViews.buildToDisplay_add_teacher_form_diplome(out,conn);
		DDTeacherViews.buildToDisplay_add_teacher_form_bellow_diplome(out);
		DDViews.buildToDisplay_core_end(out);
	}
	public  static void display_edit_teacher_form(PrintWriter out,Connection conn,int teacher_num,Department D) throws SQLException {
		DDViews.buildToDisplay_core_head(out);
		DDTeacherViews.buildToDisplay_edit_teacher_form_up_diplome(out,
				teacher_num,D.Teachers.get(teacher_num));
		DDTeacherViews.buildToDisplay_edit_teacher_form_diplome(out,conn,teacher_num);
		DDTeacherViews.buildToDisplay_edit_teacher_form_bellow_diplome(out);
		DDViews.buildToDisplay_core_end(out);
	}
}
