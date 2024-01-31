<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- authSend.jsp --%>

<div id="findWrap">
	<div class="input_box">
		<h2>비밀번호 찾기</h2>
		<div class="input_email">
			<p>회원으로 등록된 이메일 주소를 입력하세요.<br>
				등록된 이메일이 없으시면 <a href="/members/signup">회원가입</a>을 해주세요.
			</p>
			<form method="post" action="/members/findAuth">
				<input type="email" name="email" id="email" placeholder="이메일주소">
				<br>
				<button>인증번호발송</button>
			</form>
		</div>
	</div>
</div>

<style>
	#findWrap{
		width:1000px;
		margin:0 auto;
	}
	.input_box{
		display:flex;
		justify-content:center;
		align-items:center;
		flex-direction:column;
		gap:20px;
	}
	.input_email p{ margin-bottom:15px; }
	.input_email a{color:blue;}
	.input_email input{width:250px; margin-bottom:10px;}
</style>






