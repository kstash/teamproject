<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image/x-icon"
	href="<%=application.getContextPath()%>/resources/img/title/heart.svg">
<title>homepage</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/resources/css/imageCard/imageCard.css">
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/resources/css/base_element/breadcrumb.css">
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/resources/css/base_element/footermen.css">
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/resources/css/base_element/homepage.css">
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/resources/css/productSlideshow/slideshow.css">
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/resources/css/index/index.css">
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/resources/css/index/header.css">
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/resources/css/index/left_area.css">
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/resources/css/index/right_area.css">
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/resources/css/base_element/homepage.css">
<!-- 아이콘 사용 -->
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
</head>
<body>
	<div class="wrap_content">
		<!-- 좌측 메뉴 -->
		<jsp:include page="/WEB-INF/views/include/left_area.jsp" />

		<!-- 내용 -->
		<div id="header">
			<%-- 중앙 --%>
			<script type="text/javascript">
						$(function() {
							$.ajax({
								url : "<%=application.getContextPath()%>/header",
						method : "get",
						success : function(data) {
							$("#headerpart").html(data);
						}
					});
				});
			</script>
			<div id="headerpart"></div>

			<br /> <br /> <br /> <br />
			<!-- orderlist -->
			<table class="table">
				<thead class="table-dark">
					<tr>
						<th scope="col" class="text-white">ProductCode</th>
						<th scope="col" class="text-white">OrderColor</th>
						<th scope="col" class="text-white">OrderSize</th>
						<th scope="col" class="text-white">OrderCount</th>
						<th scope="col" class="text-white">OrderFreeshipping</th>
						<th scope="col" class="text-white">OrderStatus</th>
						<th scope="col" class="text-white">리뷰</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="order" items="${orderlist}">
						<tr>
							<td>${order.productCode}나중에그림넣기</td>
							<td><span
								style="display:inline-block; height:20px; width:50px; border:1px solid black; background-color: ${order.orderColor};"></span>
							</td>
							<td>${order.orderSize}</td>
							<td>${order.orderCount}</td>
							<td>${order.orderFreeshipping}</td>
							<td>${order.orderStatus}</td>
							<td id="${order.orderCode}"></td>
						</tr>
						<script>
								$(function() {
									$.ajax({
										url : "reviewcheck",
										method : "get",
										data : {
											ordercode : "${order.orderCode}",
											productcode : "${order.productCode}"
										},
										success : function(data) {
											$("#${order.orderCode}").html(data);
										}
									});
								});
						</script>
					</c:forEach>

				</tbody>
			</table>


			<jsp:include page="/WEB-INF/views/include/footer.jsp" />
		</div>
		<!-- 우측 메뉴 -->
		<jsp:include page="/WEB-INF/views/include/right_area.jsp" />
	</div>

</body>
</html>