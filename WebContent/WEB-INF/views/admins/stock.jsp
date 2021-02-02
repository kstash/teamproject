<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image/x-icon"
	href="<%=application.getContextPath()%>/resources/img/title/heart.svg">
<title>www.stylenanda.com</title>
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
			<br />
			<br />
			<br />
			<br />

			<!-- 페이지 내용 -->
			<div id="content">
				<h1>재고관리 페이지 제작 준비</h1>
				<hr />
				<h3 class="d-inline-block">${productCode}</h3>
				<button class="btn btn-success m-1" style="float: right;" onclick="addstock(${productCode})">추가</button>
				<script type="text/javascript">
				function addstock(pdc) {
					$.ajax({
						url : "addstock",
						method : "post",
						data:{productCode:pdc},
						success : function(data) {
							location.href=data;
						}
					});
				}
				</script>
				<table class="table">
					<thead class="table-dark">
						<tr>
							<th class="text-white" scope="col">color</th>
							<th class="text-white" scope="col">name</th>
							<th class="text-white" scope="col">sizeS</th>
							<th class="text-white" scope="col">sizeM</th>
							<th class="text-white" scope="col">sizeL</th>
							<th class="text-white" scope="col">sizeXL</th>
							<th class="text-white" scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="stock" items="${stocklist}">
							<form>
								<input type="hidden" name="productCode" value="${stock.productCode}">
								<input type="hidden" name="stockBeforeColor" value="${stock.stockColor}">
								<tr>
									<td class="form-group">
										<input type="text" style="background-color: ${stock.stockColor};" class="form-control" id="stockColor" name="stockColor" value="${stock.stockColor}"></td>
									<td class="form-group">
										<input type="text" class="form-control" id="stockName" name="stockName" value="${stock.stockName}"></td>
									<td class="form-group"> 
										<input type="number" class="form-control" id="stockSizeS" name="stockSizeS" value="${stock.stockSizeS}"></td>
									<td class="form-group">
										<input type="number" class="form-control" id="stockSizeM" name="stockSizeM" value="${stock.stockSizeM}"></td>
									<td class="form-group">
										<input type="number" class="form-control" id="stockSizeL" name="stockSizeL" value="${stock.stockSizeL}"></td>
									<td class="form-group">
										<input type="number" class="form-control" id="stockSizeXL" name="stockSizeXL" value="${stock.stockSizeXL}"></td>
									<td>
										<button type="submit" formaction="stockupdate" formmethod="post" class="btn btn-primary btn-sm">저장</button>
										<button type="submit" formaction="stockdelete" formmethod="post" class="btn btn-danger btn-sm">삭제</button>
									</td>
								</tr>
							</form>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<jsp:include page="/WEB-INF/views/include/footer.jsp" />
		</div>

		<!-- 우측 메뉴 -->
		<jsp:include page="/WEB-INF/views/include/right_area.jsp" />
	</div>

</body>
</html>