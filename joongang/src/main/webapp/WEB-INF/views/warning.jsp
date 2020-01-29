<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function CheckForm(Join) {

		//체크박스 체크여부 확인 [하나]
		var chk1 = document.frmJoin.U_checkAgreement1.checked;

		if (!chk1) {
			alert('무단배포 금지에 동의해 주세요');
			return false;
		}
	}
</script>



</head>
<body>
	<div id="w_wrap">
		<div id="w_container">
			<div class="w_warning">
				<img src="images/warning.png" alt="무단배포 금지"/>
			</div>
			<div class="frm">
				<form name="frmJoin" action="joinForm.do" onSubmit="return CheckForm(this)">
					
					<input type="checkbox" name="U_checkAgreement1"	id="U_checkAgreement1" value="" /> 동의 <p>
					<input type="submit" 	value="회원가입">
				</form>
			</div>
		</div>
	</div>
</body>
</html>