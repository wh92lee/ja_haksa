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
<h2>직원정보</h2>
<form action="modify.do" method="post">
<input type="hidden" name="b_no" value="${board.b_no}">
<table>
	<tr> <td> 이름 </td><td><input type="text" name="b_name" value="${board.b_name}"></td></tr>
		  <tr> <td> 제목 </td><td> <input type="text" name="b_title" value="${board.b_title}"></td></tr>
		  <tr> <td> 내용 </td><td> <textarea rows="10" name="b_content" >${board.b_content}</textarea></td></tr>

	<tr><td colspan="2"><input type="submit" value="확인"> </td></tr>
</table>
</form>
</body>
</html>