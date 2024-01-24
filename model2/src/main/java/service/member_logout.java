package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class member_logout implements member_action{

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		request.getSession().removeAttribute("user");
		response.sendRedirect("/");
		
		return null;
	}

}
