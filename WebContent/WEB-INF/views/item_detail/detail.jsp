<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div id="wrapper">
	<!-- 상세 설명 페이지 전체 -->
	<div id="detail_wrapper">
		<!-- 최상단 자세한 상품 설명 및 구매 버튼 -->
		<div id="detail_info">
			<!-- 최상단 상품 사진 -->
			<div id="info_photo">
				<img
					src="<%=application.getContextPath()%>/resources/img/item_detail/img/img.jpg" />
			</div>
			<!-- 최상단 상품 설명 및 버튼 -->
			<div id="info_text">
				<Strong id="item_title">도티드배색카우 하프퍼자켓</strong>
				<p id="item_text">한 올 한 올 퍼의 질감이 살아 있는 하프 자켓입니다. 질감 표현부터 도톰한
					두께감까지, 시즌성이 짙은 제품이에요. 개성적인 카우 배색 패턴이 더해져 더욱 강렬한 인상을 그리고, 힙까지 슬쩍 덮어
					내려오는 기장이라 커버감 면에서도 만족스럽습니다. 난다메이드의 하이 퀄리티로 소개드려요!</p>
				<!-- 상품 옵션 선택 테이블 -->
				<table id="item_etc">
					<tr>
						<th>price</th>
						<td>179,000</td>
					</tr>
					<tr>
						<th>point</th>
						<td>1,700원(1%)</td>
					</tr>
					<tr>
						<th>color</th>
						<td>
							<ul>
								<li><button>Yellow</button></li>
								<li><button>Gray</button></li>
							</ul>
						</td>
					</tr>
					<tr>
						<th>size</th>
						<td>
							<ul>
								<li><button>S</button></li>
								<li><button>M</button></li>
								<li><button>L</button></li>
							</ul>
						</td>
					</tr>
				</table>
				<!-- 상품 인포 버튼 -->
				<div id="iteminfo_btn">
					<ul>
						<li>
							<button id='product'>Product Info</button>
							<p id='product_text'>
								Color / 베이지<br> Size / FREE<br> Fabric /
								아크릴85%+폴리에스테르15%,(안감)폴리에스테르100%
							</p>
						</li>
						<li>
							<button id='size'>Size Info</button>
							<p id='size_text' style="display: none;">
								어깨넓이 46cm / 네크라인넓이 14cm / 네크라인깊이 18cm / 팔길이 61.5cm<br> 소매
								17cm / 암홀 26cm / 가슴둘레 112cm / 전체길이 76cm<br> <br>
								상세사이즈의 치수는 측정방법과 위치에 따라 오차가 발생될 수 있습니다.
							</p>
						</li>
					</ul>
				</div>
				<hr>
				<!-- 합계 -->
				<div id="item_result">
					<strong>Total</strong> <span>(quantity)</span> <span
						id="totalprice">179,000</span> <span>원</span> <span
						id="totalquantity">1</span> <span>(개)</span>
				</div>
				<!-- 장바구니, 관심상품, 구매하기 -->
				<div id="detail_info_btn">
					<button type="button" id="cart_btn"
						onclick="location.href='<%=application.getContextPath()%>/'">장바구니</button>
					<button type="button" id="wish_btn"
						onclick="location.href='<%=application.getContextPath()%>/'">관심상품</button>
					<button type="button" id="buy_btn"
						onclick="location.href='<%=application.getContextPath()%>/'">구매하기</button>
				</div>
			</div>
		</div>
		<hr>
		<div id="cotent_btn">
			<!-- 상품 상세 설명 -->
			<div id="detail_content">
				<p>상품상세설명이다.</p>
				<img
					src="<%=application.getContextPath()%>/resources/img/item_detail/img/img.jpg"><br>
				<img
					src="<%=application.getContextPath()%>/resources/img/item_detail/img/img.jpg"><br>
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
