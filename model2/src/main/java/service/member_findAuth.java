package service;

import java.io.IOException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Arrays;
import java.util.Properties;

import DAO.member_dao;

public class member_findAuth  implements member_action{
	private member_dao dao= new member_dao();
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String email = request.getParameter("email");
		
		String[] emails = dao.findAllEmail();
		
		if( Arrays.asList(emails).contains(email) ) {// 회원가입된 이메일 인가? 확인
			
			final String username="cloudless25@naver.com";
			final String password="H47148VT84PB";
			
			Properties prop = new Properties();
			prop.put("mail.smtp.starttls.enable", "true");//tls 사용여부
			prop.put("mail.smtp.auth", "true");//smtp서버인증
			prop.put("mail.smtp.host", "smtp.naver.com");// 이메일전송 smtp서버명
			prop.put("mail.smtp.port", "587");// smtp포트번호
			
			Session session = Session.getInstance(prop, 
					new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username,password);
						}
					});
			// 비밀번호 변경을 위한 인증 번호 생성(3분 동안 만 사용가능)
			String auth = "";
			for(int i=1; i<=6; i++) {
				int tmp = (int)(Math.random()*10);
				auth= auth+tmp;
			}
			
			
			
			try { //메시지 생성
				MimeMessage msg = new MimeMessage(session);
				msg.setFrom(new InternetAddress(username));//보내는이메일
				msg.setRecipients(Message.RecipientType.TO, 
						InternetAddress.parse( email )); //받는이메일
				
				msg.setSubject("비밀번호 변경 - 인증번호"); //제목
				
				
				msg.setText( "인증번호 : "+auth ,
						"UTF-8"); //내용
				
				Transport.send(msg);
				
				
			}catch(MessagingException e) {
				System.out.println("이메일 전송 실패");
				e.printStackTrace();
			}
			
			request.getSession().setAttribute("num", auth);
			request.getSession().setMaxInactiveInterval(180);
			
			request.setAttribute("email", email);
			request.setAttribute("prt", "member/inputAuthNum");
			
		}else {// 회원가입 안된 이메일 주소 일경우
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().append(""
					+ "<script> alert('등록되지 않은 이메일입니다.'); history.back();</script>");
			
			return null;
		}
		
		
		return "/";
	}

}






