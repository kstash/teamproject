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
		      <th>상품</th>
		      <th>사이즈</th>
		      <th>색상</th>
		      <th>수량</th>
		      <th>가격</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach  var="cartlist" items="${cartlist}">
		  		<tr>
		  			<td>${cartlist.productname}</td>
		  			<td>${cartlist.cartsize}</td>
		  			<td>${cartlist.cartcolor}</td>
		  			<td>${cartlist.cartcount}</td>
		  			<td>${cartlist.productprice}</td>
		  		</tr>
		  	</c:forEach>
		  </tbody>
	</table>
	
	<div id="btns">
			<button id="cartBuy" class="btn">구매하기</button>
			<a id="cartCancel"class="btn" href="index">취소</a>
	</div>
	</c:if>
</div>
