<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 이미지는 해당 상위 카테고리의 하위카테고리 아이템중 5개의 메인 이미지 골라오기 -->
<c:forEach var="slideinfo" items="${slideinfoList}">
	<div class="productSlide fade">
		<div class="productSlide_detail" id="productSlide_detail_img">
			<a href="#">
				<img src="<%=application.getContextPath()%>/resources/img/product/${slideinfo.prodimgdb.prodImagepath}${slideinfo.prodimgdb.productCode}">
			</a>
		</div>
	
		<div class="productSlide_detail" id="productSlide_detail_info">
			<div class="productSlide_colors">
				<c:forEach var="stockColor" items="${slideinfo.stockdb}">
					<div style="${stockColor.stockColor}"></div>
				</c:forEach>
			</div>
			<br>
			<p class="productSlide_name">${slideinfo.productdb.productName}</p>
			<br>
			<p class="producSlide_price">${slideinfo.productdb.productPrice}</p>
			<br>
			<p class="productSlide_desc">${slideinfo.productdb.productDesc}</p>
			<button>구매하기</button>
		</div>
	</div>	
</c:forEach>

<script type="text/javascript"
	src="<%=application.getContextPath()%>/resources/js/slideshow/slideshow.js"></script>