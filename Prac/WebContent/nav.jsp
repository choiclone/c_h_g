<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<ul>
		<li><input type="button" value="로그인" id="r" onclick="location.href='login.jsp'"></li>
		<li><input type="button" value="회원가입" id="y" onclick="location.href='join.jsp'"></li>
		<li><input type="button" value="영화 목록" id="g" onclick="location.href='mv_list.jsp'"></li>
		<li><input type="button" value="좌석조회" id="b" onclick="location.href='mv_sit.jsp'"></li>
		<li><input type="button" value="종료" id="p" onclick="javascript:window.close();"></li>
	</ul>
	</div>
</body>
</html>