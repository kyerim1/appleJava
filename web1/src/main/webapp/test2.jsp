<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%-- test2 --%>
    
    
이름 : <%=request.getAttribute("name") %> <br>
나이 : <%=session.getAttribute("age") %> <br>
직업 : <%=application.getAttribute("job") %> <br>
    