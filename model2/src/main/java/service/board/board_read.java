package service.board;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.board_dao;
import DTO.board;
import DTO.reply;

public class board_read  implements board_action{
	private board_dao dao = new board_dao();
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Cookie[] cooks = request.getCookies();
		boolean isCook=true;
		
		
		int num = Integer.parseInt( request.getParameter("id"));
		for(Cookie ck : cooks) {
			String n=ck.getName();
			if(n.equals(num+"")) {
				isCook=false; break;
			}
		}
		
		board view = dao.selectDetail( num );
		List<reply> reply_list = dao.findReply( num );
		
		if( isCook) {
			dao.hitIncrease(num);
			Cookie cook = new Cookie(num+"","ok");
			
			Calendar today = Calendar.getInstance();
			int hour = today.get(Calendar.HOUR_OF_DAY);
			int min = today.get(Calendar.MINUTE);
			int sec = today.get(Calendar.SECOND);
			int last = 23*60*60+59*60+59;
			int now = hour*60*60+min*60+sec;
			cook.setMaxAge(last-now);
			
			response.addCookie(cook);
		}
		
		request.setAttribute("reply_list",reply_list);
		request.setAttribute("data", view);
		request.setAttribute("prt", "board/detail");
		
		
		return "/";
	}

}
