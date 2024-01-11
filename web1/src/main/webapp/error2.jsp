<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
    
    <%--  error2.jsp --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2> 에러페이지와  page지시어의 isErrorPage를 이용한 예외 처리 </h2>
	null 값 이 있습니다.
	<%=exception.getMessage() %>
	<a href="index.jsp"> 되돌아가기</a>

</body>
</html>




