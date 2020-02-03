<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<%
	String context = request.getContextPath();
	//	System.out.println("context->" + context);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.12.0.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%-- <script type="text/javascript">
	function ch(pnum) {

		$.ajax({
			url:"<%=context%>/i_ch.do",
			data:{	pnum : pnum },
			dataType:'json',
			success:function(data){
				alert(data.gubun);
			    $('#gubun').val(data.gubun);
			    $('#yymm').val(data.yymm);
			
			}
		});
	}
	
	
</script> --%>
</head>
<body>
	<c:if test="${msg!=null}">${msg}</c:if>
	<form action="write_interview.do" method="post" name="Person">
		<table>
			<h3>1차 면담</h3>
			<tr>
				<th>psnum</th>
				<td> <input type="number" name="pnum" required="required"></td>
			</tr>
			<tr>
				<th>gubun</th>
				<td><input type="number" value=1 name="gubun" id="gubun" required="required"></td>
			</tr>
		 	<tr>
				<th>yymm</th>
				<td><input type="number" value=2001 name="yymm" id="yymm" required="required"></td>
			</tr> 
			<tr>
				<th>면담 차수</th>
				<td><input type="number" name="interview_count" required="required"></td>
			</tr>
			<tr>
				<th>면담내용</th>
				<td><input type="text" name="interview_content"></td>
			</tr>
			<tr>
				<th>면담일</th>
				<td><input type="date" name="reg_date"></td>
			</tr>
			<tr>
				<td><input type="submit" value="확인"></td>
			</tr>
		</table>
	</form>
</body>
</html>