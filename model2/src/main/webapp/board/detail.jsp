<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    


<div id="detail_wrap">

	<div class="detail_text">
		<b>${data.id }.</b>
		<span class="hit_box"><i class="bi bi-eye"></i>${data.hit }</span>
		<span class="date_box"><i class="bi bi-pen"></i>${data.wdate }</span>
	</div>
	<div class="detail_text">
		<span class="title_head">제목</span>
		<b class="title_box">${data.title }</b>
	</div>
	<div class="detail_text">
		<div class="box">
			<span class="title_head">작성자</span>
			<b class="writer_box">${data.writer }</b>
		</div>
		<div class="box">
			<span class="title_head">언어</span>
			<b class="lang_box">${data.lang }</b>
		</div>
	</div>
	<div class="detail_text">
		<div class="content">${data.content }</div>
	</div>
	<div class="update_del">
		<button type="button" onclick="update('${data.id}')">수정</button>
		<button type="button" onclick="delete('${data.id }')">삭제</button>
	</div>
	<div id="reply_wrap">
	</div>
	
</div>



