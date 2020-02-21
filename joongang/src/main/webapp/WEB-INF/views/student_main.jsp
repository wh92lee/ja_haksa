<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%-- <%@ include file="chatbotcss.jsp"%> --%>
<%@ include file="memberCheck.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function talk() {
		str2 = "기업추천";
		var user = document.getElementById("userBox").value;
		var gubun = ${sessionScope.person.gubun};
		var yymm = ${sessionScope.person.yymm};
		var pnum = ${sessionScope.person.pnum};
		var pid = "${sessionScope.person.pid }";
		 var person1 = String(gubun) + String(yymm) + String(pnum); 

		/* alert("person1->" + person1); */
		idx = user.indexOf(str2);
		document.getElementById("chatLog").innerHTML += user + "<br>";
		$.ajax({
			url : "iq.do",
			data : {
				user_question : user,
				gubun : gubun,
				yymm : yymm,
				pnum : pnum,
				pid : pid
			},
			dataType : 'text',
			success : function(data) {
				/* alert(".ajax Data"+data);		 */
				$('#chatLog').appendTo(data);
			}
		});
		if (idx >= 0) {
			document.getElementById("chatLog").innerHTML += "잠시만 기다려주세요<br>";
			  /* alert("sucess person2->" + person1);  */
			 location.href = "http://127.0.0.1:8000/polls/" + person1+ "/ComRec";
			/* $.ajax({
				url:"http://127.0.0.1:8000/polls/" + person1+ "/ComRec",
				data:{					
				},
				dataType:'text',
				success: function (data) {
					alert("성공");
					$('#chatLog').appendTo(data);					
				}
			}); */
		} else {
			document.getElementById("chatLog").innerHTML += "잘모르겠어요<br>";
		}
	}
</script>

<script type="text/javascript" src="js/jquery.js"></script>
<style>

	.file-item {
		float: left;
		margin-left: 10px;
		/* 한줄에 5개씩  */
		width: calc( 20% - 10px ); 
		margin-bottom: 20px;		
		/* border : 1px solid red; */
	}
	
	
	

	
	.file-item .img, .file-item .text {
		text-align: center;
	}
	
	.file-item .img img{		
		max-width : 370px;
		max-height: 280px;
	}
	
	.file-item .img{		
		cursor: pointer;
	}
	
	.file-item .text {
		font-weight: bold;
	}

</style>
  

</head>
<body>

	<%-- <%=session.getAttribute("loginPersonInfo")%> --%>
	gubun: ${sessionScope.person.gubun } yymm: ${sessionScope.person.yymm}
	pum: ${sessionScope.person.pnum} pid: ${sessionScope.person.pid}
	<c:set var="person"
		value="${sessionScope.person.gubun }${sessionScope.person.yymm}${sessionScope.person.pnum}"></c:set>
	<%-- <a href="http://127.0.0.1:8000/polls/${person}/ComRec" target="_blank">Linear	Regression</a> --%>
	<c:choose>
		<c:when test="${not empty sessionScope.person}">
			<input type="hidden" name="gubun"
				value="${sessionScope.person.gubun }" />
			<input type="hidden" name="yymm" value="${sessionScope.person.yymm }" />
			<input type="hidden" name="pnum" value="${sessionScope.person.pnum }" />
			<input type="hidden" name="pid" value="${sessionScope.person.pid }" />

		</c:when>
	</c:choose>
	<span class="more"> <span class="blind">상담하기 V</span>
	</span>
	<div class="board">
		<div class="container bootstrap snippet">
			<div class="row">
				<div class="col-xs-12">
					<div class="portlet portlet-default">
						<div class="portlet-heading">
							<div class="portlet-title">
								<h4>
									<i class="fa fa-circle text-green"></i>상담하기
								</h4>
							</div>
							<div class="clearfix"></div>
						</div>
						<div id="chat" class="panel-collapse collapse in">
							<div id="chatLog" class="portlet-body chat-widget"
								style="overflow-y: auto; width: 938px; height: 300px;">
								무엇을 도와드릴까요?</div>
							<%-- <c:if test="${user_question!=null}">${user_question}</c:if> --%>

							<div class="portlet-footer">
								<div class="row" style="height: 90px;">
									<div class="form-group col-xs-10">

										<!-- <textarea style="height: 80px;" id="userBox" class="form-control" placeholder="메세지를 입력하세요." maxlength="100"  name=""></textarea> -->
										<input type="text" style="height: 80px;" id="userBox"
											class="form-control" maxlength="100" name="userQuestion">
									</div>
								</div>
								<div class="form-group col-xe-2">
									<button type="submit" class="btn btn-default pull-right"
										onclick="talk();">전송</button>
									<a href="http://127.0.0.1:8000/polls/ComRec" target="_blank">Linear Regression</a>
									<!-- session person 객체로 잡혀있을 시, 장고쪽에서 request session 으로 받을 수 있음 -->
									<!-- 만약 연산필요한 데이터, 가령 PPEVAL 데이터가 없을 시, 자바스크립트 사용해서, '전송' 버튼자체를 비활성화. 챗봇 처음 접속 시, "꼭 자기정보수정에서 정보를 입력해주세요" 추가 -->

									<%-- <a href="http://127.0.0.1:8000/polls/ComRec?PNUM=${sessionScope.person.pnum }&PPEVAL=${sessionScope.person.ppeval }" target="_blank">Linear Regression</a> --%>
									<!-- <a href="http://127.0.0.1:8000/polls/reg" target="_blank">Linear Regression</a> -->
									<div class="clearfix"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	학생 메인 페이지입니다. 작업부탁드립니다.
=======

	 
	
	<h1>${class_num}</h1>
		<h3>프로그램 파일</h3>
		
		<a href="javascript:popupOpen();">정보 수정</a>
	
	
		
		
	
			
		<form id="DownloadForm" method="post" action="/abc/downloadClassFile2.do">
			<input type="hidden" value="" name="classFileSeq">
			<input type="hidden" value="" name="classNum">
		</form>
		
	
		<div class="file-box">
			<c:forEach items="${classFilesList }" var="item" varStatus="status">
				<div class="file-item">
					<div class="img" onclick="fileDownload('${item.classFileSeq}', '${item.classNum}')">
						<c:choose>
						<c:when test="${item.ext eq 'jpg' or item.ext eq 'png' or item.ext eq 'JPG' or item.ext eq 'PNG'}">
							<img src="/abc/upload/${item.physicalName}.${item.ext}">
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${empty item.iconUrl}">
									<img src="https://image.shutterstock.com/image-vector/picture-vector-icon-no-image-260nw-1350441335.jpg">
								</c:when>
								<c:otherwise>
									<img src="${item.iconUrl}">
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
					</div>
					<div class="text">
						<span>${item.logicalName}</span>
					</div>					
				</div>
			</c:forEach>
		</div> 
		
		<form id="JaryoDownloadForm" method="post" action="/abc/JaryodownloadClassFile2.do">
			<input type="hidden" value="" name="classFileSeq">
			<input type="hidden" value="" name="classNum">
		</form>
		
		
			<h3>강의 자료</h3>
				<div id="jaryo">
					<table>
						<c:forEach items="${list}" var="item1" >
						
						</c:forEach>
					
					
						
							
					</table>
				</div> 




</body>
<script type="text/javascript">
//파일 다운로드
function fileDownload(classFileSeq, classNum){
	$("#fileDownloadForm [name=classFileSeq]").val(classFileSeq);
	$("#fileDownloadForm [name=classNum]").val( classNum);
	$("#fileDownloadForm").submit();
}

//강의자료 다운로드
function jaryoDownload(classFileSeq, classNum){
	$("#jaryoDownloadForm [name=classFileSeq]").val(classFileSeq);
	$("#jaryoDownloadForm [name=classNum]").val( classNum);
	$("#jaryoDownloadForm").submit();
}

//정보수정 팝업창
function popupOpen(){

	var popUrl = "/abc/self_introduction.do";	//팝업창에 출력될 페이지 URL
	var popOption = "width=370, height=360, resizable=no, scrollbars=no, status=no;";    //팝업창 옵션(optoin)
	window.open(popUrl,"",popOption);
}

</script>
</html>