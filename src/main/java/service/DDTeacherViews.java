package service;

import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import model.*;

public class DDTeacherViews {
	public static void build_toDisplay_teachers_table_header(PrintWriter out) {
		out.println("<!-- Teachers Section -->\n"
		 		+ "                <section id=\"teachers\" class=\"content\">\n"
		 		+ "                    <h2>Teachers Management</h2>\n"
		 		+ "                    <form method=\"post\" action=\"DepartmetDeanTeacherManagment\" class=\"btn btn-primary\">\n"
		 		+ "                        <input name=\"position\" type=\"hidden\" value=\"add_teacher\"/>\n"
		 		+ "                        <button type=\"submit\" class=\"btn btn-primary\" >\n"
		 		+ "                          <i class=\"fas fa-plus\"></i>\n"
		 		+ "                          <span>Add New Teacher</span>\n"
		 		+ "                        </button>\n"
		 		+ "                    </form>"
		 		+ "					   <table class=\"teachers-table\">\n"
		 		+ "                        <thead>\n"
		 		+ "                            <tr>\n"
		 		+ "                                <th>Name</th>\n"
		 		+ "                                <th>Email</th>\n"
		 		+ "                                <th>Phone</th>\n"
		 		+ "                                <th>Birthday</th>\n"
		 		+ "                                <th>Status</th>\n"
		 		+ "                                <th>Actions</th>\n"
		 		+ "                            </tr>\n"
		 		+ "                        </thead>\n"
		 		+ "                        <tbody id=\"teachers-list\">");
	}
	public static void buildToDisplay_teacher_in_table(ArrayList<Teacher> ts,PrintWriter out,int teacher_number) {
		 Teacher t=ts.get(teacher_number);
		 out.println("<tr>");
		 out.println("<td>"+t.getP().getName()+"</td>");
		 out.println("<td>"+t.getP().getEmail()+"</td>");
		 out.println("<td>"+t.getP().getPhone()+"</td>");
		 out.println("<td>"+t.getP().getBirthday().toString()+"</td>");
		 out.println("<td>"+t.getStatus()+"</td>");
		 out.println("<td>");
		 out.println(" <form method=\"post\" action=\"DepartmetDeanTeacherManagment\" class=\"btn btn-primary\">");
		 out.println("<input name=\"position\" type=\"hidden\" value=\"modify_teacher"+teacher_number+"\"/>");
		 out.println("<button class=\"btn btn-primary\">");
		 out.println("<i class=\"fas fa-plus\"></i>");
		 out.println("<span>Edit </span>");
		 out.println("</button>");
		 out.println("</form>");
		 out.println(" <form method=\"post\" action=\"DepartmetDeanTeacherManagment\" class=\"btn btn-primary\">");
		 out.println("<input name=\"position\" type=\"hidden\" value=\"delete_teacher"+teacher_number+"\"/>");
		 out.println("<button class=\"btn btn-primary\">");
		 out.println("<i class=\"fas fa-plus\"></i>");
		 out.println("<span>Delete </span>");
		 out.println("</button>");
		 out.println("</form>");
		 out.println("</tr>");
	}
	public static void buildToDisplay_under_teachers_list(PrintWriter out){
		out.println("\n"
				+ "                    </table>\n"
				+ "                </section>\n"
				);
	}
	public static void buildToDisplay_add_teacher_form_up_diplome(PrintWriter out,String errorMessage) {
		out.println("<section id=\"teachers\" class=\"content\">\n"
				+ "                    <h2>Teachers Management</h2> \n"
				+ "                    <!-- Teacher Form (Hidden by default) -->\n"
				+ "                    <div id=\"teacher-form\" class=\"form-container\">\n"
				+ "						   <h4 style=\"color:red;\">"+errorMessage+"</h4>"
				+ "                        <h3 id=\"teacher-form-title\">Add New Teacher</h3>\n"
				+ "                        <form id=\"teacherForm\" method=\"post\" action=\"DepartmetDeanTeacherManagment\">\n"
				+ "                            <div class=\"form-group\">\n"
				+ "                                <label for=\"teacher-name\">Full Name</label>\n"
				+ "                                <input type=\"text\" id=\"teacher-name \" name=\"teacher-name\" />\n"
				+ "                            </div>\n"
				+ "                            <div class=\"form-group\">\n"
				+ "                                <label for=\"teacher-email\">Email</label>\n"
				+ "                                <input type=\"email\" id=\"teacher-email\" name=\"teacher-email\" />\n"
				+ "                            </div>\n"
				+ "								<div class=\"form-group\">\n"
				+ "                                <label for=\"teacher-password\">Password</label>\n"
				+ "                                <input type=\"password\" id=\"teacher-password\" name=\"teacher-password\" />\n"
				+ "                            </div>"
				+ "                            <div class=\"form-group\">\n"
				+ "                                <label for=\"teacher-phone\">Phone</label>\n"
				+ "                                <input type=\"tel\" id=\"teacher-phone\"  name=\"teacher-phone\"/>\n"
				+ "                            </div>\n"
				+ "                            <div class=\"form-group\">\n"
				+ "                              <label for=\"teacher-birthday\">Birth day</label>\n"
				+ "                              <input type=\"date\" id=\"teacher-birthday\" name=\"teacher-birthday\"/>\n"
				+ "                            </div>\n"
				+ "                            <div class=\"form-group\">"
				+ "								<div class=\"form-group\">\n"
				+ "                              <label for=\"teacher-status\">Status</label>\n"
				+ "                              <select id=\"teacher-status\" name=\"teacher-status\">\n"
				+ "                                <option value=\"actif\" selected>actif</option>\n"
				+ "                                <option value=\"not actif\">Not actif</option>\n"
				+ "                              </select>\n"
				+ "                            </div>"
				+ "                            <input name=\"position\" type=\"hidden\" value=\"add_new_teacher_save\" />\n");
	}
	 public static void buildToDisplay_add_teacher_form_diplome(PrintWriter out,Connection conn) throws SQLException {
			out.println("<div class=\"form-group\">\n"
					+ "                              <label for=\"teacher-diploma\">Diploma</label>\n"
					+ "                              <select id=\"teacher-diploma\" name=\"teacher-diploma\">");
			ArrayList<Diploma> diplomas=dao.DiplomaDAO.getDiplomas(conn);
			for(int i=0;i<diplomas.size();i++) {
				Diploma d=diplomas.get(i);
				out.println("<option value=\""+d.getId()+"\">"+d.getname()+"</option>");
			}
			out.println("</select>\n"
					+ "                            </div>");
		}
	public static void buildToDisplay_add_teacher_form_bellow_diplome(PrintWriter out) throws SQLException {
		out.println("						 <div class=\"form-actions\">\n"
				+ "                                <button type=\"submit\" class=\"btn btn-primary\" value=\"Save\">\n"
				+ "                                    <i class=\"fas fa-save\"></i>\n"
				+ "                                    <span>Save</span>\n"
				+ "                                </button>\n"
				+ "                                <form class=\"btn btn-outline\" method=\"post\" action=\"DepartmetDeanTeacherManagment\">\n"
				+ "                                  <input name=\"position\" type=\"hidden\" value=\"cancel_teacher\" >\n"
				+ "                                  <button type=\"submit\" class=\"btn btn-outline\">\n"
				+ "                                    <i class=\"fas fa-times\"></i>\n"
				+ "                                    <span>Cancel</span>\n"
				+ "                                  </button>\n"
				+ "                                </form>   \n"
				+ "                            </div>\n"
				+ "                        </form>\n"
				+ "                    </div>\n"
				+ "                </section>\n"
				);
	}
	public static void buildToDisplay_edit_teacher_form_up_diplome(PrintWriter out,int teacher_num,Teacher t) {

		out.println("<section id=\"teachers\" class=\"content\">\n"
				+ "                    <h2>Teachers Management</h2> \n"
				+ "                    <div id=\"teacher-form\" class=\"form-container\">\n"
				+ "                        <h3 id=\"teacher-form-title\">Edit Teacher</h3>\n"
				+ "                        <form id=\"teacherForm\" method=\"post\" action=\"DepartmetDeanTeacherManagment\">\n"
				+ "                            <input name=\"position\" type=\"hidden\" value=\"save_edit_teacher"+teacher_num+"\" >\n"
				+ "                            <div class=\"form-group\">\n"
				+ "                                <label for=\"teacher-name\">Full Name</label>\n"
				+ "                                <input type=\"text\" id=\"teacher-name \" name=\"teacher-name\" value=\""+t.getP().getName()+"\">\n"
				+ "                            </div>\n"
				+ "                            <div class=\"form-group\">\n"
				+ "                                <label for=\"teacher-email\">Email</label>\n"
				+ "                                <input type=\"email\" id=\"teacher-email\" name=\"teacher-email\" value=\""+t.getP().getEmail()+"\">\n"
				+ "                            </div>\n"
				+ "                            <div class=\"form-group\">\n"
				+ "                                <label for=\"teacher-password\">Password</label>\n"
				+ "                                <input type=\"password\" id=\"teacher-password\" name=\"teacher-password\" value=\""+t.getU().getPasswd()+"\">\n"
				+ "                            </div>\n"
				+ "                            <div class=\"form-group\">\n"
				+ "                                <label for=\"teacher-phone\">Phone</label>\n"
				+ "                                <input type=\"tel\" id=\"teacher-phone\"  name=\"teacher-phone\" value=\""+t.getP().getPhone()+"\">\n"
				+ "                            </div>\n"
				+ "                            <div class=\"form-group\">\n"
				+ "                              <label for=\"teacher-birthday\">Birth day</label>\n"
				+ "                              <input type=\"date\" id=\"teacher-birthday\" name=\"teacher-birthday\" value=\""+t.getP().getBirthday()+"\">\n"
				+ "                            </div>\n"
				+ "                            <div class=\"form-group\">\n"
				+ "                              <label for=\"teacher-status\">Status</label>\n"
				+ "                              <select id=\"teacher-status\" name=\"teacher-status\">\n");
				if(t.getStatus().compareTo("actif")==0) {
					out.println( "                                <option value=\"actif\" selected>actif</option>\n"); 	
				    out.println( "                                <option value=\"not actif\">Not actif</option>\n");
				}else {
					out.println( "                                <option value=\"actif\">actif</option>\n"); 	
				    out.println( "                                <option value=\"not actif\" selected>Not actif</option>\n");
				}
					
				out.println( "                              </select>\n"
				+ "                            </div>");
	}
	 public static void buildToDisplay_edit_teacher_form_diplome(PrintWriter out,Connection conn,int teacher_num) throws SQLException {
			out.println("<div class=\"form-group\">\n"
					+ "                              <label for=\"teacher-status\">Status</label>\n"
					+ "                              <select id=\"teacher-status\" name=\"teacher-diploma\">");
			ArrayList<Diploma> diplomas=dao.DiplomaDAO.getDiplomas(conn);
			for(int i=0;i<diplomas.size();i++) {
				Diploma d=diplomas.get(i);
				if(i==teacher_num)
				   out.println("<option value=\""+d.getId()+"\" selected>"+d.getname()+"</option>");
				else 
				   out.println("<option value=\""+d.getId()+"\">"+d.getname()+"</option>");
			}
			out.println("</select>\n"
					+ "                            </div>");
		}
	public static void buildToDisplay_edit_teacher_form_bellow_diplome(PrintWriter out) throws SQLException {
		out.println("						 <div class=\"form-actions\">\n"
				+ "                                <button type=\"submit\" class=\"btn btn-primary\" value=\"Save\">\n"
				+ "                                    <i class=\"fas fa-save\"></i>\n"
				+ "                                    <span>Save</span>\n"
				+ "                                </button>\n"
				+ "                                <form class=\"btn btn-outline\" method=\"post\" action=\"DepartmetDeanTeacherManagment\">\n"
				+ "                                  <input name=\"position\" type=\"hidden\" value=\"cancel_teacher\" >\n"
				+ "                                  <button type=\"submit\" class=\"btn btn-outline\">\n"
				+ "                                    <i class=\"fas fa-times\"></i>\n"
				+ "                                    <span>Cancel</span>\n"
				+ "                                  </button>\n"
				+ "                                </form>   \n"
				+ "                            </div>\n"
				+ "                        </form>\n"
				+ "                    </div>\n"
				+ "                </section>\n"
				);
	}
}
