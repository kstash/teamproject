<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>homepage</title>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<link rel="stylesheet" href="<%=application.getContextPath()%>/resources/css/imageCard/imageCard.css">
	<link rel="stylesheet" href="<%=application.getContextPath()%>/resources/css/base_element/breadcrumb.css">
	<link rel="stylesheet" href="<%=application.getContextPath()%>/resources/css/base_element/footermen.css">
	<link rel="stylesheet" href="<%=application.getContextPath()%>/resources/css/base_element/homepage.css">
	<link rel="stylesheet" href="<%=application.getContextPath()%>/resources/css/productSlideshow/slideshow.css">
	<link rel="stylesheet" href="<%=application.getContextPath()%>/resources/css/index/index.css">
	<link rel="stylesheet" href="<%=application.getContextPath()%>/resources/css/index/header.css">
	<link rel="stylesheet" href="<%=application.getContextPath()%>/resources/css/index/left_area.css">
	<link rel="stylesheet" href="<%=application.getContextPath()%>/resources/css/index/right_area.css">
	<link rel="stylesheet" href="<%=application.getContextPath()%>/resources/css/base_element/homepage.css">
	<!-- 아이콘 사용 -->
	<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
	<script type="text/javascript" src="<%=application.getContextPath()%>/resources/js/base_element/homepage.js"></script>
</head>
<body>
<div class="wrap">
	<div class="wrap_content">
			<!-- 좌측 메뉴 -->
		<jsp:include page="/WEB-INF/views/include/left_area.jsp" />

			<!-- 내용 -->
		<div class="wrapper">
			<div id="header">
					<%-- 중앙 --%>
				<jsp:include page="/WEB-INF/views/include/header.jsp" />

					<!-- 페이지 내용 -->
				<div id="content">
						<!-- 추천상품 top5 슬라이드 -->
					<jsp:include page="/WEB-INF/views/products/slideshow.jsp" />
						
					<!-- homepage item -->
					<div id="homeproductList"></div>
					
					
					<!-- 제품 리스트 스크립트 -->
					<script type="text/javascript">
						$(function() {
							$.ajax({
								url : "productll/productCardList",
								method : "get",
								success : function(data) {
									$("#productCardList").html(data);
								}
							});
						});
					</script>
					<div id="productCardList"></div>

					<jsp:include page="/WEB-INF/views/include/footer.jsp" />
				</div>
			</div>
		</div>

			<!-- 우측 메뉴 -->
		<jsp:include page="/WEB-INF/views/include/right_area.jsp" />
	</div>
</div>
</body>
</html>