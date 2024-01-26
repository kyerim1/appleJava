package service.board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.board_dao;
import DTO.board;
import DTO.member;

public class board_write  implements board_action{
	private board_dao dao = new board_dao();
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//작성글 value 가져오기 (파라미터)
		String title = request.getParameter("title");
		String answer_mail = request.getParameter("email");
		String lang = request.getParameter("lang");
		String content = request.getParameter("content");
		member user = (member)request.getSession().getAttribute("user");
		
		if(answer_mail.isEmpty())//answer_mail 은  답글 등록시 알림으로 받을 이메일 주소다.
			answer_mail = user.getEmail();
		
		board b= new board(user.getNum(), title, user.getName() ,
				answer_mail, lang, content);
		dao.insert(b);
		
		response.sendRedirect("/board.do");		
		
		return null;
	}

}





