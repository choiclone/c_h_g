<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<%
			String stuno;
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbs", "root", "apmsetup");
			String sql = "select max(stuno)+1 as maxstuno from student_tbl";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				stuno = rs.getString(1);
		%>
		<form action="writeAction.jsp" method="post">
			<table border="1" style="text-align: center;">

				<tr>
					<td style="text-align: center;">학번</td>
					<td><input type="text" name="stuno" value="<%=stuno%>"
						readonly="readonly"></td>
				</tr>
				<tr>
					<td style="text-align: center;">이름</td>
					<td><input type="text" name="stuname"></td>
				</tr>
				<tr>
					<td style="text-align: center;">학과</td>
					<td><input type="text" name="dept" size="20"></td>
				</tr>
				<tr>
					<td style="text-align: center;">주소</td>
					<td><input type="text" name="address" size="40"></td>
				</tr>
				<tr>
					<td style="text-align: center;">성별</td>
					<td><input type="text" name="gender"></td>
				</tr>
				<tr>
					<td style="text-align: center;">생년월일</td>
					<td><input type="date" name="birdate"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="등록"> <input
						type="button" value="조회"
						onclick="location.href='index.jsp?section=list.jsp'"></td>
				</tr>
			</table>
			<%
				}
			%>
		</form>
	</center>
</body>
</html>