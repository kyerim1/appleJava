<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//String fail = request.getParameter("fail");

	String fail = (String)session.getAttribute("fail");
	if( fail!=null ){
%>    
	<script> alert("아이디 또는 비밀번호가 올바르지 않습니다.");</script>
<% 
	session.removeAttribute("fail"); // 특정 세션 삭제
	//  session.invalidate();   세션 전체 삭제
	} 
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div id="box">
		<form method="post" action="login_result.jsp">
			<div class="input">
				<input type="text" name="id" id="id" placeholder="아이디">
				<input type="password" name="pw" id="pw" placeholder="비밀번호">
				<button id="bt">로그인</button>
			</div>
		</form>
	</div>


</body>
</html>






