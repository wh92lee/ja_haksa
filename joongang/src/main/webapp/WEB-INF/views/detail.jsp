<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"   %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String context = request.getContextPath();

%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/httpRequest.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript">

	function comodify(vc_no){
		alert("수정 확인 요망  ");
		
		$.ajax({
			url: "<%=context%>/comodify.do",
			data : {c_no : vc_no},
			dataType : 'text',
			success:function(data){
				$('#c_content').val(data);
				
						
			}
			
		});
		 $('#formId > table').append('<input type="hidden" name="c_no" id="c_no">');
		$("#formId").attr("action", "replyconupdt.do");
		$('#c_no').val(vc_no);


		
	}
	function comdelet(vc_no, b_no){
		alert("삭제 확인 요망 ");
		$.ajax({
			url: "<%=context%>/comdelet.do",
			data : {c_no : vc_no, b_no: b_no},
			dataType : 'text',
		
			
		});
		location.reload();
		
		
	}
	
	

</script>



</head>
<body>



	<form action="modifyform.do" method="post">
		<input type="hidden" name="b_no" value="${board.b_no}">
	    <table cellpadding="0" cellspacing="0" border="1">
		  <tr> <td> 히트 </td><td> ${board.b_hit}</td> </tr>
		  <tr> <td> 이름 </td><td><input type="text" name="b_name" value="${board.b_name}"></td></tr>
		  <tr> <td> 제목 </td><td> <input type="text" name="b_title" value="${board.b_title}"></td></tr>
		  <tr> <td> 내용 </td><td> <textarea rows="10" name="b_content" >${board.b_content}</textarea></td></tr>
		  <tr> <td colspan="2"> <input type="submit" value="수정"> &nbsp;&nbsp; 
				                  <a href="hhlist.do">목록보기</a> &nbsp;&nbsp; 
				                  <a href="delete.do?b_no=${board.b_no}">삭제</a> &nbsp;&nbsp; 
				                  <a href="reply_view.do?b_no=${board.b_no}">답변</a></td>
			</tr>
	  </table>
	  
	<table> 
		<tr>
			<td>이름</td><td>내용</td>
		</tr>
		<c:forEach items="${clist}" var="dto">
		  <tr>
			<td>${dto.c_name}</td>
			<td>${dto.c_content}</td>
			<td><input type="button" onclick="comodify(${dto.c_no})" value="수정"></td>
			<td><input type="button" onclick="comdelet(${dto.c_no},${board.b_no})" value="삭제"></td>
		  </tr>
		</c:forEach>
	</table>
	</form>
	
	
	
	
	

	<form  id="formId" action="replycon.do" method="post">
		<input type="hidden" name="b_no" value="${board.b_no}">
		
	<table>
	<tr ><td rowspan="2">내용</td><td rowspan="2"><textarea rows="10" cols="10" name="c_content" id="c_content"></textarea></td><td>이름</td><td><input type="text" name="c_name"></td></tr>
	<tr><td colspan="2"><input type="submit" value="입력"> </td> </tr>
	</table>
	


	
	
	
</body>
</html>







