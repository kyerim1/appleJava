package service;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import DAO.member_dao;
import DTO.member;

public class member_update implements member_action{
	private member_dao dao = new member_dao();
	
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String path="C:\\drone2023\\java\\appleJava\\model2\\src\\main\\webapp\\static\\image";
		// request.getRealPath("/")+"static/image"
		
		int size = 1024*1024*20;
		
		String face =null;
		String name = null;
		String tel =null;
		
		try {
			
			MultipartRequest mr = new MultipartRequest(request , path, size,"UTF-8",
					new DefaultFileRenamePolicy() );
			
			name = mr.getParameter("name");
			tel = mr.getParameter("tel");
			tel = tel.replace(" - ", "");
			
			Enumeration em = mr.getFileNames();
			String file = (String)em.nextElement();
			face = mr.getFilesystemName(file); // mr.getOriginalFileName(file)-원본이름
			
		}catch(Exception e) {
			System.out.println("파일 업로드 실패");
			e.printStackTrace();
		}
		
		member user = (member)request.getSession().getAttribute("user");
		
		//이미지 이름 저장
		dao.pictureInsert( face, user.getNum() );
		
		// 이름, 연락처 수정
		user.setName(name); //변경 이름 객체에 저장
		user.setTel(tel); // 변경 연락처 객체에 저장
		dao.update( user );
		request.getSession().setAttribute("user", user); // 변경된 유저객체로 세션 재생성
		
		response.sendRedirect("/members/myPage");
		
		return null;
	}

}





