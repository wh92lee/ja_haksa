<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<%
	String context = request.getContextPath();
	System.out.println("context->" + context);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.i-i {
	text-align: right;
}

.updown table {
	text-align: center;
}

.updown {
	width: 500px;
	margin: 0 auto;
}

.updown tr {
	border-top: 1px groove;
	border-bottom: 1px groove;
}

body {
	margin-top: 100px;
	font-family: 'Trebuchet MS', serif;
	line-height: 1.6
}

.container {
	width: 500px;
	margin: 0 auto;
}

ul.tabs {
	margin: 0px;
	padding: 0px;
	list-style: none;
}

ul.tabs li {
	background: none;
	color: #222;
	display: inline-block;
	padding: 10px 15px;
	cursor: pointer;
}

ul.tabs li.current {
	background: #ededed;
	color: #222;
}

.tab-content {
	display: none;
	background: #ededed;
	padding: 15px;
}

.tab-content.current {
	display: inherit;
}
</style>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.12.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		

			$('ul.tabs li').click(function() {
				var tab_id = $(this).attr('data-tab');

				$('ul.tabs li').removeClass('current');
				$('.tab-content').removeClass('current');

				$(this).addClass('current');
				$("#" + tab_id).addClass('current');
			})
		
	})
</script>
</head>
<body>

	<div class="updown">
		<h2>학생 명단</h2>
		<c:set var="num" value="${pg.total-pg.start+1}"></c:set>
		<table style="border-collapse: collapse;">
			<tr>
				<th>학생이름</th>
				<th>학생번호</th>
				<th>아이디</th>
				<th>이메일</th>
				<th>강의번호</th>
			</tr>
			<c:forEach var="interview" items="${list }">
				<tr id="btn_idCheck" value="." onclick="getPNum(${interview.pnum })">
					<td>${interview.pname }</td>
					<td>${interview.pnum }</td>
					<td>${interview.pid }</td>
					<td>${interview.pemail }</td>
					<td>${interview.class_num }</td>
				</tr>
				<c:set var="num" value="${num - 1 }"></c:set>
			</c:forEach>
		</table>
		<c:if test="${pg.startPage > pg.pageBlock }">
			<a href="list.do?currentPage=${pg.startPage-pg.pageBlock}">[이전]</a>
		</c:if>
		<c:forEach var="i" begin="${pg.startPage }" end="${pg.endPage }">
			<a href="list.do?currentPage=${i}">[${i}]</a>
		</c:forEach>
		<c:if test="${pg.endPage < pg.totalPage }">
			<a href="list.do?currentPage=${pg.startPage+pg.pageBlock}">[다음]</a>
		</c:if>
	</div>
	<p>
	<p>
	<div class="container">

		<script type="text/javascript">
	function getPNum(pnum){
		console.log(pnum);
		/* alert("Vdeptno->"+Vdeptno); */
		$.ajax({
			url:"<%=context%>/getPNum.do",
			data:{pnum : pnum },
			dataType:'text',
			success:function(data){
				/* alert(".ajax Data"+data); */
			     $('#deptName').val(data);      /*	 input Tag */
				/* $('#deptName').text(data); */
				/*  $('#deptName').html(data);     */
				 $('#msg').html(data);         /* span  id Tag */
				/* $('#deptName').val("이미 사용중인 아이디."); */
			}
		});
	}
	</script>

		deptName: <input type="text" id="deptName" readonly="readonly">
		<p>
		<ul class="tabs">
			<li class="tab-link current" data-tab="tab-1">인적사항</li>
			<li class="tab-link" data-tab="tab-2">면담일지</li>
			<li class="tab-link" data-tab="tab-3">성적입력</li>
		</ul>

		<div id="tab-1" class="tab-content current">클릭한 학생 이름 뭐 각종정보들
			나오도록 할 것
		</div>
		<div id="tab-2" class="tab-content">
			<div class="i-i"><a href="sjwriteInterviewForm.do">면담 입력</a></div>
			<h3>1차 면담</h3>	
			<c:forEach var="interview1" items="${list_i1 }">
				<textarea rows="3" cols="40">${interview1.interview_content }</textarea>
			</c:forEach>
			
			<h3>2차 면담</h3>
			면담 내용을 등록해주세요 나오도록
			<h3>3차 면담</h3>
			면담 내용을 등록해주세요 나오도록
		</div>
		<div id="tab-3" class="tab-content">
			<div class="i-i"><a href="sjwriteScoreForm.do">성적 입력</a></div>
			person table의 ppeval, pteval 정보 pnum이 일치하는 경우의 값 가져오는것
		</div>

	</div>

</body>
</html>