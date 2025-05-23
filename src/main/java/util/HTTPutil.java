package util;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.servlet.http.HttpServletRequest;

public class HTTPutil {
	public static boolean getTeacherFromRequest(model.Teacher t,HttpServletRequest request) {
		t.getP().setName(request.getParameter("teacher-name"));
		t.getP().setEmail(request.getParameter("teacher-email"));
		t.getU().setPasswd(request.getParameter("teacher-password"));
		t.getP().setPhone(request.getParameter("teacher-phone"));
		if(request.getParameter("teacher-birthday")==null)
			return false;
		
		t.getP().setBirthday(Date.valueOf(request.getParameter("teacher-birthday")));
		t.setStatus(request.getParameter("teacher-status"));
		t.getP().getDiploma().setId(Integer.parseInt(request.getParameter("teacher-diploma")));
		return true;
	}
}	
