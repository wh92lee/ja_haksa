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

<style type="text/css">
#photo {
	width:100px;
	height:100px;
}
</style>
</head>
<body>
강사 메인 페이지입니다.
작업부탁드립니다.
	<div><img id="photo" src="images/kwangA1.jpg">사진</div>
	
	<div>오늘의 출결 공간(프로시저구현)</div>
	<div>강의자료 공간<a href="file_upload.do">강의 올리기 클릭</a> </div>	
	<div>질의응답 공간</div>		
</body>
</html>