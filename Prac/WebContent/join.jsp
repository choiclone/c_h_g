<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function check() {
		var form = document.getElementById("join");
		
		if(!form.id.value){
			alert("아이디를 공백 없이 입력하세요");
			form.id.focus();
			return;
		}
		if(!form.pw.value.match(/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9]){8,20}/)){
			alert("비밀번호를 특수문자 포함하여 입력하세요");
			form.pw.focus();
			return;
		}
		if(!form.name.value){
			alert("이름을 공백없이 입력하세요");
			form.name.focus();
			return;
		}
		if(!form.gender.value){
			alert("성별을 체크해주세요");
			form.gender.focus();
			return;
		}if(!form.em.value){
			alert("이메일 형식에 맞게 입력해주세요");
			form.em.focus();
			return;
		}
		form.submit();
	}
</script>
</head>
<body>
	<h2>회원가입</h2>
	<form action="joinAction.jsp" id="join" method="post">
		<table border='1'>
			<tr>
				<td>아이디</td>
				<td><input type="text" id="id" name="user_id">
<!-- 				<input type="button" value="아이디 중복" onclick="check()"> -->
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" id="pw" name="password"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" id="name" name="name"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><input type="radio" name="gender" id="female" value="남자">남자 <input
					type="radio" name="gender" id="male" value="여자">여자</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="email" id="em" name="email"></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;"><input
					type="button" value="회원가입" onclick="check()"> <input
					type="button" value="취소" onclick="location.href='index.jsp'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>