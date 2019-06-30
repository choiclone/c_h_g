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
	    request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
		String id = (String) session.getAttribute("id");
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_person?serverTimezone=UTC",
				"root", "1234");
		String sql = "insert into tb_join(`user_id`, `password`, `name`, `gender`,`email`) values(?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);

	%>
</body>
</html>