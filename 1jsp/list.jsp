<%@ page import="java.sql.*"%>
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
<h1>학생목록조회/수정</h1>
	<table border='1' style="text-align: center;">
		<tr>
			<th>학생번호</th>
			<th>이름</th>
			<th>학과</th>
			<th>주소</th>
			<th>성별</th>
			<th>생년월일</th>
		</tr>
		<%
		    request.setCharacterEncoding("UTF-8");
		    response.setCharacterEncoding("UTF-8");
		    
			String stuno, stuname, dept, address, gender, birdate;
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbs?useUnicode=true&characterEncoding=utf8", "root", "apmsetup");
			String sql = "select stuno,stuname,dept,address,if(gender='m'||gender='M','남자',if(gender='f'||gender='F','여자','알 수 없음')) as gender, date_format(birdate, '%Y-%m-%d') as birdate from student_tbl";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				stuno = rs.getString(1);
				stuname = rs.getString(2);
				dept = rs.getString(3);
				address = rs.getString(4);
				gender = rs.getString(5);
				birdate = rs.getString(6);
		%>
            <tr>
              <td><a href="index.jsp?section=update.jsp&stuno=<%=stuno%>" style="color: red; font-weigh:bold; text-decoration: none;"><%=stuno %></a></td>
              <td><%=stuname%></td>
              <td><%=dept%></td>
              <td><%=address%></td>
              <td><%=gender%></td>
              <td><%=birdate%></td>
            </tr>
		<%
			}
		%>
	</table>
	</center>
</body>
</html>