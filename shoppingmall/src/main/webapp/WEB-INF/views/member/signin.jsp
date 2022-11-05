<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>

<link rel="stylesheet"href="/resources/css/signin.css">

<body>
	<div class="main">
		<h1 class="logo">HOIN</h1>
		<form role="form" method="post" autocomplete="off">
		<div class="container">
			<input type="email" class="account" id="userId" name="userId" required="required" />
			<input type="password"  class="account"  id="userPass" name="userPass" required="required" />
			<button type="submit" id="signin_btn" name="signin_btn">로그인</button>
		</div>
			<c:if test="${msg == false}">
				<p style="color: #f00;">로그인에 실패했습니다.</p>
			</c:if>

		</form>
	</div>
</body>
</html>
