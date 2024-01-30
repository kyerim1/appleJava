package service.board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.board_dao;
import DTO.member;
import DTO.reply;

public class board_reply  implements board_action{
	private board_dao dao = new board_dao();
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int bid = Integer.parseInt(request.getParameter("board_id"));
		String comment = request.getParameter("comment");
		
		member user = (member)request.getSession().getAttribute("user");
		
		reply rp = new reply(bid, user.getNum(), comment, user.getName());
		
		dao.reply_insert(rp);
		
		response.sendRedirect("/board_read.do?id="+bid);
		
		return null;
	}

}



