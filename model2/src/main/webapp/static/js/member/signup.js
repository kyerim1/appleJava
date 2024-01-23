/**
 * 
 */
 $(function(){
	
	$(".input_data input").on("keyup",function(){
		var i=0;
		for( ; i<$(".input_data input").length; i++){
			if( $(".input_data input").eq(i).val() == '' )
				break;
		}
		if( i == $(".input_data input").length ){
			$("#bt").attr("disabled",false);
			$("#bt").removeClass("inactive");
		}	
		else{
			$("#bt").attr("disabled",true);
			$("#bt").addClass("inactive");
		}
		
	});
	
	
	$("#bt").on("click",function(){ //회원가입 버튼 클릭시
			if( $("#pin").val() != $("#pin2").val() ){
				alert("비밀번호를 확인해주세요");
				$("#pin").val("");
				$("#pin2").val("");
				$("#pin").focus();
				$("#bt").attr("disabled",true);
				$("#bt").addClass("inactive");
			}else{
				$("#signupFm").submit(); //form 내부의 데이터 서버에 전달
			}
			
	});
	
});