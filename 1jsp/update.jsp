
<%@ page import = "java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<%
		    request.setCharacterEncoding("utf-8");
		    response.setCharacterEncoding("UTF-8");
		    
			String stuno, stuname, dept, address, gender, birdate;
			String fn_stuno = request.getParameter("stuno");
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbs", "root", "apmsetup");
			String sql = "select * from student_tbl where stuno=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, fn_stuno);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				stuno = rs.getString(1);
				stuname = rs.getString(2);
				dept = rs.getString(3);
				address = rs.getString(4);
				gender = rs.getString(5);
				birdate = rs.getString(6);
		%>
		<form action="updateAction.jsp" method="post">
			<table border='1'>
				<tr>
					<td>학번</td>
					<td><input type="text" name="stuno" value="<%=stuno%>"
						readonly="readonly"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="stuname" value="<%=stuname%>"></td>
				</tr>
				<tr>
					<td>학과</td>
					<td><input type="text" name="dept" value="<%=dept%>" size="20"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="address" value="<%=address%>"
						size="40"></td>
				</tr>
				<tr>
					<td>성별</td>
					<td><input type="text" name="gender" value="<%=gender%>"></td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td><input type="text" name="birdate" value="<%=birdate%>"></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;"><input
						type="submit" value="수정"> <input type="button" value="삭제"
						onclick="location.href='index.jsp?section=delete.jsp&stuno=<%=stuno%>'">
						<input type="button" value="목록"
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