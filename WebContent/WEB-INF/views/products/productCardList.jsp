<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
​
<div id="imageCardList" style="padding-top: 0px; width: 100%">
	<ul>
		<!-- 제품에 대한 모든 내용을 담고 있어야함 -->
		<c:forEach var="productinfo" items="${productinfoList}">
			<li class="m-0 p-3" style="width: 25%">
				<a href="<%=application.getContextPath()%>/item/?productcode=${productinfo.productdb.productCode}">
				<div id="imageCard" style="padding-top: 0px;">
					<img id="imageCard_img"
						src="<%=application.getContextPath()%>/resources/img/product/${productinfo.prodimgdb.prodImagepath}/${productinfo.prodimgdb.productCode}/${productinfo.prodimgdb.prodImageoname}"
						style="width: 100%">
					
					<div id="imageCard_color">
						<!-- stock 테이블 정보로 foreach 사용해서 inline style 개별 적용 -->
						<c:forEach var="stock" items="${productinfo.stockdb}">
							<div style="background-color: ${stock.stockColor}"></div>
						</c:forEach>
					</div>
					<br><br>
					<div id="imageCard_name">${productinfo.productdb.productName}</div>
					
					<div id="imageCard_price">${productinfo.productdb.productPrice}원</div>
				</div>
				</a>
			</li>
		</c:forEach>
	
	</ul>
</div>