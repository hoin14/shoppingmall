<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>ADMIN</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.0.min.js"></script>
<script src="/resources/bootstrap/bootstrap.min.js"></script>

<link rel="stylesheet" href="/resources/bootstrap/bootstrap.min.css">
<link rel="stylesheet"href="/resources/bootstrap/bootstrap-grid.min.css">
<link rel="stylesheet"href="/resources/css/index.css">

</head>
<body>
	<div id="root">

		<header id="header">
			<div id="heade_box">
				<%@ include file="include/header.jsp"%>
			</div>
		</header>

		<nav id="nav">
			<div id="nav_box">
				<%@ include file="include/nav.jsp"%>
			</div>
		</nav>

		<section id="container">
			<aside>
				<%@ include file="include/aside.jsp"%>
			</aside>
			<div id="container_box">본문영역</div>
		</section>

		<footer id="footer">
			<div id="footer_box">
				<%@ include file="include/footer.jsp"%>
			</div>
		</footer>

	</div>
</body>
</html>
