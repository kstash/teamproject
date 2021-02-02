<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="wrapper">
	<span id="cartTitle"> C A R T </span>
	<c:if test="${sessionUserid == null}">
		<div id="empty"></div>
		<span id="emptyCart">장바구니가 비었습니다.</span>
		<a id="cartLogin"class="btn" href="login">로그인하기</a>
	</c:if>
	<c:if test="${sessionUserid != null}">
	<table id="cartTable" class="table table-hover">
		<thead>
		    <tr>
		      <th>코드</th>
		      <th>상품</th>
		      <th>사이즈</th>
		      <th>색상</th>
		      <th>수량</th>
		      <th>가격</th>
		      <th></th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach  var="cartlist" items="${cartlist}">
		  		<c:if test="${sessionUserid == cartlist.userid}">
			  		<tr id="cartRow">
			  			<td>${cartlist.cartcode}</td>
			  			<td id="product">${cartlist.productname}</td>
			  			<td>${cartlist.cartsize}</td>
			  			<td>${cartlist.cartcolor}</td>
			  			<td id="count">${cartlist.cartcount}</td>
			  			<td id="price">${cartlist.productprice}</td>
			  			<td id="deleteRow">
			  				<a id="deleteBtn" class="btn btn-sm" href="deleteCart?cartcode=${cartlist.cartcode}">삭제</a>
			  			</td>

			  		</tr>
		  		</c:if>
		  	</c:forEach>
		  			<tr id="totalRow">
		  				<td colspan="2"></td>
		  				<td>배송비</td>
		  				<td id="shiping" colspan="2"></td>
		  				<td>상품금액</td>
		  				<td id="productTotal"></td>
		  			</tr>
		  			<tr>
		  				<td colspan="6">결제 금액</td>
		  				<td id="totalPrice"></td>
		  			</tr>
		  </tbody>
	</table>
	
	<!-- cart 테이블 정보 order 테이블로 넘기기 -->
	<div id="btns">
			<button id="cartBuy" class="btn" href="">구매하기</button>
			<a id="cartCancel"class="btn" href="index">취소</a>
	</div>
	</c:if>
</div>
<script>
console.log("스크립트 실행");

const $totalPrice = $('#totalPrice');
const $price = $('#price');
const $count = $('#count');

$totalPrice.html("ㅇㅅㅇ");

//상품 클릭 시 상세정보 보여주기
$('#product').on('click', function () {
	//상세페이지 경로
	
});

</script>
