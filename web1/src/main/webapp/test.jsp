<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.Arrays" %>
<%
	String name = request.getParameter("name");
int age=0;
// try{
	age =   Integer.parseInt( request.getParameter("age") );
// }catch(NumberFormatException e){
// 	RequestDispatcher disp = request.getRequestDispatcher("error1.jsp");
// 	disp.forward(request, response);
// }
	
	String tel = request.getParameter("tel");
	
	String[] interest = request.getParameterValues("interest");
	
	out.println("서버의 도메인명 : "+  request.getServerName()   );
	out.println("서버의 포트번호 : " + request.getServerPort()  );
	out.println("요청 url : "+request.getRequestURL() +"<br>");
	out.println("요청 uri : "+request.getRequestURI() +"<br>");
	out.println("호스트 이름 : " +request.getRemoteHost() + "<br>");
	out.println("호스트 이름 : "+request.getRemoteAddr() + "<br>");
	out.println("요청 메서드 : "+request.getMethod()+"<br>");
	out.println("페이지 컨텍스트 경로 : "+request.getContextPath()+"<b>");
	
	
	if( name ==null || name.length()==0 ){
		response.sendRedirect("index.jsp");
	}
	
	pageContext.getRequest().getParameter("name");
	pageContext.getResponse().setCharacterEncoding("utf-8");
	pageContext.getOut().println("하하하");
	pageContext.include("menu.jsp");
	
	
	String a=null;
	String b = a.substring(3);
	
%>
    
    
<div> 이름 : <%=name %></div>
<div> 나이 : <%=age %></div>
<div> 연락처 : <%=tel %></div>

<div> <%=Arrays.toString(interest) %></div>







