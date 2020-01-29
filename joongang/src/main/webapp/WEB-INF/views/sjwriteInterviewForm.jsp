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
<form action="write_interview.do" method="post" name="Interview">
<table>
	<h3>1차 면담</h3>
	<tr>
	<th>pnum</th>
	<td><input type="number" name="pnum"></td>
	</tr>
	<tr>
	<th>gubun</th>
	<td><input type="number" name="gubun"></td>
	</tr>
	<tr>
	<th>yymm</th>
	<td><input type="number" name="yymm"></td>
	</tr>
	<tr>
	<th>interview_num</th>
	<td><input type="number" name="interview_num"></td>
	</tr>
	<tr>
	<th>teacher_num</th>
	<td><input type="number" name="teacher_num"></td>
	</tr>
<%-- 	<tr>
	<th>학생이름</th>
	<td><input type="text" name="pname" required="required">명단에서 선택한 후 보는거일테니 ${pname }</td>
	</tr> --%>
	<tr>
	<th>면담내용</th>
	<td><input type="text" name="interview_content"></td>
	</tr>
	<tr>
	<th>interview_count</th>
	<td><input type="number" name="interview_count"></td>
	</tr>
	<tr>
	<th>면담일</th>
	<td><input type="date" name="reg_date" required="required"></td>
	</tr>
	<tr><td><input type="submit" value="확인"></td></tr>
</table>
</form>
</body>
</html>