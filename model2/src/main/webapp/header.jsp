<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    

<div id="header">
	<div id="top">
		<ul class="top_list">
			<c:if test="${ sessionScope.user ==null }">
				<li><a href="">로그인</a></li>
				<li><a href="/signup.do">회원가입</a></li>
			</c:if>
			
			<c:if test="${ sessionScope.user !=null }">
				<li><a href=""></a></li>
				<li><a href="">내정보</a></li>
				<li><a href="">로그아웃</a></li>
			</c:if>
			
			<li><a href="">HELP</a></li>
		</ul>
	</div>
	<div id="nav">
		<ul class="menu_list">
			<li class="menu"><a href="">WHY</a></li>
			<li class="menu"><a href="">WHO</a></li>
			<li class="menu"><a href="">STUDY</a></li>
			<li class="menu"><a href="">TEST</a></li>
		</ul>
	</div>
</div>




