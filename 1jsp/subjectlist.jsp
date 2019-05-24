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
		<h1>과목조회</h1>
		<table border='1' style="text-align: center">
			<tr>
				<th>과목번호</th>
				<th>과목명</th>
				<th>지도교사</th>
				<th>소속학과</th>
			</tr>
			<%
      String subno, subname, subteacher, dept;
      
      subno = request.getParameter("subno");
      subname = request.getParameter("subname");
      subteacher = request.getParameter("subteacher");
      dept = request.getParameter("dept");
     
      Class.forName("com.mysql.jdbc.Driver");
	  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbs", "root", "apmsetup");
	  String sql = "select subno, subname, subteacher, dept from subject_tbl";
	  Statement st = con.createStatement();
	  ResultSet rs = st.executeQuery(sql);
	  
	  while(rs.next()){
		  subno = rs.getString(1);
		  subname = rs.getString(2);
		  subteacher = rs.getString(3);
		  dept = rs.getString(4);
   %>
			<tr>
				<td><%=subno %></td>
				<td><%=subname %></td>
				<td><%=subteacher %></td>
				<td><%=dept %></td>
			</tr>
			<%
	  }
   %>
		</table>
	</center>
</body>
</html>