<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<%
	String context = request.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.js"></script>


<script type="text/javascript" src="js/httpRequest.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script type="text/javascript">
	function chk() {
		if (frm.idChkVal.value != "1") { //idChkVal.value = 1이 아니라면 중복체크를 안한것 default value = 0
			alert("아이디중복체크를 하셔야합니땅!");
			return false;
		}
		if (frm.passwd.value != frm.passwd2.value) {
			alert("암호가 일치하지 않습니땅!");
			frm.passwd.focus();
			return false;
		}
		return true;
	}
</script>
<script type="text/javascript">
	var contextPath='${pageContext.request.contextPath}';
	$(function() {
		$('#idChk').click(function() {
			
			var id = $('#id').val();
			var sendData = 'id=' + id;
			var msgTrim = "";
			frm.idChkVal.value = "1"; // click시 idChkVal value를 1로 변경
			$.ajax({
				url :"<%=context%>/idCheck.do",
				data:{pid:id},
				dataType:'text',
				success:function(data){
					msgTrim = data.replace(/(^\s*)|(\s*$)/g, "");
					// alert("msgTrim-->"+msgTrim) 
					if (msgTrim == "1") {
						$('#msg').html("이미 사용중인 아이디입니땅!");
						frm.idChkVal.value = "0"; // 초기화를 해야만 새로운 아이디 입력시 중복체크여부 확인
					} else {
						$('#msg').html("사용할수있는 아이디입니땅!");
					}
				}		
			});
		});
	});
</script>
</head>
<body>
	<div class="wrap">
		<form action="jw_joinPro.do" method="post" name="frm" onsubmit="return chk()" id="join_form">
			<input type="hidden" id="idChkVal" name="idChkVal" value="0">
			<div id="j_container" role="main">
				<div class="left_info">
					<div class="join_form">
						<div class="left_title">
							아이디 :
						</div>
						<div class="left_content">
							<input type="text" name="pid" id="pid" required="required">
						</div>
					</div>
					<div class="join_form">
						<div class="left_title">
							비밀번호 : 
						</div>
						<div class="left_content">
							<input type="password" name="ppw" id="ppw" required="required">
						</div>
					</div>
					<div class="join_form">
						<div class="left_title">
							비밀번호 확인 : 
						</div>
						<div class="left_content">
							<input type="password" name="ppw2" id="ppw2" required="required">
						</div>
					</div>
					<div class="join_form">
						<div class="left_title">
							이름 : 
						</div>
						<div class="left_content">
							<input type="text" name="pname" id="pname" required="required">
						</div>
					</div>
					<div class="join_form">
						<div class="left_title">
							생년월일 : 
						</div>
						<div class="left_content">
							<input type="text" name="pbirth" id="pbirth" required="required" placeholder="예시 : 990707">
						</div>
					</div>
					<div class="join_form">
						<div class="left_title">
							연락처 : 
						</div>
						<div class="left_content"> 
							<input type="tel" name="ptel" id="ptel" required="required" patten="\d{2,3}-\d{3-4}-\d{4}"	placeholder="xxx-xxxx-xxxx">
						</div> 
					</div>
				</div>
				<div class="right_info">
					<div>
						이미지 보여지는 창
					</div>
					<div class="join_form">
						<div class="right_title">
							프로필사진 : 
						</div>
						<div class="right_content">
							<input type="text" name="pprofile" id="pprofile">
						</div>
					</div>
					<div class="join_form">
						<div class="right_title">
							성별 : 
						</div>
						<div class="right_content">
							<input type="radio" name="pgender" value="M">남자 <input type="radio" name="pgender" value="W">여자
						</div>
					</div>
					<div class="join_form">
						<div class="right_title">
							주소 : 
						</div>
						<div class="right_content">
							<input type="text" name="paddress" id="paddress" required="required">
						</div> 
					</div>
					<div class="join_form">
						<div class="right_title">
							E-mail : 
						</div>
						<div class="right_content">
							<input type="email" name="pemail" id="pemail" required="required"/>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
