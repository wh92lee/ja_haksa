<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.js"></script>
<style>
.file-item {
	float: left;
	margin-left: 10px;
	/* 한줄에 5개씩  */
	width: calc(20% - 10px);
	margin-bottom: 20px;
	/* border : 1px solid red; */
}

.file-item .img, .file-item .text {
	text-align: center;
}

.file-item .img img {
	max-width: 370px;
	max-height: 280px;
}

.file-item .img {
	cursor: pointer;
}

.file-item .text {
	font-weight: bold;
}
</style>

</head>
<body>

	<h1>JAVA언어</h1>
	<h3>프로그램 파일</h3>
	<form id="fileDownloadForm" method="post"
		action="downloadClassFile2.do">
		<input type="hidden" value="" name="classFileSeq"> <input
			type="hidden" value="" name="classNum">
	</form>


	<div class="file-box">
		<c:forEach items="${classFilesList }" var="item" varStatus="status">
			<div class="file-item">
				<div class="img"
					onclick="fileDownload('${item.classFileSeq}', '${classNum}')">
					<img src="images/unnamed.png">
				</div>
				<div class="text">
					<span>${item.classFileSeq}/${classNum}/${item.logicalName}</span>
				</div>
			</div>
		</c:forEach>
	</div>

	<!-- 	
			<h3>강의 자료</h3>
				<div id="jaryo">
					<talbe>
					//강의자료게시판
					</talbe>
				</div> -->



</body>
<script type="text/javascript">
	function popupOpen() {

		var popUrl = "test1.do"; //팝업창에 출력될 페이지 URL
		var popOption = "width=370, height=360, resizable=no, scrollbars=no, status=no;"; //팝업창 옵션(optoin)
		window.open(popUrl, "", popOption);
	}

	//파일 다운로드
	function fileDownload(classFileSeq, classNum) {
		$("#fileDownloadForm [name=classFileSeq]").val(classFileSeq);
		$("#fileDownloadForm [name=classNum]").val(classNum);
		$("#fileDownloadForm").submit();
	}
</script>
</html>