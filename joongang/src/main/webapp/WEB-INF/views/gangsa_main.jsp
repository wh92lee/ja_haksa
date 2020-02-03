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


</head>
<body>
강사 메인 페이지입니다.
작업부탁드립니다.
	<c:forEach var="photo" items="${photo }">
	<div>사진 공간${photo.pprofile }
	<%-- <img src="${pageContext.request.contextPath}/${rank1.img_folder }/${rank1.real_name }">
	 --%>										
	</div>
	</c:forEach>
	<div>오늘의 출결 공간(삭제)?</div>
	<div>강의자료 공간</div>	
	<div>질의응답 공간</div>		
</body>
</html>