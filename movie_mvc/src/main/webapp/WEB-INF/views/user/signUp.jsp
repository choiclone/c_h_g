<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
<link rel="stylesheet" type="text/css" href="/resources/css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<script type="text/javascript">
	//<![CDATA[
	function check() {
		var form = document.getElementById("signUpForm");

		if (!form.name.value) {
			alert("이름은 공백처리할 수 없습니다.");
			form.name.focus();
			return;
		}
		if (!form.pw.value
				.match(/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9]){8,20}/)) {
			alert("비밀번호는 8~20자까지 써주시고 특수문자를 포함해주세여");
			form.pw.focus();
			return;
		}
		if (!form.cf.value.match(form.pw.value)) {
			alert("같은 비밀번호가 아닙니다 다시 입력해주세여");
			form.cf.focus();
			return;
		}
		if (!form.email.value
				.match(/^[a-z0-9_+.-]+@([a-z0-9-]+\.)+[a-z0-9]{2,4}$/)) {
			alert("이메일과 동일하게 해주셈.");
			form.email.focus();
			return;
		}
		if (!form.mb.value) {
			alert("휴대전화는 공백처리할 수 없습니다.");
			form.mb.focus();
			return;
		}
		form.submit();
	}
	//]]>
</script>
</head>
<body>

	<%@ include file="../m/header.jsp"%>
	<div id="wrap">
		<div class="container">
			<div class="content">
				<h1>회원가입</h1>
				<form id="signUpForm" action="signUp" method="post">
					<table class="signUp">
						<tr>
							<td>이름</td>
							<td><input type="text" id="name" name="name" /></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" id="pw" name="passwd" /></td>
						</tr>
						<tr>
							<td colspan="2" style="text-align: center; font-weight: bold;">
								Email이 아이디로 사용됩니다. 따라서 비밀번호는 Email 계정 비밀번호와 같게 하지 마세요.</td>
						</tr>
						<tr>
							<td>비밀번호 확인</td>
							<td><input type="password" id="cf" name="confirm" /></td>
						</tr>
						<tr>
							<td>Email</td>
							<td><input type="text" id="email" name="email" /></td>
						</tr>
						<tr>
							<td>휴대번호</td>
							<td><input type="text" id="mb" name="mobile" /></td>
						</tr>
					</table>
					<div class="btn_line">
						<input type="button" value="확인" onclick="check()" /> <input
							type="reset" value="취소" />
					</div>


				</form>
				<!--  본문 끝 -->

			</div>
			<!-- content 끝 -->
		</div>
<!-- 		 container 끝 -->

						<div id="sidebar">
							<%@ include file="notLoginU.jsp"%>
						</div>

				<div id="footer">
					<%@ include file="../m/footer.jsp"%>
				</div>

	</div>
</body>
</html>