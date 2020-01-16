<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>학생 명단</h2>
 	<c:set var="num" value="${pg.total-pg.start+1}"></c:set> 
	<table>
		<c:forEach var="Interview" items="${list }">
			<tr>
				 <td>${num }</td>
				<td>${interview.pnum }${Interview.pnum }</td>
			</tr>
			 <c:set var="num" value="${num - 1 }"></c:set> 
		</c:forEach>
	</table>
 	<c:if test="${pg.startPage > pg.pageBlock }">
		<a href="list.do?currentPage=${pg.startPage-pg.pageBlock}">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${pg.startPage }" end="${pg.endPage }">
		<a href="list.do?currentPage=${i}">[${i}]</a>
	</c:forEach>
	<c:if test="${pg.endPage < pg.totalPage }">
		<a href="list.do?currentPage=${pg.startPage+pg.pageBlock}">[다음]</a>
	</c:if> 
</body>
</html>