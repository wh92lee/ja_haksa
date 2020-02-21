<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	margin: 0;
}
</style>
</head>
<body>
	<div class="nav_top">
		${sessionScope.pid }님 환영합니다. | 
		로그아웃 |
		회원정보수정 |
		자기소개서 등록 |
		출결기록
	</div>
	<div class="menu-box-1">
		<ul>
			<li class="nav-item2">학사관리 메뉴</li>
			<li><a href="">학생 관리</a>
				<ul>
					<li>학생명부</li>
					<li><a href="">가입승인</a></li>
					<li>출석현황</li>
					<li>휴가관리</li> 
				</ul>
			</li>	
			<li><a href="">임직원 관리</a>
				<ul>
					<li>임직원명부</li>
					<li>임직원등록</li>
				</ul>
			</li>	
			<li><a href="">프로그램 관리</a>
				<ul>
					<li>프로그램</li>
					<li>강의자료</li>
				</ul>
			</li>	
		</ul>
	</div>
</body>
</html>