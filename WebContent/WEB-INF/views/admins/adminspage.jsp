<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>

<link rel="stylesheet"
	href="<%=application.getContextPath()%>/resources/css/imageCard/imageCard.css">
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/resources/css/base_element/breadcrumb.css">
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/resources/css/base_element/footermen.css">
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
<!--  -->

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<!-- 아이콘 사용 -->
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>


</head>

<body>

	<div id="header">
		<%-- 중앙 --%>
		<jsp:include page="/WEB-INF/views/include/header.jsp" />
	</div>

	<div class="wrap_content">
		<!-- 좌측 메뉴 -->
		<jsp:include page="/WEB-INF/views/include/left_area.jsp" />

		<!-- 페이지 내용 -->
		<div id="content">
			<!-- DB연동 필수 -->
			<div class="container">
				<h3 class="mb-3">카테고리 구성 (편집)</h3>
				<table class="table table-hover table-responsive">
					<thead>
					</thead>
					<tbody>
						<c:forEach var="upcategory" items="${upcategories}">
							<tr>
								<th>${upcategory.upcategoryKr}</th>
								<c:forEach var="lowcategory" items="${lowcategories}">
									<c:if test="${lowcategory.upcategoryEng == upcategory.upcategoryEng}">
										<td>
											<a type="button" href="choselowcategory" class="btn btn-primary btn-sm link" data-toggle="modal" data-target="#categoryInfoModal">
												${lowcategory.lowcategoryKr}
											</a>
										</td>
									</c:if>
								</c:forEach>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!-- Modal -->
			<!-- 클릭한 카테고리에 따라서 다르게 정보 넣어서 불러오기 -->
			<!-- DB연동 필수 -->
			<jsp:include page="/WEB-INF/views/admins/categoryInfoModal.jsp" />


			<!-- 제품 업로드 -->
			<!-- DB연동 필수 -->
			<div class="container">
				<div class="flex col">
					<h3>제품 등록</h3>
					<hr>
					<form class="row" method="post" action="postProduct" id="postingNewProductForm" name="postingNewProductForm">
						<div>
							<div class="form-group mr-3 col">
								<label for="FormControlSelectUpCategory">상위 카테고리</label>
								<select class="form-control" id="FormControlSelectUpCategory" onchange=this.value>
									<c:forEach var="upcategorySelect" items="${upcategories}">
										<option id="upcategorySelectOption" value="${upcategorySelect.upcategoryEng}">
											${upcategorySelect.upcategoryKr}
										</option>
									</c:forEach>
								</select>
							</div>
							
							<div class="form-group mr-3 col">
								<label for="FormControlSelectLowCategory">하위 카테고리</label>
								<select class="form-control" id="FormControlSelectLowCategory" onchange=this.value>
									<c:forEach var="lowcategorySelect" items="${lowcategories}">
										<option id="lowcategorySelectOption" value="${lowcategorySelect.lowcategoryEng}">
											${lowcategorySelect.lowcategoryKr}
										</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="row">
							<div class="form-group mr-3 col" style="width: 300px;">
								<label for="productName">제품명</label>
								<div class="input-group" id="productName">
									<input type="text" id="productNameInput"
										name="productNameInput" class="form-control">
								</div>
							</div>
							<div class="form-group mr-3 col" style="width: 300px;">
								<label for="productPrice">제품가</label>
								<div class="input-group" id="productPrice">
									<input type="number" id="productPriceInput" name="productPriceInput" class="form-control text-right">
									<div class="input-group-append" style="padding: 0;">
										<span class="input-group-text">원</span>
									</div>
								</div>
							</div>
						</div>
						<div>
							<div class="form-group">
								<label for="productDescInput">제품 상세 설명</label>
								<textarea class="form-control" id="productDescInput" name="productDescInput" rows="6" cols="200"></textarea>
							</div>
						</div>
					</form>
				</div>
				<br> <br>
				<div class="mr-3">
					<form class="row" method="post" action="postProdimg" id="postingNewProdimgForm" name="postingNewProdimgForm" enctype="multipart-form-data">
						<label for="productListImageForm">리스트 이미지</label>
						<input type="file" name="productListImageFile" />
						
						<label for="productMainImageForm">메인 이미지</label>
						<input type="file" name="productMainImageFile" />
						
						<label for="productDetailImagesForm">상세 페이지 내부 이미지들</label>
						<input multiple="multiple" type="file" name="detailImages" />
					</form>
				</div>
				<a class="btn btn-primary btn-sm" onClick="javascript:submitAll()">등록</a>
				<script type="text/javascript">
					function submitAll() {
						document.postingNewProductForm.submit();//postProduct
						document.postingNewProdimgForm.submit();//postProdImg
					}
				</script>
			</div>

			<jsp:include page="/WEB-INF/views/include/footer.jsp" />
		</div>

		<!-- 우측 메뉴 -->
		<jsp:include page="/WEB-INF/views/include/right_area.jsp" />
	</div>



</body>
</html>