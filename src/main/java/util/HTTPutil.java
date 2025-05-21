package util;

import java.sql.Date;

import jakarta.servlet.http.HttpServletRequest;

public class HTTPutil {
	public static void getTeacherFromRequest(model.Teacher t,HttpServletRequest request) {
		t.P.name=request.getParameter("teacher-name");
		t.P.email=request.getParameter("teacher-email");
		t.P.phone=request.getParameter("teacher-phone");
		t.P.birthday=Date.valueOf(request.getParameter("teacher-birthday"));
		t.status=request.getParameter("teacher-status");
		t.P.diploma.ID=Integer.parseInt(request.getParameter("teacher-diploma"));
	}
}	
