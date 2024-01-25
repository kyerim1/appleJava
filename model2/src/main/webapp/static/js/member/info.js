/**
 *  info.js
 */
 
 $(function(){
	
	
		var phone = $("#tel").val();
		$("#tel").val( phone.replace(/^(\d{3})(\d{4})(\d{4})$/, '$1 - $2 - $3') );
	
		$("#tel").on("focus",function(){
			var phone = $(this).val();
			$(this).val( phone.replace(/[^0-9]/g, ''));
		});
		$("#tel").on("blur",function(){
			var phone = $("#tel").val();
			$("#tel").val( phone.replace(/^(\d{3})(\d{4})(\d{4})$/, '$1 - $2 - $3') );
		})
		
		
		//이미지 미리보기
		
		$("#face").on("change",function( event ){
			var file = event.target.files[0];
			var reader = new FileReader();
			reader.onload=function(e){
				$(".picture").css("background", "url("+e.target.result+") no-repeat center");
				$(".picture").css("background-size","contain");
			};
			reader.readAsDataURL( file);
		});
		
	
});










