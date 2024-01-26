package service.board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.board_dao;

public class board_Page  implements board_action{
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//로그인 안했을때 주소입력하여 강제 진입시
		if( request.getSession().getAttribute("user") ==null) {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().append(""
					+ "<script> alert('로그인후 이용하세요'); history.back();</script>");
			
			return null;
		}		
		//정상적으로 로그인절차 진행하여 진입 했을때
		request.setAttribute("prt", "board/write");
		
		return "/";
	}

}
