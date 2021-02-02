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
									<c:if
										test="${lowcategory.upcategoryEng == upcategory.upcategoryEng}">
										<td><a type="button" href="choselowcategory"
											class="btn btn-primary btn-sm link" data-toggle="modal"
											data-target="#categoryInfoModal">
												${lowcategory.lowcategoryKr} </a></td>
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
				<div>
					<h3>제품 등록</h3>
					<hr>
					<div class="form-group mr-3 col">
						<label for="FormControlSelectUpCategory">상위 카테고리</label>
						<script type="text/javascript">
							function f1(value){
								$.ajax({
									url: "lowcategorySelect",
									data: {upcategoryeng: value},
									method: "get",
									success: function(data) {
										console.log(data);
										$("#lowcategory_select").html(data);
									}
								});
							}
						</script>
						
						<select class="form-control" id="FormControlSelectUpCategory" onchange="javascript:f1(this.value)">
							<c:forEach var="upcategorySelect" items="${upcategories}">
								<option id="upcategorySelectOption" value="${upcategorySelect.upcategoryEng}">
									${upcategorySelect.upcategoryKr}
								</option>
							</c:forEach>
						</select>
						
						<script type="text/javascript">
							function f2(value) {
								$.ajax({
									url: "postProductForm",
									data: {lowcategoryeng: value},
									method: "get",
									success: function(data) {
										console.log(data);
										console.log(data.categoryinfo);
										$("#postProduct_form").html(data);
									}
								})
							}
						</script>
						<div id="lowcategory_select"></div>
					</div>
					<div id="postProduct_form"></div>
				</div>
				<br> <br>
			</div>

			<jsp:include page="/WEB-INF/views/include/footer.jsp" />
		</div>

		<!-- 우측 메뉴 -->
		<jsp:include page="/WEB-INF/views/include/right_area.jsp" />
	</div>



</body>
</html>