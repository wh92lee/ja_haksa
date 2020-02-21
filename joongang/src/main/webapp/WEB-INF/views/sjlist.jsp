<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<%
	String context = request.getContextPath();
	//	System.out.println("context->" + context);
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
	width: 600px;
	margin: 0 auto;
}

.updown tr {
	border-top: 1px groove;
	border-bottom: 1px groove;
	height: 30px;
}

body {
	margin-top: 100px;
	font-family: 'Trebuchet MS', serif;
	line-height: 1.6
}

.container {
	width: 600px;
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
<!-- 인적사항활용 -->
<script type="text/javascript">
		function getPNum(pnum){
			//console.log(pnum);
			/* alert("Vdeptno->"+Vdeptno); */
			$.ajax({
				url:"<%=context%>/PNum.do",
				data:{	pnum : pnum/* ,  gubun : gubun, yymm : yymm */ },
				dataType:'json',
				success:function(data){
					//alert(data.gubun);
					/* alert(".ajax Data"+data); */
				     $('#psnum').val(data.gubun+''+data.yymm+''+data.pnum);  /*	 input Tag */
				     $('#pname').val(data.pname);  /*	 input Tag */
				     $('#paddress').val(data.paddress);  /*	 input Tag */
				}
			});
		}
	</script>
<!-- 면담일지활용 -->
<script type="text/javascript">
	function getContent1(pnum){
		$.ajax({
			url:"<%=context%>/Content1.do",
			data:{	pnum : pnum },
			dataType:'json',
			success:function(data){
				//$('#content1').reset();
				 if(data.interview_content!=null){
					 $('#content1').val(data.interview_content);
				 } else{ 
					 $('#content1').val("내용 입력바람"); 
				 }										
			}
		});
	}
	function getContent2(pnum){
		$.ajax({
			url:"<%=context%>/Content2.do",
			data:{	pnum : pnum },
			dataType:'json',
			success:function(data){
				if(data.interview_content!=null){
					$('#content2').val(data.interview_content);
				 } else{ 
					 
					 $('#content2').val("내용 입력바람"); 
				 }
			}
		});
	}
	function getContent3(pnum){
		//alert("1");
		$.ajax({
			url:"<%=context%>/Content3.do",
			data:{	pnum : pnum },
			dataType:'json',
			success:function(data){
				if(data.interview_content!=null){
					 $('#content3').val(data.interview_content);
				 } else{ 
					 $('#content3').val("내용 입력바람"); 
				 }
			}
		});
	}

	</script>
	
<!-- 성적입력활용 -->
<script type="text/javascript">
	function getEval(pnum){
		//alert("pnum->"+pnum);
		$.ajax({
			url:"<%=context%>/eval.do",
			data:{	pnum : pnum },
			dataType:'json',
			success:function(data){
				$('#ppeval').val(data.ppeval);  /*	 input Tag */
				$('#pteval').val(data.pteval);  /*	 input Tag */
			},
			error:function(request,status,error){
		        alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
		       }
		});
	}
</script>
	
	<!-- 탭활용 -->
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
	<div><a href="gangsa_main.do">강의페이지</a></div>
	<div class="updown">
		<h2>학생 명단</h2>
		<c:set var="num" value="${pg.total-pg.start+1}"></c:set>
		<table style="border-collapse: collapse;">
			<tr>
				<th>학생번호</th>
				<th>학생이름</th>
				<th>연락처</th>
				<th>강의번호</th>
				<th>이메일</th>
			</tr>
			<c:forEach var="person" items="${list }">
				<tr id="btn_idCheck"
					onclick="getPNum(${person.pnum }),getContent1(${person.pnum }),getContent2(${person.pnum }),getContent3(${person.pnum }),getEval(${person.pnum })">
					<td>${num }/${person.gubun}${person.yymm}${person.pnum}</td>
					<td>${person.pname }</td>
					<td>${person.ptel }</td>
					<td>${person.class_num }</td>
					<td>${person.pemail }</td>
				</tr>
				<c:set var="num" value="${num - 1 }"></c:set>
			</c:forEach>
		</table>
		<c:if test="${pg.startPage > pg.pageBlock }">
			<a href="sjlist.do?currentPage=${pg.startPage-pg.pageBlock}">[이전]</a>
		</c:if>
		<c:forEach var="i" begin="${pg.startPage }" end="${pg.endPage }">
			<a href="sjlist.do?currentPage=${i}">[${i}]</a>
		</c:forEach>
		<c:if test="${pg.endPage < pg.totalPage }">
			<a href="sjlist.do?currentPage=${pg.startPage+pg.pageBlock}">[다음]</a>
		</c:if>
	</div>
	<p>
	<p>
	<div class="container">
		<ul class="tabs">
			<li class="tab-link current" data-tab="tab-1">인적사항</li>
			<li class="tab-link" data-tab="tab-2">면담일지</li>
			<li class="tab-link" data-tab="tab-3">성적</li>
		</ul>

		<div id="tab-1" class="tab-content current">
			클릭한 학생 이름 뭐 각종정보들 나오도록 할 것
			<p>
			<p>
				학번: <input type="text" id="psnum" readonly="readonly"
					placeholder="학생클릭/인적 사항 등록">
			<p>
				이름: <input type="text" id="pname" readonly="readonly"
					placeholder="학생클릭/인적 사항 등록">
			<p>
				주소: <input type="text" id="paddress" readonly="readonly"
					style="width: 300px;" placeholder="학생클릭/인적 사항 등록">
		</div>
		<div id="tab-2" class="tab-content">
			<div class="i-i">
				<a href="sjwriteInterviewForm.do">면담 입력</a>
			</div>
			<h3>1차 면담</h3>
			1차 면담: <input type="text" id="content1" readonly="readonly"
				placeholder="학생클릭/면담 내용 등록">

			<h3>2차 면담</h3>
			2차 면담: <input type="text" id="content2" readonly="readonly"
				placeholder="학생클릭/면담 내용 등록">

			<h3>3차 면담</h3>
			3차 면담: <input type="text" id="content3" readonly="readonly"
				placeholder="학생클릭/면담 내용 등록">
		</div>
		<div id="tab-3" class="tab-content">
			<div class="i-i">
				<a href="sjwriteScoreForm.do">성적 입력</a>
			</div>
			<h3>성적</h3>
			ppeval: <input type="text" id="ppeval" readonly="readonly"
				placeholder="학생클릭/성적 입력"><p>
			pteval: <input type="text" id="pteval" readonly="readonly"
				placeholder="학생클릭/성적 입력">	
		</div>

	</div>

</body>
</html>