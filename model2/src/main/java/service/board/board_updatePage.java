package service.board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.board_dao;
import DTO.board;

public class board_updatePage  implements board_action{
	private board_dao dao=new board_dao();
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int num = Integer.parseInt(request.getParameter("id") );
		
		board data = dao.selectDetail(num);
		
		request.setAttribute("prt","board/update");
		request.setAttribute("data", data);
		return "/";
	}

}
