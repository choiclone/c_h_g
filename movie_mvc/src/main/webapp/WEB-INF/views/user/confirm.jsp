<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>비밀번호가 변경확인</title>
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
<script type="text/javascript">
//<![CDATA[
//]]>
</script>
</head>
<body>

	<div id="wrap">

		<div id="header">
			<jsp:include page="../m/header.jsp"/>
		</div>

		<div id="container">
			<div id="content">
<!-- 				<div id="url-navi">회원</div> -->

				<!-- 본문 시작 -->
				<h1>비밀번호가 변경되었습니다.</h1>
				변경된 비밀번호로 다시 로그인하실 수 있습니다.<br /> <input type="button" value="로그인"
					onclick="location.href='/user/login'" />
				<!--  본문 끝 -->

			</div>
			<!-- content 끝 -->
		</div>
		<!--  container 끝 -->

<!-- 		<div id="sidebar"> -->
<%-- 			<%@ include file="lU_menu.jsp"%> --%>
<!-- 		</div> -->

		<div id="footer">
			<%@ include file="../m/footer.jsp"%>
		</div>

	</div>
</body>
</html>