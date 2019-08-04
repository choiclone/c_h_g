
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
</head>
<body>
	<div class="head_liner">
		<header>
			<a href="/main"><img
				src="http://image2.megabox.co.kr//mop/home/logo_slogan.png"
				alt="MEGABOX" class="ie_logo big"></a>
			<ul>
				<li><a href="#">영화</a></li>
				<li><a href="#">큐레이션</a></li>
				<li><a href="#">영화관</a></li>
				<li><a href="#">특별관</a></li>
				<li><a href="#">스토어</a></li>
				<li><a href="#">이벤트</a></li>
				<c:choose>
					<c:when test="${empty check}">
						<li><a href="/user/login">로그인</a></li>
						<li><a href="/user/signUp">회원가입</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="/user/logout">로그아웃</a></li>
						<li><a href="/user/editAccount">내정보수정</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</header>
	</div>
</body>
</html>