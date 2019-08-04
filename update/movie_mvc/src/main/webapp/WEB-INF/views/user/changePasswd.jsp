<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8" />
<title>비밀번호 변경</title>
<link rel="stylesheet" type="text/css" href="/resources/css/style.css" />
<script type="text/javascript">
	//<![CDATA[
	function check() {
		var form = document.getElementById("changePasswordForm");

		if(!form.passwd.value){
			alert("변경하실 비밀번호를 입력해주세요.");
			form.passwd.focus();
			return false;
		}
		if(form.passwd.value != form.confirm.value){
			alert("변경 비밀번호와 변경 비밀번호 확인 값이 같지 않습니다.");
			form.confirm.focus();
			return false;
		} 
		if(form.passwd.value == form.confirm.value) {
			return true;
		}
	}
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
				<h1>비밀번호 변경</h1>
				${check.name}님은 로그인 상태입니다.<br /> 이메일 ${check.email}<br /> 휴대번호
				${check.mobile}<br />
				<form id="changePasswordForm" action="changePasswd" method="post"
					onsubmit="return check()">
					<table>
						<tr>
							<td>변경 비밀번호</td>
							<td><input type="password" name="passwd" id="passwd"/></td>
						</tr>
						<tr>
							<td>변경 비밀번호 확인</td>
							<td><input type="password" name="confirm" /></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" value="확인" /></td>
						</tr>
					</table>
				</form>
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