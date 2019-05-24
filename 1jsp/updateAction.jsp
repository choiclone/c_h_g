<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
  request.setCharacterEncoding("UTF-8");
  response.setCharacterEncoding("UTF-8");
  
  String stuno, stuname, dept, address, gender, birdate;
  
  stuno = request.getParameter("stuno");
  stuname = request.getParameter("stuname");
  dept = request.getParameter("dept");
  address = request.getParameter("address");
  gender = request.getParameter("gender");
  birdate = request.getParameter("birdate");
  
  Class.forName("com.mysql.jdbc.Driver");
  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbs", "root", "apmsetup");
  String sql = "update student_tbl set stuname=?,dept=?, address=?,gender=?,birdate=? where stuno=?";
  PreparedStatement pse = conn.prepareStatement(sql);
  
  pse.setString(1, stuname);
  pse.setString(2, dept);
  pse.setString(3, address);
  pse.setString(4, gender);
  pse.setString(5, birdate);
  pse.setString(6, stuno);
  
  pse.executeUpdate();
  
  response.sendRedirect("index.jsp?section=list.jsp");
%>
</body>
</html>