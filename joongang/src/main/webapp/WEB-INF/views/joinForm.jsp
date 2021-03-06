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
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script type="text/javascript">
	/* function chk() {
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
	} */
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
<script src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	var sel_file;
	
	$(document).ready(function(){
		$("#pprofile").on("change", handleImgFileSelect);
	});
	
	function handleImgFileSelect(e){
		var files = e.target.files;
		var filesArr = Array.prototype.slice.call(files);
		
		filesArr.forEach(function(f){
			if(!f.type.match("image.*")){
				alert("확장자는 이미지 확장자만 가능합니다.");
				return;
			}
			
			sel_file = f;
			
			var reader = new FileReader();
			reader.onload = function(e){
				$("#img").attr("src",e.target.result);
			}
			reader.readAsDataURL(f);
		});
	}
</script>
<script type="text/javascript">

    	function isSame(){
    		 var ppw = document.getElementById('ppw').value;
    		var ppw2 = document.getElementById('ppw2').value;
    		if(ppw.length < 6 || ppw.length > 16){
    			alert('비밀번호는 6자리 ~ 15자리만 사용 가능합니다.');
    			document.getElementById('ppw').value='';
    			document.getElementById('same').innerHTML='';
    			return false;
    		}
    	}
    	
    	function isSame2(){
    		 var ppw = document.getElementById('ppw').value;
    		var ppw2 = document.getElementById('ppw2').value;
    		if(ppw2.length < 6 || ppw2.length > 16){
    			alert('비밀번호는 6자리 ~ 15자리만 사용 가능합니다.');
    			document.getElementById('ppw2').value='';
    			document.getElementById('same').innerHTML='';
    			return false;
    		}
    		if(ppw!='' &&ppw2!=''){
    			if(ppw==ppw2){
    				document.getElementById('same').innerHTML='일치';
    				document.getElementById('same').style.color='blue';
    			}
    			else{
    				document.getElementById('same').innerHTML='불일치';
    				document.getElementById('same').style.color='red';
    			}
    		}
    	}
    </script>
<script type="text/javascript">
	    function sel_class(){
	      	var classnum = document.getElementById('class_num').value;
	    	$.ajax({
	    		url:"<%=context%>/getClassInfo.do",
	    		data:{class_num:classnum},
	    		dataType:'json',
	    		success:function(data){
	    			$('#class_start').val(data.class_start);
	    			$('#class_end').val(data.class_end);
					$('#max_person').val(data.max_person);
					$('#now_person').val(data.now_person);
	    		}
	    	});
	    };
    </script>
</head>
<body>
	<div class="wrap">
		<form action="joinPro.do" method="post" name="frm"
			onsubmit="return chk()" id="join_form">
			<input type="hidden" id="idChkVal" name="idChkVal" value="0">
			<div id="j_container" role="main">
				<h2>회원가입</h2>
				<hr>
				<p>기본정보</p>
				<div class="left_info">
					<div class="join_form">
						<div class="left_title">아이디</div>
						<div class="left_content">
							<input type="text" name="pid" id="pid" required="required"
								maxlength="15"> <input type="button" id="idChk"
								name="idChk" value="중복확인">
						</div>
					</div>
					<div class="join_form">
						<div class="left_title">비밀번호</div>
						<div class="left_content">
							<input type="password" name="ppw" id="ppw" onchange="isSame()"
								required="required">
						</div>
					</div>
					<div class="join_form">
						<div class="left_title">비밀번호 확인</div>
						<div class="left_content">
							<input type="password" name="ppw2" id="ppw2" onchange="isSame2()"
								required="required">&nbsp;&nbsp;<span id="same"></span>
						</div>
					</div>
					<div class="join_form">
						<div class="left_title">생년월일</div>
						<div class="left_content">
							<input type="text" name="pbirth" id="pbirth" required="required"
								placeholder="예시 : 990707">
						</div>
					</div>
					<div class="join_form">
						<div class="left_title">나이</div>
						<div class="left_content">
							<input type="number" name="age" id="age" required="required"
								style="width: 40px;"> 세
						</div>
					</div>
					<div class="join_form">
						<div class="left_title">E-mail</div>
						<div class="left_content">
							<input type="email" name="pemail" id="pemail" required="required" />
						</div>
					</div>
					<div class="join_form">
						<div class="left_title">주소</div>
						<div class="left_content">
							<select id="bcity_num" name="bcity_num" onchange="b_city()">
								<option value=""> 시 선택 </option>
								<%-- <c:forEach var="classlist" items="${classlist }">
									<option value="${classlist.class_num}">${classlist.class_name }</option>
								</c:forEach> --%>
							</select> <select id="mcity_num" name="mcity_num" onchange="m_city()">
								<option value=""> 구 선택 </option>
								<%-- <c:forEach var="classlist" items="${classlist }">
									<option value="${classlist.class_num}">${classlist.class_name }</option>
								</c:forEach> --%>
							</select>
						</div>
					</div>
					<div class="join_form">
						<div class="left_title">상세주소</div>
						<div class="left_content">
							<input type="text" name="paddress" id="paddress"
								required="required">
						</div>
					</div>
				</div>
				<div class="right_info">
					<div class="profile_form">
						<div id="profile">
							<img id="img" />
						</div>
					</div>
					<div class="join_form">
						<div class="right_title">프로필사진</div>
						<div class="right_content">
							<input type="file" name="pprofile" id="pprofile" />
						</div>
					</div>
					<div class="join_form">
						<div class="right_title">이름</div>
						<div class="right_content">
							<input type="text" name="pname" id="pname" required="required">
						</div>
					</div>
					<div class="join_form">
						<div class="left_title">연락처</div>
						<div class="left_content">
							<input type="tel" name="ptel" id="ptel" required="required"
								patten="\d{2,3}-\d{3-4}-\d{4}" placeholder="xxx-xxxx-xxxx">
						</div>
					</div>
					<div class="join_form">
						<div class="right_title">성별</div>
						<div class="right_content">
							<input type="radio" name="pgender" value=1 checked="checked">남자
							<input type="radio" name="pgender" value=2>여자
						</div>
					</div>
				</div>
				<div class="class_choice">
					<p>훈련과정선택</p>
					<div class="class_form">
						<div class="left_name">과정명</div>
						<div class="right_name">
							<select id="class_num" name="class_num" onchange="sel_class()">
								<option value=""> 신청하신 훈련과정을 선택해주세요.</option>
								<c:forEach var="classlist" items="${classlist }">
									<option value="${classlist.class_num}">${classlist.class_name }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="class_left">
						<div class="class_form">
							<div class="left_title">교육시작일</div>
							<div class="left_content">
								<input type="text" name="class_start" id="class_start" disabled>
							</div>
						</div>
						<div class="class_form">
							<div class="left_title">모집정원</div>
							<div class="left_content">
								<input type="text" name="max_person" id="max_person" disabled>
							</div>
						</div>
					</div>
					<div class="class_right">
						<div class="class_form">
							<div class="right_title">교육종료일</div>
							<div class="right_content">
								<input type="text" name="class_end" id="class_end" disabled>
							</div>
						</div>
						<div class="class_form">
							<div class="left_title">현재모집인원</div>
							<div class="left_content">
								<input type="text" name="now_person" id="now_person" disabled>
							</div>
						</div>
					</div>
				</div>
				<div class="foot">
					<div class="info_text">
						<span> 원활한 취업지원을 위해 가입 후에 개인정보 수정에서 상세정보까지 입력바랍니다.</span>
					</div>
					<div class="button">
						<input type="submit" value="가입완료" /> &nbsp;&nbsp;&nbsp; <input
							type="reset" value="다시작성" /> &nbsp;&nbsp;&nbsp; <input
							type="button" value="취소" onclick="history.back(-1);">
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
