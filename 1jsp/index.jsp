<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<header>
		<jsp:include page="header.jsp" />
	</header>
	<nav>
		<jsp:include page="nav.jsp" />
	</nav>

	<section>
		<%
			String prm = request.getParameter("section");
			if (prm == null || prm.equals(" ")) prm = "section.jsp";
		%>
		<jsp:include page="<%=prm%>" />
	</section>

	<footer>
		<jsp:include page="footer.jsp" />
	</footer>
</body>
</html>