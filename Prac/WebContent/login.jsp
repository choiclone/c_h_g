<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="loginAction.jsp" method="post">
		<table border='1'>
			<tr>
				<td>아디</td>
				<td><input type="text" name="user_id"></td>
			</tr>
			<tr>
				<td>비번</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
			<td><input type="submit" value="로그인">
			<input type="button" value="영화 조회" onclick="location.href='mv_list.jsp'">
			</td>
			</tr>
		</table>
	</form>
</body>
</html>