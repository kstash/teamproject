<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- 이미지는 해당 상위 카테고리의 하위카테고리 아이템중 5개의 메인 이미지 골라오기 -->
<div class="carousel-inner">
	<ol class="carousel-indicators">
		<c:forEach var="counter" begin="1" end="${slidecount}">
			<c:if test="${counter == 1}">
				<li data-target="#carouselExampleCaptions" data-slide-to="${counter}" class="active"></li>
			</c:if>
			<c:if test="${counter != 1}">
				<li data-target="#carouselExampleCaptions" data-slide-to="${counter}"></li>
			</c:if>
		</c:forEach>
	</ol>
	<c:forEach var="slideinfo" items="${slideinfoList}">
		<div class="productSlide row carousel-item active" data-interval="4000" style="position:inherit">
			<div class="productSlide_detail col-md-8 col " id="productSlide_detail_img">
				<a href="#">
					<img src="<%=application.getContextPath()%>/resources/img/product/${slideinfo.prodimgdb.prodImagepath}${slideinfo.prodimgdb.productCode}/${slideinfo.prodimgdb.prodImageoname}" class="d-block w-100">
				</a>
			</div>
			<div class="productSlide_detail col-md-4 col" id="productSlide_detail_info" style="position:relative;">
				<div class="productSlide_colors">
					<c:forEach var="stock" items="${slideinfo.stockdb}">
						<div style="background-color:${stock.stockColor}" class="productColor"></div>
					</c:forEach>
				</div><br><hr>
				<h4 class="productSlide_name">${slideinfo.productdb.productName}</h4>
				<h4 class="producSlide_price">
					<fmt:formatNumber value="${slideinfo.productdb.productPrice}" pattern="#,###" />원
				</h4>
				<p class="productSlide_desc">${slideinfo.productdb.productDesc}</p>
			</div>
			<button type="button" autofocus="autofocus" class="btn" id="productSlideButton"> 구매하기 </button>
		</div>
	</c:forEach>
</div>
<a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
	<span class="carousel-control-prev-icon" aria-hidden="true"></span>
	<span class="sr-only">Previous</span>
</a>
<a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
	<span class="carousel-control-next-icon" aria-hidden="true"></span>
	<span class="sr-only">Next</span>
</a>
<script type="text/javascript" src="<%=application.getContextPath()%>/resources/js/slideshow/slideshow.js"></script>
