<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>

<head>
<title>HOIN</title>

<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.2.0.min.js"></script>

<link rel="stylesheet" href="/resources/bootstrap/bootstrap.min.css">
<link rel="stylesheet"
	href="/resources/bootstrap/bootstrap-grid.min.css">
<script src="/resources/bootstrap/bootstrap.min.js"></script>

<style>
section#container::after {
	content: "";
	display: block;
	clear: both;
}

aside {
	float: left;
	width: 200px;
}

div#container_box {
	float: right;
	width: calc(100% - 200px - 20px);
}

aside h3 {
	text-align: center;
	font-size: 22px;
	margin-bottom: 20px;
}

aside ul li {
	text-align: center;
	margin-bottom: 10px;
}

aside ul li a {
	display: block;
	width: 100%;
	padding: 10px 0;
}

aside ul li a:hover {
	background: #eee;
	text-decoration: none;
}

body {
	margin: 0;
	padding: 0;
	font-family: '맑은 고딕', verdana;
}

a {
	color: #05f;
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}

h1, h2, h3, h4, h5, h6 {
	margin: 0;
	padding: 0;
}

ul, lo, li {
	margin: 0;
	padding: 0;
	list-style: none;
}

div#root {
	width: 900px;
	margin: 0 auto;
}

section#content {
	float: right;
	width: 700px;
}

aside#aside {
	float: left;
	width: 180px;
}

section#container::after {
	content: "";
	display: block;
	clear: both;
}

footer#footer {
	background: #eee;
	padding: 20px;
}

header {
	text-align: center;
	padding: 30px 0;
}

header h1 li {
	font-size: 50px;
	text-align: center;
	color: #000;
}

nav#nav div#nav_box {
	font-size: 14px;
	padding: 10px;
	text-align: right;
}

nav#nav div#nav_box li {
	display: inline-block;
	margin: 0 10px;
}

nav#nav div#nav_box li a {
	color: #333;
}

aside#aside h3 {
	font-size: 22px;
	margin-bottom: 20px;
	text-align: center;
}

aside#aside li {
	font-size: 16px;
	text-align: center;
}

aside#aside li a {
	color: #000;
	display: block;
	padding: 10px 0;
}

aside#aside li a:hover {
	text-decoration: none;
	background: #eee;
}

footer#footer {
	margin-top: 100px;
	border-radius: 50px 50px 0 0;
}

footer#footer div#footer_box {
	padding: 0 20px;
}

aside#aside li { position:relative; }
aside#aside li:hover { background:#eee; }   
aside#aside li > ul.low { display:none; position:absolute; top:0; left:180px;  }
aside#aside li:hover > ul.low { display:block; }
aside#aside li:hover > ul.low li a { background:#eee; border:1px solid #eee; }
aside#aside li:hover > ul.low li a:hover { background:#fff;}
aside#aside li > ul.low li { width:180px; }

section#content ul li { margin:10px 0; }
section#content ul li img { width:250px; height:250px; }
section#content ul li::after { content:""; display:block; clear:both; }
section#content div.thumb { float:left; width:250px; }
section#content div.gdsInfo { float:right; width:calc(100% - 270px); }
section#content div.gdsInfo { font-size:20px; line-height:2; }
section#content div.gdsInfo span { display:inline-block; width:100px; font-weight:bold; margin-right:10px; }
section#content div.gdsInfo .delete { text-align:right; }
section#content div.gdsInfo .delete button { font-size:22px; padding:5px 10px; border:1px solid #eee; background:#eee;}

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
					<section id="content">
 						<ul>
  							<c:forEach items="${cartList}" var="cartList">
  							<li>
   								<div class="thumb">
    								<img src="${cartList.gdsThumbImg}" />
   								</div>
   								<div class="gdsInfo">
    								<p>
										<span>상품명 </span>${cartList.gdsName}<br />
     									<span>개당 가격 </span><fmt:formatNumber pattern="###,###,###" value="${cartList.gdsPrice}" /><br />
     									<span>구입 수량 </span>${cartList.cartStock}<br />
     									<span>최종 가격 </span><fmt:formatNumber pattern="###,###,###" value="${cartList.gdsPrice * cartList.cartStock}" />
    								</p>
    								<div class="delete">
    									<button type="button" class="delete_btn">삭제</button>
    								</div>    
   								</div>
  							</li>
  							</c:forEach>
 						</ul>
					</section>
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
