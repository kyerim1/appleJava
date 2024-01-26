<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
    
<div id="board_wrap">
	<h3> 내 코드를 도와줘! </h3>
	<div class="moveBt">
		<c:if test="${user != null }">
			<a href="/board_writePage.do">도움받기</a>
		</c:if>
		<div class="sortList">
			<a href="javascript:sortTitle()">
				제목 
				<i class="bi bi-arrow-down-short"></i>
				<i class="bi bi-arrow-up-short iconHide"></i>
			</a>
			<a href="javascript:sortDate()">
				날짜 
				<i class="bi bi-arrow-down-short"></i>
				<i class="bi bi-arrow-up-short iconHide"></i>
			</a>
			<a href="javascript:sortHit()">
				조회수
				<i class="bi bi-arrow-down-short"></i>
				<i class="bi bi-arrow-up-short iconHide"></i>
			</a>
		</div>
	</div>
	
	<div id="search_wrap">
	<form id="searchFm" method="get" action="board.do">
		<div class="search_box">
			<b>검색</b>
			<input type="text" name="keyword" id="keyword" placeholder="제목 또는 내용 검색">
			<i class="bi bi-binoculars"></i>
		</div>
	</form>
	</div>
	
	<div id="list_wrap">
		<table class="list_table">
			<thead>
				<tr>
					<th class="num">번호</th>
					<th class="title">제목</th>
					<th class="date">작성일</th>
					<th class="writer">작성자</th>
					<th class="hit">조회수</th>
				</tr>
			</thead>
			<tbody>
				
				<tr>
					<td class="noneWrite" colspan="5"> 등록된 글이 없습니다.</td>
				</tr>
				
				<tr>
					<td class="num numtd"></td>
					<td class="title titletd"></td>
					<td class="date datetd"></td>
					<td class="writer writertd"></td>
					<td class="hit hittd"></td>
				</tr>
				
			</tbody>
			
			<tfoot>
				<tr>
					<td colspan="5">
						
						<i class="bi bi-chevron-left"></i>
						
						<i class="bi bi-chevron-right"></i>
						
					</td>
				</tr>
			</tfoot>
		</table>
	</div>
	
</div>








