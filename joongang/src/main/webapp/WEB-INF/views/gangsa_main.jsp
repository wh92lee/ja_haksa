<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String context = request.getContextPath();
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.js"></script>


<script type="text/javascript" src="js/httpRequest.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script type="text/javascript">
function popupOpen(){

	var popUrl = "/abc/uploadClassPage.do";	//팝업창에 출력될 페이지 URL
	var popOption = "width=370, height=360, resizable=no, scrollbars=no, status=no;";    //팝업창 옵션(optoin)
	window.open(popUrl,"",popOption);
}


</script>
<style type="text/css">
.photo {
	width:100px;
	height:100px;
}
</style>
</head>
<body>
	<div><img class="photo" src="images/kwangA1.jpg"><p>강사님사진</p></div>
	<a href="javascript:popupOpen();">강의자료 올리기</a>
	<div>오늘의 출결 공간</div>
	<div>강의자료 공간<a href="student_main.do"><p></p> 강의 올리기 클릭 확인</a> </div>	
	
	<div>질의응답 공간</div>		
</body>
</html>