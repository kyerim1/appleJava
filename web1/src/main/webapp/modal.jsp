<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String display=null;

	Cookie[] ck = request.getCookies();
	for(Cookie c: ck){
		if( c.getName().equals("today") ){
			display=c.getValue();
			break;
		}
	}

%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



<style>
	#wrap{
		width:800px; height:700px;
		background:black;
		position:relative;
	}
	#main{
		width:800px;
		height:500px; 
		background:yellow;
	}
	#modal{
		width:300px; height:400px;
		position:absolute;
		background:#CCA63D;
		top:100px; left:55px;
		padding:10px;
		box-sizing:border-box;
	}
	#inner{
		width:100%; height:100%;
		background:white;
	}
	#event{
		width:100%; height:90%;
	}
	.close_wrap{
		width:100%;
		text-align:center;
	}
</style>
</head>
<body>

<div id="wrap">
	<div id="main">
	
	</div>
	<div id="modal" <%=display!=null ? "style='display:none;'" :"" %>>
		<div id="inner">
			<div id="event"></div>
			<div class="close_wrap">
				<label>
					오늘하루 보지 않기 
					<input type="checkbox" name="no" value="yes" id="no">
				</label>
				<a href="javascript:close()">닫기</a>
			</div>
		</div>
	</div>
</div>



</body>
</html>
<script>

function close(){
	
	var chk = document.getElementById("no");
	var isChk = chk.checked;
	
	var modal = document.getElementById("modal");
	modal.style.display="none";
	
	if(isChk){
		const xml = new XMLHttpRequest();
		xml.open("POST","close.jsp",true);
		xml.setRequestHeader("Content-Type","apllication/x-www-form-urlencoded");
		xml.send( JSON.stringify({ close : "yes" }));
		xml.onload=function(){
			alert("성공");
		};
	}
}

</script>




