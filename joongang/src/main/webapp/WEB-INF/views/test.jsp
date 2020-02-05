<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#sidebar{float:left;}


ul{list-style:none;margin:0px; padding:0px;position:relative;text-align:center;}
ul li a{text-decoration:none;display:block; width:100px;height: 35px; line-height:35px;}
li{width:100px;background-color:#9FC93C;}
ul li:hover{background-color:#D4F4FA;}
ul ul{display:none;position:relative; left: 0px; top: 0px;}
ul ul#toggle{display:none;position:relative; left: 0px; top: 0px;}
ul li:checked > ul {display:block;}
#contents{float:left;width:500px; height: 300px;border:1px solid green;}
</style>

<script type="text/javascript">
$("#toggle").toggle(); // show -> hide , hide -> show
</script>
</head>
<body>
<div id="sidebar">
<ul> 
  <li><a href="#">menu1</a>
  	<ul id="toggle">
       <li><a href="http://opencast.naver.com/IT741">sub menu1</a></li>
       <li><a href="http://opencast.naver.com/IT741">sub menu2</a></li>
       <li><a href="http://opencast.naver.com/IT741">sub menu3</a></li>
    </ul>
  </li>
  <li><a href="http://opencast.naver.com/IT741">menu2</a>
    <ul>
       <li><a href="http://opencast.naver.com/IT741">sub menu1</a></li>
       <li><a href="http://opencast.naver.com/IT741">sub menu2</a></li>
       <li><a href="http://opencast.naver.com/IT741">sub menu3</a></li>
    </ul>
  </li>
  <li><a href="#">menu3</a>
  	 <ul>
       <li><a href="http://opencast.naver.com/IT741">sub menu1</a></li>
       <li><a href="http://opencast.naver.com/IT741">sub menu2</a></li>
       <li><a href="http://opencast.naver.com/IT741">sub menu3</a></li>
    </ul>
  </li>
</ul>
</div>
<div id="contents"> 
본문
</div>
</body>
</html>