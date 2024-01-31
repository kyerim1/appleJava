package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class member_chgPassword  implements member_action{

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String authNum = request.getParameter("authNum");
		String num = (String)request.getSession().getAttribute("num");
		String email = request.getParameter("email");
		
		if( authNum.equals(num) ) { // 인증번호가 일치한다면
						
			request.setAttribute("email", email);
			request.setAttribute("prt", "member/newPassword");
			
		}else {  //인증번호가 일치 하지 않는다면
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().append(""
					+ "<script> alert('인증번호가 일치 하지 않습니다.'); history.back();</script>");
			
			return null;
		}
		
		return "/";
	}

}






