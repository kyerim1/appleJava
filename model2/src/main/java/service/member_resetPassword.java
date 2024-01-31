package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.member_dao;

public class member_resetPassword  implements member_action{
	private member_dao dao = new member_dao();
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String pin = request.getParameter("pin");
		String email = request.getParameter("email");
		
		dao.updatePassword(email,pin);
		
		response.sendRedirect("/members/signIn");
		
		return null;
	}

}







