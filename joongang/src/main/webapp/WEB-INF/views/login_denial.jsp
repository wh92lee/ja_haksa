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
<c:if test="${alive == 'R' }">
	<script type="text/javascript">
		alert("가입승인 대기중 입니다. \n가입승인 문의는 학사관리팀(02-112-112) 으로 문의바랍니다.");
		location.href="login.do";
	
	</script>
</c:if>
<c:if test="${alive == 'D' }">
	<script type="text/javascript">
		alert("회원탈퇴 된 계정입니다.");
		location.href="login.do";
	
	</script>
</c:if>
</script>
</body>
</html>