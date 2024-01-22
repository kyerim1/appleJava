<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   <%
   		//pageContext.include("insert.jsp");
   		//pageContext.forward("change.jsp");
   		request.setCharacterEncoding("UTF-8");
   		String user = request.getParameter("user");
   		user = user.equals("null") ? null : user;
   		System.out.println(user);
   %> 
   <div>
   	<ul style='display:flex; width:500px; justify-content:space-between;'>
   		
   		<%   if( user==null){ %>
   		<li> <a href="index.jsp?part=login">로그인</a> </li>
   		<%  } 
   			if(user !=null){ 
   		%>
   		<li> <a href="logout.jsp">로그아웃</a> </li>
   		<% } %>
   		
   		<li>메뉴3</li>
   		<li>메뉴4</li>
  <%-- 로그인 하지 않으면 클리하여 페이지 이동 안되게 한다.
      로그인 하지 않으면 페이지 이용할 권한이 없도록 만든다.
   --%>
   		<li onclick="move()">메뉴5</li> 
   		<li ><a href="index.jsp?part=signup">회원가입</a></li>
   	</ul>
   </div>
   
   <script>
   		function move(){
   			<%  if( user==null){  %>
   				alert("로그인후에 이용하세요");
   			<% } %>
   			<%  if(user !=null ){ %>
   				location.href="menu5.jsp";
   			<%  } %>
   		}
   </script>
   
   
   
   
   
   