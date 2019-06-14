<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
<link rel="stylesheet" type="text/css" href="/resources/css/main.css">
<script type="text/javascript">
	//<![CDATA[
	function login() {
		var form = document.getElementById("loginForm");
		//TODO 유효성 검사
		return true;
	}
	//]]>
</script>
</head>
<body>
	<%@ include file="../m/header.jsp"%>
	<div id="wrap">
		<div class="container">
			<div class="content">
				<h1>로그인</h1>
				<form id="loginForm" action="login" method="post"
					onsubmit="return login()">
					<table>
						<tr>
							<td>아이디(이메일)</td>
							<td><input type="text" id="em" name="email" /></td>
						</tr>
						<tr>
							<td>비밀번호(특수문자!)</td>
							<td><input type="password" id="pw" name="passwd" /></td>
						</tr>
						<!-- 						<tr> -->
						<!-- 						   <td colspan="2"align="right"> -->
						<!-- 						   <input type="checkbox" name="check" value="on">id/pw저장 -->
						<!-- 						   <input type="hidden" name="check" value="off"> -->
						<!-- 						   </td> -->
						<!-- 						</tr> -->
					</table>

					<div class="btn_line">
						<input type="submit" value="확인" /> <input type="button"
							value="회원가입" onclick="location.href='/user/signUp'" />
					</div>
				</form>
			</div>
		</div>
		
		<div id="sidebar">
		<%@ include file="notLoginU.jsp"%>
		</div>
		<div id="footer">
			<%@ include file="../m/footer.jsp"%>
		</div>

	</div>

</body>
</html>