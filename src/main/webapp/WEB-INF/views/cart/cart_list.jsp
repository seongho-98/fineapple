<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
	$(function() {
		getTotalPrice();
		
		// 변경 감지
		$('input[name=cartCheckBox]').change(function() {
			getTotalPrice();
		});
		
		// 체크박스 전체 선택/해제
		$('#checkAll').click(function() {
			if ($('#checkAll').prop("checked")) {
				$('input[name=cartCheckBox]').prop("checked", true);
			} else {
				$('input[name=cartCheckBox]').prop("checked", false);
			}
			getTotalPrice();
		});
	});
	
	// 총 주문 금액 계산
	function getTotalPrice() {
		let totalPrice = 0;
		$('input[name=cartCheckBox]:checked').each(function() {
			let cartProductId = $(this).val();
			let price = parseInt($('#' + cartProductId).text());
			totalPrice += price;
		});
		console.log(totalPrice);
		$('#totalPrice').html(totalPrice + '원');
	}
	
	// 카트 주문
	function orders() {
		let url = "/cart/order";
		
		let dataList = new Array();
		let paramData = new Object();
		
		$('input[name=cartCheckBox]:checked').each(function() {
			let cartProductId = $(this).val();
			let data = new Object();
			data['cartProductId'] = cartProductId;
		});
	}
</script>
</head>
<body>
<h3>장바구니</h3>
<hr />
<table class="table table-hover">
	<thead>
		<tr>
			<td><input type="checkbox" id="checkAll" />전체선택</td>
			<td>상품정보</td>
			<td>상품금액</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="vo" items="${cartProductDetailList}">
			<tr>
				<td><input type="checkbox" name="cartCheckBox" value="${vo.cartProductId}" /></td>
				<td><a href="cart/${vo.cartProductId}">${vo.cartProductName}</a></td>
				<td id="${vo.cartProductId}">${vo.cartProductPrice}</td>
			</tr>
		</c:forEach>
		<tr>
			<td>총 주문 금액</td>
			<td id="totalPrice"></td>
			<td><button>주문하기</button></td>
		</tr>
	</tbody>
</table>
</body>
</html>