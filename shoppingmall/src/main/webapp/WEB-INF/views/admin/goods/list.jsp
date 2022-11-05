<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>ADMIN</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.0.min.js"></script>
<script src="/resources/bootstrap/bootstrap.min.js"></script>

<link rel="stylesheet" href="/resources/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="/resources/bootstrap/bootstrap-grid.min.css">
<link rel="stylesheet" href="/resources/css/list.css">

<style>
#container_box table td { width:100px; }
</style>

</head>
<body>
	<div id="root">
		<header id="header">
			<div id="heade_box">
				<%@ include file="../include/header.jsp"%>
			</div>
		</header>

		<nav id="nav">
			<div id="nav_box">
				<%@ include file="../include/nav.jsp"%>
			</div>
		</nav>

		<section id="container">
			<aside>
				<%@ include file="../include/aside.jsp"%>
			</aside>
			<div id="container_box">
				<h2>상품목록</h2>
				
				<table>
					<thead>
						<tr>
							<th>번호</th>
							<th>이름</th>
							<th>카테고리</th>
							<th>가격</th>
							<th>수량</th>
							<th>등록날짜</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="list">
							<tr>
								<td>${list.gdsNum}</td>
								<td>
									<a href="/admin/goods/view?n=${list.gdsNum}">${list.gdsName}</a>
								</td>
								<td>${list.cateCode}</td>
								<td>
									<fmt:formatNumber value="${list.gdsPrice}" pattern="###,###,###"/></td>
								<td>${list.gdsStock}</td>
								<td>
									<fmt:formatDate value="${list.gdsDate}" pattern="yyyy-MM-dd"/></td>
							</tr>
						</c:forEach>
					</tbody>				
				</table>
			</div>
		</section>

		<footer id="footer">
			<div id="footer_box">
				<%@ include file="../include/footer.jsp"%>
			</div>
		</footer>

	</div>
</body>
</html>
