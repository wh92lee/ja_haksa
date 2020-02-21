<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<style>
iframe {
	width: 0px;
	height: 0px;
	border: 0px
}
</style>
</head>
<body>
<%--   <p>  경복궁1 :  <img alt="경복궁1" src="${pageContext.request.contextPath}/upload/3ea46a55-fa04-40a1-9db6-6cf9aad37963_20150702_115327.jpg">
  <p>    kkk  <img src="c:\Upload\kh2.jpg">
 --%>	
   <form id="form1" action="uploadForm.do" method="post"
		enctype="multipart/form-data" target="myBatisFrame">
		<input type="file" name="file"> 
	    <input type="hidden" name="path" value="${pageContext.request.contextPath}/resources/image/"> 
		<input type="submit">
	</form>

	<iframe name="myBatisFrame"></iframe>

	<script>
		function addFilePath(msg) {
			alert(msg);
			document.getElementById("form1").reset();
		}
	</script>

</body>
</html>



</head>
<body>

   <form name="upload" action="uploadForm1.do" method="post" enctype="multipart/form-data">
		<table>
		<!--  <tr><th>upload_num</th><td><input type="number" name="upload_num"></td></tr>
		<tr><th>class_num</th><td><input type="number" name="class_num"></td></tr>
		 --><tr><th>savefile_name</th><td><input type="file" name="file"></td></tr>
		<!-- <tr><th>original_name</th><td><input type="text" name="original_name" id="original_name"></td></tr>
		 --><!-- <tr><th>reg_date</th><td><input type="date" name="reg_date"></td></tr>
		<tr><th>class_name</th><td><input type="text" name="class_name"></td></tr>
		<tr><th>room_num</th><td><input type="number" name="room_num"></td></tr>
		 --><tr><td><input type="submit" value="확인"></td></tr>
	    </table>
	</form>

</body>
</html>

