<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<h1>파일 업로드 테스트</h1>
	<form id="frm" name="frm" enctype="multipart/form-data">
	<input type="file" name="file">
	<a href="#this" class="btn" id="write">업로드</a>
	</form>
	</div>
	

<script type="text/javascript">
	$(document).ready(function(){
		$("#write").on("click", function(e){ //업로드 버튼
			e.preventDefault();
		fn_FileUpload();
			
		});
		
	});
	
	function fn_FileUpload(){
		var comSubmit = new ComSubmit("frm");
		comSubmit.setUrl("<c:url value='/FileUpload.do'/>");
		comSubmit.submit();
		
	}

</script>
</body>

</html>