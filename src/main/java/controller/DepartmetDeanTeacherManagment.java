package controller;

import jakarta.servlet.ServletException;



import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Servlet implementation class DepartmetDeanTeacherManagment
 */
public class DepartmetDeanTeacherManagment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmetDeanTeacherManagment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
	    response.setContentType("text/html");
    	PrintWriter out = response.getWriter();
    	try {
			conn=util.DButils.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
    		
    		String position=(request.getParameter("position"));
    		model.Department D=new model.Department();
    		System.out.println(position);
    		dao.DepartmentDAO.getAllDepartmentInfosFromDataBase(conn,D,1);
    		D.setTeachers(dao.TeacherDAO.getTeachersFromDB(conn, D));
    		if(position==null ) {
    			service.DDTeacherService.displayTeachers(out,conn,D);
    		}
    		else if(position.compareTo("add_teacher")==0) {
    			service.DDTeacherService.display_add_teacher_form(out,conn,"");
    		}else if(position.compareTo("add_new_teacher_save")==0){
    			int i=service.DDTeacherService.addTeacher(conn,request,D);
    			if(i==0) {
    				service.DDTeacherService.display_add_teacher_form(out,
    						conn,"The user with this email already exists");
    				return;
    			}else if(i==1) {
    				service.DDTeacherService.display_add_teacher_form(out,
    						conn," Birth day not entered");
    				return;
    			}
    			service.DDTeacherService.displayTeachers(out,conn,D);
    		}else if(position.compareTo("cancel_teacher")==0) {
    			service.DDTeacherService.displayTeachers(out,conn,D);
    		}else  if(position.contains("modify_teacher")){
    			position=position.substring(14);
    			int teacher_num=Integer.parseInt(position);
    			service.DDTeacherService.display_edit_teacher_form(out,conn,teacher_num,D);
    			
    		}else if(position.contains("save_edit_teacher")) {
    			position=position.substring(17);
    			int teacher_num=Integer.parseInt(position);
    			int i=service.DDTeacherService.addTeacher(conn,request,D);
    			if(!service.DDTeacherService.modifyTeacher(conn,request,teacher_num,D)) {
    				service.DDTeacherService.display_edit_teacher_form(out,conn,teacher_num,D);
    				return;
    			}
    			service.DDTeacherService.displayTeachers(out,conn,D);
    		}else if(position.contains("delete_teacher")) {
    			position=position.substring(14);
    			int teacher_num=Integer.parseInt(position);
    			dao.TeacherDAO.removeTeacher(conn, teacher_num, D);
    			D.getTeachers().clear();
    			D.setTeachers(dao.TeacherDAO.getTeachersFromDB(conn, D));
    			service.DDTeacherService.displayTeachers(out,conn,D);
    		}
    	}catch (Exception e) {
    			e.printStackTrace();
    	}
    } 	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
