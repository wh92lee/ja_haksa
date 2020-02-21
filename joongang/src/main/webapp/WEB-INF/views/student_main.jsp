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
		width: calc( 20% - 10px ); 
		margin-bottom: 20px;		
		/* border : 1px solid red; */
	}
	
	
	

	
	.file-item .img, .file-item .text {
		text-align: center;
	}
	
	.file-item .img img{		
		max-width : 370px;
		max-height: 280px;
	}
	
	.file-item .img{		
		cursor: pointer;
	}
	
	.file-item .text {
		font-weight: bold;
	}

</style>


</head>
<body>


	 
	<!-- 선택 한 강의 명 출력 -->
	<h1>${class_num}</h1>
		<h3>프로그램 파일</h3>
		
	<!-- 	<a href="javascript:popupOpen();">정보 수정</a> -->
	
	
		
		
	
			
		<form id="DownloadForm" method="post" action="/abc/downloadClassFile2.do">
			<input type="hidden" value="" name="classFileSeq">
			<input type="hidden" value="" name="classNum">
		</form>
		
	
		<div class="file-box">
			<c:forEach items="${classFilesList }" var="item" varStatus="status">
				<div class="file-item">
					<div class="img" onclick="fileDownload('${item.classFileSeq}', '${item.classNum}')">
						<c:choose>
						<c:when test="${item.ext eq 'jpg' or item.ext eq 'png' or item.ext eq 'JPG' or item.ext eq 'PNG'}">
							<img src="/abc/upload/${item.physicalName}.${item.ext}">
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${empty item.iconUrl}">
									<img src="https://image.shutterstock.com/image-vector/picture-vector-icon-no-image-260nw-1350441335.jpg">
								</c:when>
								<c:otherwise>
									<img src="${item.iconUrl}">
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
					</div>
					<div class="text">
						<span>${item.logicalName}</span>
					</div>					
				</div>
			</c:forEach>
		</div> 
		
		<form id="JaryoDownloadForm" method="post" action="/abc/JaryodownloadClassFile2.do">
			<input type="hidden" value="" name="classFileSeq">
			<input type="hidden" value="" name="classNum">
		</form>
		
		
			<h3>강의 자료</h3>
				<div id="jaryo">
					<table>
						<c:forEach items="${list}" var="item1" >
						
						</c:forEach>
					
					
						
							
					</table>
				</div> 
			
		<!-- 출석 체크 시 조퇴로 버튼 변환 -->	
			<button>출석</button>
			<button>조퇴</button>





</body>
<script type="text/javascript">

//파일 다운로드
function fileDownload(classFileSeq, classNum){
	$("#fileDownloadForm [name=classFileSeq]").val(classFileSeq);
	$("#fileDownloadForm [name=classNum]").val( classNum);
	$("#fileDownloadForm").submit();
}

//강의자료 다운로드
function jaryoDownload(classFileSeq, classNum){
	$("#jaryoDownloadForm [name=classFileSeq]").val(classFileSeq);
	$("#jaryoDownloadForm [name=classNum]").val( classNum);
	$("#jaryoDownloadForm").submit();
}




/* 	function popupOpen() {

		var popUrl = "test1.do"; //팝업창에 출력될 페이지 URL
		var popOption = "width=370, height=360, resizable=no, scrollbars=no, status=no;"; //팝업창 옵션(optoin)
		window.open(popUrl, "", popOption);
	} */




</script>
</html>