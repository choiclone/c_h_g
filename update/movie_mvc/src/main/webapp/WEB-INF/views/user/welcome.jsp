<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
<script type="text/javascript">
	//<![CDATA[
	//]]>
</script>
</head>
<body>

	<div id="wrap">

		<div id="header">
			<%@ include file="../m/header.jsp"%>
		</div>

		<div id="container">
			<div id="content" style="min-height: 800px;">
<!-- 				<div id="url-navi">회원</div> -->

				<!-- 본문 시작 -->
				<h1>환영합니다.</h1>
				${check.name }님은<br />이제 영화를 보고 예메하실 수 있습니다.<br />
				<input type="button" value="로그인"
					onclick="#" />
				<!--  본문 끝 -->

			</div>
			<!-- content 끝 -->
		</div>
		<!--  container 끝 -->

		<div id="sidebar"></div>

		<div id="footer">
			<%@ include file="../m/footer.jsp"%>
		</div>

	</div>
</body>
</html>