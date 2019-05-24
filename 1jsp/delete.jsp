<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
   String dt_stuno;
   
   dt_stuno = request.getParameter("stuno");
   
   Class.forName("com.mysql.jdbc.Driver");
   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbs", "root", "apmsetup");
   String sql = "delete from student_tbl where stuno=?";
   PreparedStatement pse = conn.prepareStatement(sql);
   
   pse.setString(1,dt_stuno);
   
   pse.executeUpdate();
   
//    response.sendRedirect("index.jsp?section=list.jsp");
%>
<script>
location.href = "index.jsp?section=list.jsp"; 
</script>
</body>
</html>