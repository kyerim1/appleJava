package service.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.board_dao;
import DTO.board;

public class board_list implements board_action{
	private board_dao dao = new board_dao();
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int page=1;
		int row=0;
		if( request.getParameter("page") !=null ) {
			page = Integer.parseInt( request.getParameter("page"));
		}
		
		row = (page - 1) *10;
		
		List<board> list = dao.Allselect( row );
		
		int total = dao.DbCount();
		
		request.setAttribute("DBtotal", total);
		request.setAttribute("list", list);
		request.setAttribute("prt", "board/index");
		
		return "/";
	}

}
