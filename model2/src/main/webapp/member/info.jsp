<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:if test="${sessionScope.user ==null }">
	<script> alert("먼저 로그인 해주세요");  history.back();</script>
</c:if>
    
<div id="info_wrap">
	<form method="post" action="/members/infoUpdate" enctype="multipart/form-data">
		<button>수정</button>
		<div id="grid">
			<div class="item picture nonePicture">
				
				<h4>사진을 등록하세요</h4>
				<div>
					<input type="file" name="face" id="face">
					<label for="face">등록</label>
				</div>
				
			</div>
			<div class="item email_box">
				E-mail : <b>${sessionScope.user.email }</b>
			</div>
			<div class="item name_box">
				이름 : <input type="text" name="name" id="name" value="${sessionScope.user.name }">
			</div>
			<div class="item tel_box">
				Tel. : <input type="text" name="tel" id="tel" value="${user.tel }">
			</div>
			<div class="item login_history">
				<h3>로그인 기록</h3>
				<ul class="login_list">
					<li class="list_head">
						<b class="login_date date">날짜</b>
						<b class="login_ip">접속IP</b>
						<b class="blocking">접속제한</b>
					</li>
			<c:forEach var="res" items="${login_list }">			
					<li>
						<span class="login_date date">
						${res.login_date }
						</span>
						<span class="login_ip">${res.ip }</span>
						<span class="blocking"><a href="">차단</a></span>
					</li>
			</c:forEach>
					
				</ul>
			</div>
			<div class="item active_detail">
				<h3>활동내역</h3>
				<ul class="active_list">
					<li class="list_head">
						<b class="date active_date">날짜</b>
						<b class="detail">내역</b>
						<b class="note">비고</b>
					</li>
					
					<li>
						<span class="date active_date"></span>
						<span class="detail"><a href=""></a></span>
						<span class="note"></span>	
					</li>
					
				</ul>
			</div>
		</div>
	</form>
</div>