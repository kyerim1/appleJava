/**
 * 
 */
 
 
 $(function(){
	$("#signup_bt").on("click",function(){
		
		if( $("#id").val() == '' ){
			alert("아이디 입력하세요");
			$("#id").focus();
		}else if( $("#pw").val() =='' ){
			alert("비밀번호를 입력하세요");
			$("#pw").focus();
		}else if( $("#pw").val() != $("#pw2").val() ){
			alert("비밀번호를 다시 확인해주세요");
			$("#pw").val("");
			$("#pw2").val("");
			$("#pw").focus();
		}else if( $("#email").val() == ''){
			alert("이메일을 입력해주세요");
			$("#email").focus();
		}else if( $("#tel").val() == ''){
			alert("연락처를 입력하세요");
			$("#tel").focus();
		}else{
			$("#signFm").submit(); // 모두다 입력했다면 회원가입 데이터베이스 저장 진행
		}
		
	});
});



