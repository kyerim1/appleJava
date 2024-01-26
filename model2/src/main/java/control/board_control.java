package control;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.member_action;
import service.board.board_action;

/**
 * Servlet implementation class board_control
 */
@WebServlet("/board_control")
public class board_control extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Map<String , board_action> target = new HashMap<>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public board_control() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		ResourceBundle rb = ResourceBundle.getBundle("class_bundle/board");
		Enumeration key = rb.getKeys();
		while( key.hasMoreElements() ) {
			String k = (String)key.nextElement(); // signup, signupSave, myPage ... 등등
			String value = rb.getString(k);// member.properties의 키에 맞는 value 가져오기
			try {
					Class<?> hcl = Class.forName(value);//클래스를 로드 (객체생성하려면 클래스가 메모리에 로드 되어야 한다.)
					board_action hinst = (board_action)hcl.newInstance();//객체 생성
					target.put(k, hinst);
			}catch(Exception e) {
				System.out.println("board.properties 파일 작업 실패");
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		
		String cmd = uri.substring(1);
		String view ="/";
		board_action brd = target.get(cmd);
		
		view = brd.action(request, response);
		
		if(view !=null) {
			RequestDispatcher rds = request.getRequestDispatcher(view);
			rds.forward(request, response);
		}
		
	}

}




