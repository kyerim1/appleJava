<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	boolean isFail=false;
	
	if( id.equals("blue") ){
		if( pw.equals("1234") ){
			session.setAttribute("user", "박문수");
			response.sendRedirect("index.jsp");
		}else{
			isFail=true;
		}
	}else{
		isFail=true;
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







