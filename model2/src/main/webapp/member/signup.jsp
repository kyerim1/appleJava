<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.Arrays" %>
    
<div id="signup_wrap">
	<form id="signupFm" method="post" action="/members/signSave" enctype="multipart/form-data">
		<input type="hidden" name="cmd" value="dao">
		
		<div class="myphoto">
			<div class="photo"></div>
			<input type="file" name="face" id="face">
			<label for="face">내 사진 업로드</label>
		</div>
		
		<div class="input_data">
			<label for="email">E-MAIL</label>
			<input type="email" name="email" id="email" required>
			<span class="email_msg"></span>
		</div>
		<div class="input_data">
			<label for="pin">PassWord</label>
			<input type="password" name="pin" id="pin" required>
		</div>
		<div class="input_data">
			<label for="pin2">Check PassWord</label>
			<input type="password"  id="pin2">
		</div>
		<div class="input_data">
			<label for="name">Name</label>
			<input type="text" name="name" id="name" required>
		</div>
		<div class="input_data">
			<label for="tel">Tel.</label>
			<input type="text" name="tel" id="tel">
		</div>
		
		<div class="signBt">
			<button type="button" id="bt" class="active inactive" disabled>Sign</button>
		</div>
		
	</form>
</div>

<script>
	var temp = '${ Arrays.toString(emailList) }';
	temp = temp.substring(1 , temp.length-1);
	let email = temp.split(", ");
	console.log( email);
	
	$("#email").on("blur",function(){
		if( $(this).val() != ''){
			if( email.indexOf($(this).val()) == -1  ){
				$(".email_msg").text("사용가능한 이메일 입니다.");
				$(".email_msg").removeClass("warning");
			}else{
				$(".email_msg").text("등록된 이메일 입니다.");
				$(".email_msg").addClass("warning");
			}
		}
	});
	
</script>










