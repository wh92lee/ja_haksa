<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"   %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="write.do" method="post" >
	    <table width="500" cellpadding="0" cellspacing="0" border="1">
			<tr>
				<td> 이름 </td> <td><input type="text" name="b_name" size = "50"> </td>
			</tr>
			<tr>
				<td> 제목 </td> <td><input type="text" name="b_title" size = "50"> </td>
			</tr>
			<tr>
				<td> 내용 </td> <td><textarea name="b_content" rows="10" ></textarea> </td>
			</tr>
			<tr >
				<td colspan="2"> <input type="submit" value="입력"> &nbsp;&nbsp; 
				<a href="list">목록보기</a></td>
			</tr>
    	</table>
	</form>
	
</body>
</html>