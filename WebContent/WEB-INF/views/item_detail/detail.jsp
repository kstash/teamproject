<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div id="wrapper">
	<!-- 상세 설명 페이지 전체 -->
	<div id="detail_wrapper">
		<!-- 최상단 자세한 상품 설명 및 구매 버튼 -->
		<div id="detail_info">
			<!-- 최상단 상품 사진 -->
			<div id="info_photo">
				<img
					src="<%=application.getContextPath()%>/resources/img/product/outer/slides/01.jpg" />
			</div>
			<!-- 최상단 상품 설명 및 버튼 -->
			<div id="info_text">
				<Strong id="item_title">${product.productName}</strong>
				<p id="item_text">${product.productDesc}</p>
				<!-- 상품 옵션 선택 테이블 -->
				<table id="item_etc">
					<tr>
						<th>price</th>
						<td><fmt:formatNumber value="${product.productPrice}"
								pattern="#,###" />원</td>
					</tr>
					<tr>
						<th>point</th>
						<td><fmt:formatNumber
								value="${product.productPrice/100-((product.productPrice/100)%100)}"
								pattern="#,###" />원(1%)</td>
					</tr>
					<tr>
						<th>color</th>
						<td><c:forEach var="stock" items="${stocklist}">
								<span
									style="display:inline-block; height:20px; width:20px; border:1px solid black; background-color: ${stock.stockColor};"></span>
							</c:forEach></td>
					</tr>
					<tr>
						<th>fabric</th>
						<td>${product.productFabric}</td>
					</tr>
				</table>


				<hr>
				<form name="ordering" id="ordering">
					<input  type="hidden" name="productCode" value="${product.productCode}">
					<!-- 컬러 -->
					<div class="form-group d-inline"
						style="float: right; padding-top: 0px; font-size: 1.2rem;">
						<label for="orderColor">color :</label> <select
							class="form-select p-1" id="orderColor" name="orderColor"
							onchange="categoryChange(this.value)" style="width: 200px">
							<option selected>색상선택</option>
							<c:forEach var="stock" items="${stocklist}">
								<option value="${stock.stockColor}"
									style="background-color:${stock.stockColor};">${stock.stockName}</option>
							</c:forEach>
						</select>
					</div>
					<br style="clear: both;" />
					<!-- 사이즈 -->
					<script>
						function categoryChange(value) {
							console.log("실행인가");
							$.ajax({
								url : "sizecategory",
								method : "get",
								data : {
									stockcolor : value,
									productcode : "${product.productCode}"
								},
								success : function(data) {
									console.log("실행이다");
									$("#selectedsize").html(data);
								}
							})
						}
					</script>
					<div class="form-group d-inline" style="float: right; padding-top: 0px; font-size: 1.2rem;" id="selectedsize"></div>
					<br style="clear: both;" />
					<!-- 상품개수 -->
					<div class="form-group" style="float:right; padding-top:0px; font-size:1.2rem;">
						<label for="orderCount">구매 개수 :</label> 
						<input class="d-inline p-1" style="text-align: center; width: 200px;" id="orderCount" name="orderCount" type="number">
					</div>
					<div id="detail_info_btn">
						<button type="submit" formmethod="post" formaction="<%=application.getContextPath()%>/order/cart">장바구니</button>
						<button type="button" >관심상품</button>
						<button type="submit" formmethod="post" formaction="<%=application.getContextPath()%>/order/">구매하기</button>
					</div>
				</form>
			</div>
		</div>
		<hr>
		<div id="cotent_btn">
			<!-- 상품 상세 설명 -->
			<div id="detail_content">
				<p>상품상세설명이다.</p>
				<img src="<%=application.getContextPath()%>/resources/img/product/outer/products/01.jpg"><br />
				<img src="<%=application.getContextPath()%>/resources/img/product/outer/products/02.jpg"><br />
				<button id="policy">이용약관</button>
			</div>
			<!-- 하단 안내 사항 -->
			<div id="detail_info_bottom">
				<div id="detail_info_btn">
					<button id="shipping_btn">배송 안내</button>
					<button id="change_btn">교환 안내</button>
					<button id="refund_btn">환불 안내</button>
					<button id="quality_btn">품질 보증</button>
				</div>
				<div>
					<div id="shipping_text">
						<p>배송안내다</p>
					</div>
					<div id="change_text">
						<p>교환안내다</p>
					</div>
					<div id="refund_text">
						<p>환불안내다</p>
					</div>
					<div id="quality_text">
						<p>품질보증안내다</p>
					</div>
				</div>

			</div>
		</div>
	</div>
</div>
