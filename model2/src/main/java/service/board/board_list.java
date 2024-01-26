package service.board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.board_dao;

public class board_list implements board_action{
	private board_dao dao = new board_dao();
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		request.setAttribute("prt", "board/index");
		
		return "/";
	}

}
