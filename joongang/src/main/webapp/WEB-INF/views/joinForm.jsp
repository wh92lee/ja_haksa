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
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
 <script type="text/javascript">


    /** 
    onchange event handler for the file input field.
    It emplements very basic validation using the file extension.
    If the filename passes validation it will show the image using it's blob URL  
    and will hide the input field and show a delete button to allow the user to remove the image
    */

    $('#pprofile').on('change', function() {
        
        ext = $(this).val().split('.').pop().toLowerCase(); //확장자
        
        //배열에 추출한 확장자가 존재하는지 체크
        if($.inArray(ext, ['gif', 'png', 'jpg', 'jpeg']) == -1) {
            resetFormElement($(this)); //폼 초기화
            window.alert('이미지 파일이 아닙니다! (gif, png, jpg, jpeg 만 업로드 가능)');
        } else {
            file = $('#pprofile').prop("files")[0];
            blobURL = window.URL.createObjectURL(file);
            $('#profile img').attr('src', blobURL);
            $('#profile').slideDown(); //업로드한 이미지 미리보기 
            $(this).slideUp(); //파일 양식 감춤
        }
    });

    /**
    onclick event handler for the delete button.
    It removes the image, clears and unhides the file input field.
    */
    $('#profile a').bind('click', function() {
        resetFormElement($('#pprofile')); //전달한 양식 초기화
        $('#pprofile').slideDown(); //파일 양식 보여줌
        $(this).parent().slideUp(); //미리 보기 영역 감춤
        return false; //기본 이벤트 막음
    });
        

    /** 
    * 폼요소 초기화 
    * Reset form element
    * 
    * @param e jQuery object
    */
    function resetFormElement(e) {
        e.wrap('<form>').closest('form').get(0).reset(); 
        //리셋하려는 폼양식 요소를 폼(<form>) 으로 감싸고 (wrap()) , 
        //요소를 감싸고 있는 가장 가까운 폼( closest('form')) 에서 Dom요소를 반환받고 ( get(0) ),
        //DOM에서 제공하는 초기화 메서드 reset()을 호출
        e.unwrap(); //감싼 <form> 태그를 제거
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
		<form action="joinPro.do" method="post" name="frm" onsubmit="return chk()" id="join_form">
			<input type="hidden" id="idChkVal" name="idChkVal" value="0">
			<div id="j_container" role="main">
				<h2>회원가입</h2>
				<hr>
				<p>기본정보</p>
				<div class="left_info">
					<div class="join_form">
						<div class="left_title">
							아이디
						</div>
						<div class="left_content">
							<input type="text" name="pid" id="pid" required="required" maxlength="15"> 
							<input type="button" id="idChk" name="idChk" value="중복확인" > 
						</div>
					</div>
					<div class="join_form">
						<div class="left_title">
							비밀번호 
						</div>
						<div class="left_content">
							<input type="password" name="ppw" id="ppw" onchange="isSame()" required="required">
						</div>
					</div>
					<div class="join_form">
						<div class="left_title">
							비밀번호 확인  
						</div>
						<div class="left_content">
							<input type="password" name="ppw2" id="ppw2" onchange="isSame2()" required="required">&nbsp;&nbsp;<span id="same"></span>
						</div>
					</div>
					<div class="join_form">
						<div class="left_title">
							생년월일 
						</div>
						<div class="left_content">
							<input type="text" name="pbirth" id="pbirth" required="required" placeholder="예시 : 990707">
						</div>
					</div>
					<div class="join_form">
						<div class="left_title">
							나이  
						</div>
						<div class="left_content"> 
							<input type="number" name="age" id="age" required="required" style="width:40px;"> 세
						</div> 
					</div>
					<div class="join_form">
						<div class="left_title">
							E-mail  
						</div>
						<div class="left_content">
							<input type="email" name="pemail" id="pemail" required="required"/>
						</div>
					</div>
					<div class="join_form">
						<div class="left_title">
							주소 
						</div>
						<div class="left_content">
							<select id ="bcity_num" name="bcity_num" onchange="b_city()">
								<option value=""> 시 선택 </option>
								<%-- <c:forEach var="classlist" items="${classlist }">
									<option value="${classlist.class_num}">${classlist.class_name }</option>
								</c:forEach> --%>
							</select>
							<select id ="mcity_num" name="mcity_num" onchange="m_city()">
								<option value=""> 구 선택 </option>
								<%-- <c:forEach var="classlist" items="${classlist }">
									<option value="${classlist.class_num}">${classlist.class_name }</option>
								</c:forEach> --%>
							</select>
						</div> 
					</div>
					<div class="join_form">
						<div class="left_title">
							상세주소 
						</div>
						<div class="left_content">
							<input type="text" name="paddress" id="paddress" required="required">
						</div> 
					</div>
				</div>
				<div class="right_info">
					<div class="profile_form">
						<div id="profile">
							<img src="#">
							 <br />
       						 <a href="#">Remove</a>
						</div>
					</div>
					<div class="join_form">
						<div class="right_title">
							프로필사진  
						</div>
						<div class="right_content">
							<input type="file" name="pprofile" id="pprofile"/>
						</div>
					</div>
					<div class="join_form">
						<div class="right_title">
							이름 
						</div>
						<div class="right_content">
							<input type="text" name="pname" id="pname" required="required">
						</div>
					</div>
					<div class="join_form">
						<div class="left_title">
							연락처  
						</div>
						<div class="left_content"> 
							<input type="tel" name="ptel" id="ptel" required="required" patten="\d{2,3}-\d{3-4}-\d{4}"	placeholder="xxx-xxxx-xxxx">
						</div> 
					</div>
					<div class="join_form">
						<div class="right_title">
							성별 
						</div>
						<div class="right_content">
							<input type="radio" name="pgender" value=1 checked = "checked">남자 <input type="radio" name="pgender" value=2>여자
						</div>
					</div>
				</div>
				<div class="class_choice">
					<p>훈련과정선택</p>
					<div class="class_form">
						<div class="left_name">
							과정명
						</div>
						<div class="right_name">
							<select id ="class_num" name="class_num" onchange="sel_class()">
								<option value=""> 신청하신 훈련과정을 선택해주세요.</option>
								<c:forEach var="classlist" items="${classlist }">
									<option value="${classlist.class_num}">${classlist.class_name }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="class_left">
						<div class="class_form">
							<div class="left_title">
								교육시작일
							</div>
							<div class="left_content">
								<input type="text" name="class_start" id="class_start" disabled>
							</div>
						</div>
						<div class="class_form">
							<div class="left_title">
								모집정원
							</div>
							<div class="left_content">
								<input type="text" name="max_person" id="max_person" disabled>
							</div>
						</div>
					</div>
					<div class="class_right">
						<div class="class_form">
							<div class="right_title">
								교육종료일
							</div>
							<div class="right_content">
								<input type="text" name="class_end" id="class_end" disabled>
							</div>
						</div>
						<div class="class_form">
							<div class="left_title">
								현재모집인원
							</div>
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
						<input type="submit" value="가입완료"/> &nbsp;&nbsp;&nbsp;
						<input type="reset" value="다시작성"/>  &nbsp;&nbsp;&nbsp;
						<input type="button" value="취소" onclick="history.back(-1);">
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
