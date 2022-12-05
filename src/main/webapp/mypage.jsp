<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<nav
		class="navbar navbar-expand-sm bg-dark navbar-dark justify-content-center">
		<a class="navbar-brand" href="#"><img
			src="resources/img/fineapple.svg" width="100" height="100">FineApple</a>

		<!-- Links -->
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="#">아이폰</a></li>
			<li class="nav-item"><a class="nav-link" href="#">맥</a></li>
			<li class="nav-item"><a class="nav-link" href="#">아이패드</a></li>
			<li class="nav-item"><a class="nav-link" href="#">애플워치</a></li>
			<li class="nav-item"><a class="nav-link" href="#">에어팟</a></li>

			<!-- Dropdown -->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbardrop"
				data-toggle="dropdown"> 마이페이지 </a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="#">회원 정보 수정</a> <a
						class="dropdown-item" href="#">내 상품 조회</a> <a
						class="dropdown-item" href="#">찜 상품 조회</a>
				</div></li>
		</ul>

		<form class="form-inline" action="/action_page.php">
			<input class="form-control mr-sm-2" type="text"
				placeholder="상품을 입력하세요.">
			<button class="btn btn-success" type="submit">검색</button>
		</form>
	</nav>
	<div class="container">
		<h1>마이페이지 화면</h1>
		<a href="member_one">
			<button>회원 정보 조회</button>
		</a>
		<a href="order_all">
			<button>내 상품 조회</button>
		</a> 
		<a href="like_all">
			<button>찜 상품 조회</button>
		</a>
	</div>
</body>
</html>