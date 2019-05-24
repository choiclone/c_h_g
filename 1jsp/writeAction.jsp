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
<%
  request.setCharacterEncoding("utf-8");
  response.setCharacterEncoding("utf-8");
  
  String stuno, stuname, dept, address, gender,birdate;
  
  stuno = request.getParameter("stuno");
  stuname = request.getParameter("stuname");
  dept = request.getParameter("dept");
  address = request.getParameter("address");
  gender = request.getParameter("gender");
  birdate = request.getParameter("birdate");
  
  Class.forName("com.mysql.jdbc.Driver");
  Connection con =null;
  PreparedStatement pt = null; 

  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbs","root","apmsetup");
  String sql = "insert into student_tbl (stuno,stuname,dept, address, gender, birdate) values(?,?,?,?,?,?)";
  pt = con.prepareStatement(sql);
   
  pt.setString(1, stuno);
  pt.setString(2, stuname);
  pt.setString(3, dept);
  pt.setString(4, address);
  pt.setString(5, gender);
  pt.setString(6, birdate);
  
  pt.executeUpdate();
  
  response.sendRedirect("index.jsp?section=list.jsp");
%>
</body>
</html>