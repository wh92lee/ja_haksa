<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="<c:url value="js/jquery-1.9.1.js" />">
<script type="text/javascript">
	function idchk() {
		if (!frm.pid.value) {
			alert("ID를 입력해주세요.");
			frm.pid.focus();
			return false;
		}
		return true;
	}
	function passwdchk() {
		if (!frm.ppw.value) {
			alert("비밀번호를 입력해주세요.");
			frm.ppw.value();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<div id="wrap">
	<div id="container">
		<div class="test">
			<div>로그인하는 페이지 입니다.</div>
			<div class="login_form">
				<form action="loginPro.do" name="frm" method="post">
				아이디 : <input type="text" name="pid" id="pid"  onsubmit="return idchk()"> &nbsp;&nbsp;
				비밀번호 : <input type="password" name="ppw" id="ppw" onsubmit="return passwdchk()" > &nbsp;
					<input type="submit" value="로그인"> &nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" value="회원가입"   onclick="location.href='warning.do'">&nbsp;
                    <input type="button" value="아이디찾기"   onclick="location.href='#'">&nbsp;
                    <input type="button" value="비밀번호찾기" onclick="location.href='#'">&nbsp;
				</form>
			</div>
		</div>
	</div>
	</div>


</body>
</html>