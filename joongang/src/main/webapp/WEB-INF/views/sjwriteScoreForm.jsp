<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${msg!=null}">${msg}</c:if>
<form action="write_score.do" method="post" name="Interview">
<table>
	<h3>1차 시험</h3>
	<tr>
	<th>입력할 학생 번호</th>
	<td><input type="number" name="pnum" placeholder="예) 101"></td>
	</tr><tr>
	<th>ppeval</th>
	<td><input type="number" name="ppeval"></td>
	</tr>
	<tr>
	<th>pteval</th>
	<td><input type="number" name="pteval"></td>
	</tr>
	<tr><td><input type="submit" value="확인"></td></tr>
</table>
</form>
</body>
</html>