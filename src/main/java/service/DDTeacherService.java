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
	public static int addTeacher(Connection conn,HttpServletRequest request,Department D) throws SQLException {
		Teacher t =new Teacher();
		if(!util.HTTPutil.getTeacherFromRequest(t, request)) {
			return 2;
		}
		dao.DiplomaDAO.getDiplomaNameFromId(conn, t.getP().getDiploma().getId());
		if(!dao.PersoneDAO.createPerson(conn, t.getP()))
			return 1;
		dao.UserDAO.createNewUserInDB(t.getU(), conn);
		dao.TeacherDAO.addTeacherToDB(conn, t, D);
		D.getTeachers().add(t);
		return 0;
		//************************************************
	}
	public static boolean modifyTeacher(Connection conn,
			HttpServletRequest request,int teacher_num,Department D) throws SQLException {
		Teacher t =new Teacher();
		util.HTTPutil.getTeacherFromRequest(t, request);
		dao.DiplomaDAO.getDiplomaNameFromId(conn, t.getP().getDiploma().getId());
		if(!dao.PersoneDAO.createPerson(conn, t.getP()))
			return false;
		dao.UserDAO.updateUserInDB(t.getU(), conn);
		dao.TeacherDAO.updateTeacher(conn, t, D);
		D.getTeachers().set(teacher_num, t);
		return true;
		//************************************************
	}
	
	public static void displayTeachers(PrintWriter out,Connection conn,Department D) throws SQLException {
		DDViews.buildToDisplay_core_head(out);
		DDTeacherViews.build_toDisplay_teachers_table_header(out);
		for(int i=0;i<D.getTeachers().size();i++) {
			DDTeacherViews.buildToDisplay_teacher_in_table(D.getTeachers(),out,i);
		}
		DDTeacherViews.buildToDisplay_under_teachers_list(out);
		DDViews.buildToDisplay_core_end(out);
	}
	public  static void display_add_teacher_form(PrintWriter out,
			Connection conn,String errorMessage) throws SQLException {
		DDViews.buildToDisplay_core_head(out);
		DDTeacherViews.buildToDisplay_add_teacher_form_up_diplome(out,errorMessage);
		DDTeacherViews.buildToDisplay_add_teacher_form_diplome(out,conn);
		DDTeacherViews.buildToDisplay_add_teacher_form_bellow_diplome(out);
		DDViews.buildToDisplay_core_end(out);
	}
	public  static void display_edit_teacher_form(PrintWriter out,Connection conn,
			int teacher_num,Department D) throws SQLException {
		DDViews.buildToDisplay_core_head(out);
		DDTeacherViews.buildToDisplay_edit_teacher_form_up_diplome(out,
				teacher_num,D.getTeachers().get(teacher_num));
		DDTeacherViews.buildToDisplay_edit_teacher_form_diplome(out,conn,teacher_num);
		DDTeacherViews.buildToDisplay_edit_teacher_form_bellow_diplome(out);
		DDViews.buildToDisplay_core_end(out);
	}
}
