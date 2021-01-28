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
											data-target="#categoryInfoModal">${lowcategory.lowcategoryKr}</a></td>
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
				<h3>제품 등록</h3>
				<hr>
				<form action="" class="col" style="width: 50%;">
					<div class="flex col">
						<div class="row">
							<div class="form-group mr-3 col">
								<label for="FormControlSelectUpCategory">상위 카테고리</label> <select
									class="form-control" id="FormControlSelectUpCategory">
									<c:forEach var="upcategorySelect" items="${upcategories}">
										<option id="upcategorySelectOption" onclick="getlowcategories" value="${upcategorySelect.upcategoryEng}">${upcategorySelect.upcategoryKr}
									</c:forEach>
								</select>
							</div>
							<script type="text/javascript">
								const getlowcategories = function(){
									$("#upcategorySelectOption").on("click", function(){
										$.ajax({
											url: "choseUpCategory?chosenUpCategory="+$("#upcategorySelectOption").value(),
											method: "get",
											success: function(data){
												console.log(data);
												for(var i=0; i<data.length; i++) {
													var board = data[i];
													$("#result3 tbody").append("<tr>");
													$("#result3 tbody").append("<td>" + board.bno + "</td>");
													$("#result3 tbody").append("<td>" + board.btitle + "</td>");
													$("#result3 tbody").append("<td>" + board.bwriter + "</td>");
													$("#result3 tbody").append("</tr>");
												}
											}
										})
									})
								}
							</script>
							<div class="form-group mr-3 col">
								<label for="FormControlSelectLowCategory">하위 카테고리</label> 
								<select class="form-control" id="FormControlSelectLowCategory">
								</select>
							</div>
						</div>

						<div class="row">
							<div class="form-group mr-3 col" style="width: 300px;">
								<label for="productName">제품명</label>
								<div class="input-group" id="productName">
									<input type="text" id="productNameInput" name="productNameInput" class="form-control">
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
								<textarea class="form-control" id="productDescInput" name="productDescInput" rows="3"></textarea>
							</div>
						</div>
					</div>
					<div class="col">
						<div class="row">
							<div class="input-group mb-3">
								<div class="input-group-prepend" style="padding-top:0;">
									<span class="input-group-text" id="inputGroupFileAddon01">리스트 이미지</span>
								</div>
								<div class="custom-file">
									<input type="file" class="custom-file-input" id="productListImageFile" aria-describedby="inputGroupFileAddon01">
									<label class="custom-file-label" for="productListImageFile">Choose file</label>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="input-group mb-3">
								<div class="input-group-prepend" style="padding-top:0;">
									<span class="input-group-text" id="inputGroupFileAddon02">메인 이미지</span>
								</div>
								<div class="custom-file">
									<input type="file" class="custom-file-input" id="productMainImageFile" aria-describedby="inputGroupFileAddon02">
									<label class="custom-file-label" for="productMainImageFile">Choose file</label>
								</div>
							</div>
						</div>
					</div>
				</form>
				
				<form class="col" name="fileForm" action="requestImageFiles" method="post" enctype="multipart/form-data">
					<input multiple="multiple" type="file" name="file" />
					<input class="btn btn-primary btn-sm" type="submit" value="등록" />
				</form>
			</div>





			<jsp:include page="/WEB-INF/views/include/footer.jsp" />
		</div>

		<!-- 우측 메뉴 -->
		<jsp:include page="/WEB-INF/views/include/right_area.jsp" />
	</div>



</body>
</html>