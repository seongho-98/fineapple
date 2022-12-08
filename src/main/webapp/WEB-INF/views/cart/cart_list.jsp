<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
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
		
		$('button').click(function() {
			orders();
		})
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
		let url = "cart/order";
		
		let dataList = new Array();
		let paramData = new Object();
		
		$('input[name=cartCheckBox]:checked').each(function() {
			let cartProductId = $(this).val();
			let data = new Object();
			data['cartProductId'] = cartProductId;
			dataList.push(data);
		});
		
		paramData['cartProductVOList'] = dataList;
		
		let param = JSON.stringify(paramData);
		
		$.ajax({
			url: url,
			type: "POST",
			contentType: "application/json",
			data: param,
			dataType: "json",
			success: function(result, status) {
				alert("주문이 완료되었습니다.");
			},
			error: function(error) {
				alert("주문이 실패되었습니다.");
			}
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