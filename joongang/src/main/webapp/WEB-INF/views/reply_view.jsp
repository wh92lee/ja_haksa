<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"   %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="reply.do" method="post">
		<input type="hidden" name="b_no"     value="${board.b_no}">
		<input type="hidden" name="b_group"  value="${board.b_group}">
		<input type="hidden" name="b_step"   value="${board.b_step}">
		<input type="hidden" name="b_indent" value="${board.b_indent}">
	   <table width="500" cellpadding="0" cellspacing="0" border="1">
			<tr><td> 번호 </td><td> ${board.b_no} </td></tr>
			<tr><td> 히트 </td><td> ${board.b_hit} </td></tr>
			<tr><td> 이름 </td><td> <input type="text" name="b_name" value="${board.b_name}"></td></tr>
			<tr><td> 제목 </td><td> <input type="text" name="b_title" value="re:" +"${board.b_title}"></td></tr>
			<tr><td> 내용 </td><td> <textarea rows="10"  name="b_content">${board.b_content}</textarea></td></tr>
			<tr>
				<td colspan="2"><input type="submit" value="답변저장"> 
				<a href="list" >목록</a></td>
			</tr>
	   </table>
	</form>
	
</body>
</html>