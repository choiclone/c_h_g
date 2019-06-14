<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
	xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
<head>
<meta charset="utf-8" />
<title>게시판예제-페이징</title>
<script th:inline="javascript">
	$(function() {

		var result = /*[[${msg}]]*/'default';

		if (result == 'success') {
			alert("처리가 완료되었습니다. result:" + result);
		}

	});
</script>
<link rel="stylesheet" type="text/css" href="/resources/css/style.css" />
<script type="text/javascript" src="/resources/js/packed.js"></script>
</head>
<body>
	<%@ include file="./m/header.jsp"%>
	<div id="wrapper">
		<div>
			<div class="sliderbutton">
				<img src="/resources/images/left.gif" width="32" height="38"
					alt="Previous" onclick="slideshow.move(-1)" />
			</div>
			<div id="slider">
				<ul>
					<li><img src="/resources/images/slide_img_1.png" width="500"
						height="300" alt="human?" /></li>
					<li><img src="/resources/images/slide_img_2.png" width="500"
						height="300" alt="people?" /></li>
					<li><img src="/resources/images/slide_img_3.png" width="500"
						height="300" alt="B" /></li>
					<li><img src="/resources/images/slide_img_4.png" width="500"
						height="300" alt="B" /></li>
				</ul>
			</div>
			<div class="sliderbutton">
				<img src="/resources/images/right.gif" width="32" height="38"
					alt="Next" onclick="slideshow.move(1)" />
			</div>
		</div>
		<ul id="pagination" class="pagination">
			<li onclick="slideshow.pos(0)">1</li>
			<li onclick="slideshow.pos(1)">2</li>
			<li onclick="slideshow.pos(2)">3</li>
			<li onclick="slideshow.pos(3)">4</li>
		</ul>
	</div>
	<br>
	<br>
	<script type="text/javascript">
		var slideshow = new TINY.slider.slide('slideshow', {
			id : 'slider',
			auto : 3,
			resume : true,
			vertical : false,
			navid : 'pagination',
			activeclass : 'current',
			position : 0
		});
	</script>

	<!-- Content Wrapper. Contains page content -->
	<div>
		<!-- /.box-header -->
		<div>
			<table border='1'>
				<tr>
					<th>No</th>
					<th>name</th>
					<th>screen_time</th>
					<th>screen_room</th>
				</tr>

				<c:forEach var="BV" items="${list}" varStatus="status">
					<tr>
						<td>${BV.no }</td>
						<td>${BV.name }</td>
						<td><fmt:formatDate value="${BV.screen_time }"
								pattern="HH:mm" /></td>
						<td>${BV.screen_room }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>