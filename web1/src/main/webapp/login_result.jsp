<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.*" %>    
<%@ page import="entity.member" %>

<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	boolean isFail=false;
	
	Connection conn=null; //접속정보
	Statement st=null;  // sql질의문 전달
	ResultSet rs=null; // 질의에 대한 결과 받기
	
	try{
		String url="jdbc:mysql://localhost:3306/javaTest";
		String user="javaTest";
		String password="123456";
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url,user,password);		
		
	}catch(Exception e){
		System.out.println("드라이버 로드및 데이터베이스 접속 실패 - 로그인");
		e.printStackTrace();
	}
	
	try{
		//String sql="select * from member_model1 where id='"+id+"' and pw='"+pw+"' ";  // sql질의문으로 조회
		String sql="select * from member_model1";
		st = conn.createStatement();
		rs = st.executeQuery(sql); // sql문의 결과 값 받기
		while(  rs.next() ){
			if(id.equals( rs.getString("id"))  ){
				if( pw.equals( rs.getString("pw"))  ){
					
					member m = new member(rs.getInt("num") , 
							rs.getString("id"), rs.getString("pw"),
							rs.getString("email"), rs.getString("tel") );
							
					
					session.setAttribute("user", m);
					response.sendRedirect("/web1/");
					break;
				}
			}
		}
		
	}catch(SQLException e){
		
	}
	
	
	// 아이디 또는 비밀번호가 올바르지 않다면
	if(isFail){
		session.setAttribute("fail","111123");
		response.sendRedirect("login.jsp");
	}
%>
<script>
	//location.href="login.jsp?fail=1";
	// history.back();
</script>







