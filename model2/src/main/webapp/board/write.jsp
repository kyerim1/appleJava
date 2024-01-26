<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
  
    
<div id="write_wrap">
	<form id="writeFm" method="get" action="/board_write.do">
		<div id="write_box">
			<div class="input_box">
				<label>제목</label>
				<input type="text" name="title" id="title">
			</div>
			<div class="input_box">
				<label>이메일</label>
				<input type="email" name="email" id="email">
			</div>
			<div class="input_box">
				<label>언어</label>
				<select name="lang" id="lang">
					<option value="c">c</option>
					<option value="java">java</option>
					<option value="python">python</option>
					<option value="javascript">javascript</option>
					<option value="c++">c++</option>
					<option value="c#">c#</option>
					<option value="ruby">ruby</option>
					<option value="swift">swift</option>
					<option value="perl">perl</option>
					<option value="go">go</option>
				</select>
			</div>
			
			<textarea id="content" name="content"></textarea>
			
			<button id="save">쓰기</button>
		</div>
	</form>
</div>    

<script>
	$("#content").summernote({
		placeholder:'질문을 작성하세요. 일부 소스만 질문할시 정확한 답변이 어렵습니다.',
		height:300,
		toolbar:[
			['font',['bold','underline','fontsize','forecolor','color']],
			['view',['codeview']]
		]
	});
</script>








