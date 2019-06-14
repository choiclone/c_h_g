<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내정보수정</title>
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
<script type="text/javascript">
	//<![CDATA[
	function check() {
		var form = document.getElementById("editAccountForm");
		
		if(!form.pw.value){
			alert("정보수정을 위해서는 비밀번호가 필요합니다. 꼭 입력해주세요");
		    form.pw.focus();
		    return false;
		}
		//TODO 유효성 검사
		return true;
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
			<div id="content">
				<h1>내정보수정</h1>
				<p>
					이름과 휴대번호만 변경할 수 있습니다.<br /> 비밀번호는 <a href="changePasswd">비밀번호
						변경</a>을 이용하세요.<br />
				</p>
				<form id="editAccountForm" action="editAccount" method="post"
					onsubmit="return check()">
					<table>
						<tr>
							<td>이름(Full Name)</td>
							<td><input type="text" name="name" value="${check.name }" /></td>
						</tr>
						<tr>
							<td>휴대번호</td>
							<td><input type="text" name="mobile"
								value="${check.mobile }" /></td>
						</tr>
						<tr>
							<td>현재 비밀번호(Password)</td>
							<td><input type="password" id="pw" name="passwd" /></td>
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