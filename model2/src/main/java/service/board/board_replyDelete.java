package service.board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.board_dao;

public class board_replyDelete  implements board_action{
	private board_dao dao= new board_dao();
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		int bid = Integer.parseInt(request.getParameter("bid"));
		
		dao.delete_reply(id);
		
		response.sendRedirect("/board_read.do?id="+bid);
		
		return null;
	}
}
