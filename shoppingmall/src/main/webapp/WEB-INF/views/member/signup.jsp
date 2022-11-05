<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>

<link rel="stylesheet"href="/resources/css/signup.css">

<body>
	<div class="main">
		<h1 class="logo">회원가입</h1>
		<form role="form" method="post" autocomplete="off">
			<div id="container">
				아이디<input type="email" class="account" id="userId" name="userId" placeholder="example@email.com" required="required" /> 
				패스워드<input type="password" class="account" id="userPass" name="userPass" required="required" />
				닉네임 <input type="text" class="account" id="userName" name="userName" placeholder="닉네임을 입력해주세요" required="required" /> 
				연락처 <input type="text" class="account" id="userPhon" name="userPhon" placeholder="연락처를 입력해주세요" required="required" />
				<button type="submit" id="signup_btn" name="signup_btn">회원가입</button>	
			</div>
		</form>
	</div>
</body>
</html>
