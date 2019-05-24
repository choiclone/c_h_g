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
<h1>성적 조회</h1>
	<table border='1' style="text-align: center">
		<tr>
			<td>학생번호</td>
			<td>이름</td>
			<td>국어</td>
			<td>영어</td>
			<td>수학</td>
			<td>총점</td>
			<td>평균</td>
			<td>등급</td>
			<td>당담 선생님</td>
		</tr>
		<%
			String stuno, stuname, kor, eng, math, total, avg, grand, subteacher;
			int sumK=0, sumE=0, sumM=0, sumT=0, sumA=0, count = 0;

			stuno = request.getParameter("stuno");
			stuname = request.getParameter("stuname");
			kor = request.getParameter("kor");
			eng = request.getParameter("eng");
			math = request.getParameter("math");
			total = request.getParameter("total");
			avg = request.getParameter("avg");
			grand = request.getParameter("grand");
			subteacher = request.getParameter("subteacher");

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbs", "root", "apmsetup");
			String sql = "select st.stuno, st.stuname, gt.kor,gt.eng,gt.math, gt.kor+gt.eng+gt.math as total, round((gt.kor+gt.eng+gt.math)/3,0) as avg, CASE when (gt.kor+gt.eng+gt.math)/3>=90 then 'A' when (gt.kor+gt.eng+gt.math)/3>=80 then 'B' when (gt.kor+gt.eng+gt.math)/3>=70 then 'C' ELSE 'D' END as grand,sb.subteacher as rank from student_tbl as st inner join subject_tbl as sb on st.dept=sb.dept inner join grade_tbl as gt on st.stuno = gt.stuno  order by total desc;";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				stuno = rs.getString(1);
				stuname = rs.getString(2);
				kor = rs.getString(3);
				eng = rs.getString(4);
				math = rs.getString(5);
				total = rs.getString(6);
				avg = rs.getString(7);
				grand = rs.getString(8);
				subteacher = rs.getString(9);

				sumK += rs.getInt(3);
				sumE += rs.getInt(4);
				sumM += rs.getInt(5);
				sumT += rs.getInt(6);
				sumA += rs.getInt(7);
		%>
		<tr>
			<td><%=stuno%></td>
			<td><%=stuname%></td>
			<td><%=kor%></td>
			<td><%=eng%></td>
			<td><%=math%></td>
			<td><%=total%></td>
			<td><%=avg%></td>
			<td><%=grand%></td>
			<td><%=subteacher%></td>
		</tr>
		<%
			count++;
			}
		%>
		<tr>
			<td colspan="2">총점</td>
			<td><%=sumK %></td>
			<td><%=sumE %></td>
			<td><%=sumM %></td>
			<td><%=sumT %></td>
			<td><%=sumA %></td>
		</tr>
		<tr>
			<td colspan="2">평균</td>
			<td><%=sumK/count %></td>
			<td><%=sumE/count %></td>
			<td><%=sumM/count %></td>
			<td><%=sumT/count %></td>
			<td><%=sumA/count %></td>
		</tr>
	</table>
	</center>
</body>
</html>