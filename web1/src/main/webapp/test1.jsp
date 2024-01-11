<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- test1 --%>

<%
	request.setAttribute("name", "이병헌");
    session.setAttribute("age", 44);
    application.setAttribute("job", "actor");
%>

이름 : <%=request.getAttribute("name") %> <br>
나이 : <%=session.getAttribute("age") %> <br>
직업 : <%=application.getAttribute("job") %> <br>


<a href="test2.jsp">이동</a>