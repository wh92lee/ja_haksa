<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="chatbotcss.jsp"%>
<%@ include file="memberCheck.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<!-- <script type="text/javascript">

function submitFunction() {
	var question_Num = '${question_Num}';
	// var room_manager = '${room_manager}';
	var fromID = '${sessionScope.id}';
	var user_Question = $('#user_Question').val();
	$.ajax({
		type:"post",
		url:"AjaxChatSubmit.jsp",
		data:{
			question_Num : question_Num,
		//	room_manager : encodeURIComponent(room_manager),
			fromID : encodeURIComponent(fromID),
			user_Question:encodeURIComponent(user_Question)
		},
		success:function(result){
		}
	});
	$('#user_Question').val('');
}
var lastID = 0; 
function chatListFunction(type){
	var question_Num = '${question_Num}';
	var fromID = '${sessionScope.id}';
	// var room_manager = '${room_manager}';
	$.ajax({
		type:'POST',
		url:"AjaxChatList.jsp",
		data:{
			question_Num : question_Num,
			fromID : encodeURIComponent(fromID),
			// room_manager : encodeURIComponent(room_manager),
			listType: type
		},
		success:function(data){
			if(data == "") return;
			var parsed = JSON.parse(data);
			var result = parsed.result;
			for(var i = 0; i< result.length; i++){
				if(result[i][0].value== fromID){
					result[i][0].value='나';
					
				}
				addChat(result[i][0].value, result[i][1].value, result[i][2].value);
			}
			lastID = Number(parsed.last);
		}
	}); 
}
/* function addChat(chatName, chatContent, Reg_Date){
	$('#chatList').append('<div class="row">'+
			'<div class="col-lg-12">'+
			'<div class="media">'+
			'<a class="pull-left" href="#">'+
			'<img class="media-object img-circle" style="width:30px; height:30px;" src="images/icon.png" alt="">'+
			'</a>'+
			'<div class="media-body">'+
			'<h4 class="media-heading">'+
			chatName +  
			'<span class="small pull-right">'+
			chatTime +
			'</span>'+
			'</h4>'+
			'<p>'+
			chatContent+
			'</p>'+
			'</div>'+
			'</div>'+
			'</div>'+
			'</div>'+
			'<hr>');
	$('#chatList').scrollTop($('#chatList')[0].scrollHeight);
} */
 function getInfiniteChat(){
	setInterval(function(){
		chatListFunction(lastID);
	}, 3000);
} 
</script> -->
<script type="text/javascript">
	/* 	know = {
	 "기업추천":"검색중입니다 잠시만 기다려주세요",
	 "" : "질문해주세요 ^^"
	 }; */
	function talk() {
		str2 = "기업추천";
		// 사용자가 입력한 내용
		var user = document.getElementById("userBox").value;
		//        alert("str2->"+str2);
		alert("user1->" + user);
		idx = user.indexOf(str2);
		document.getElementById("chatLog").innerHTML += user + "<br>";
		//  alert("idx->"+idx);
		if (idx >= 0) {
			//			 alert("일치합니다");
			document.getElementById("chatLog").innerHTML += "잠시만 기다려주세요<br>";
			alert("user2->" + user);
			location.href = "iq.do?userQuestion=" + user
		} else {
			document.getElementById("chatLog").innerHTML += "잘모르겠어요<br>";
		}

		/* document.getElementById("userBox").value = "";
		document.getElementById("chatLog").innerHTML += user+"<br>";
		if (user in know) {
		    document.getElementById("chatLog").innerHTML += know[user]+"<br>";
		    
		} else {
		    document.getElementById("chatLog").innerHTML += "I don't understand...<br>";
		} */
	}
</script>
</head>
<body>
<%-- 	<%=
		
	 session.setAttribute("gubun", "gubun"));  
	 session.setAttribute("yymm", "${sessionScope.loginPersonInfo.yymm}");  
	 session.setAttribute("pnum", "${sessionScope.loginPersonInfo.pnum}");  
	 session.setAttribute("pid", "${sessionScope.loginPersonInfo.pid}");	
	 %> --%>
	
	<%-- <c:choose>
		<c:when test="${not empty sessionScope.loginPersonInfo}">
			<input type="hidden" name="gubun" id="gubun" value="${sessiomScope.loginPersonInfo.gubun }">
			<input type="hidden" name="yymm" id="yymm" value="${sessiomScope.loginPersonInfo.yymm }">
			<input type="hidden" name="pnum" id="pnum" value="${sessiomScope.loginPersonInfo.pnum }">
			<input type="hidden" name="pid" id="pid" value="${sessiomScope.loginPersonInfo.pid }">
		</c:when>
	</c:choose> --%>
	
	<span class="more"> <span class="blind">상담하기 V</span>
	</span>
	<div class="board">
		<div class="container bootstrap snippet">
			<div class="row">
				<div class="col-xs-12">
					<div class="portlet portlet-default">
						<div class="portlet-heading">
							<div class="portlet-title">
								<h4>
									<i class="fa fa-circle text-green"></i>상담하기
								</h4>
							</div>
							<div class="clearfix"></div>
						</div>
						<div id="chat" class="panel-collapse collapse in">
							<div id="chatLog" class="portlet-body chat-widget"
								style="overflow-y: auto; width: 938px; height: 300px;">
								무엇을 도와드릴까요?</div>
							<div class="portlet-footer">
								<div class="row" style="height: 90px;">
									<div class="form-group col-xs-10">

										<!-- <textarea style="height: 80px;" id="userBox" class="form-control" placeholder="메세지를 입력하세요." maxlength="100"  name=""></textarea> -->
										<input type="text" style="height: 80px;" id="userBox"
											class="form-control" maxlength="100" name="userQuestion">
									</div>
								</div>
								<div class="form-group col-xe-2">
									<button type="button" class="btn btn-default pull-right"
										onclick="talk();">전송</button>
									<!-- <a href="http://127.0.0.1:8000/polls/reg" target="_blank">Linear Regression</a> -->
									<div class="clearfix"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>




</body>
</html>
