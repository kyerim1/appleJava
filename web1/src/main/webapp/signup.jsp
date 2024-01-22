<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    

<form id="signFm" method="post" action="signup_save.jsp">
	<div id="signup_wrap">
		<div class="input">
			<label> 아이디</label>
			<input type="text" name="id" id="id">
		</div>
		<div class="input">
			<label> 비밀번호</label>
			<input type="password" name="pw" id="pw">
		</div>
		<div class="input">
			<label> 비밀번호확인</label>
			<input type="password"  id="pw2">
		</div>
		<div class="input">
			<label> 이메일</label>
			<input type="email" name="email" id="email">
		</div>
		<div class="input">
			<label> 연락처</label>
			<input type="text" name="tel" id="tel">
		</div>
		<div class="bt">
			<button type="button" id="signup_bt">가입</button>
		</div>
	
	</div>
</form>





