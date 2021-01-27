<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>www.stylenanda.com/knit</title>

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
			<br> <br> <br> <br> <br>
			<!-- DB연동 필수 -->
			<h3>카테고리 구성 (편집)</h3>
			<br>
			<table class="table table-hover">
				<thead>
				</thead>

				<tbody>
					<tr>
						<th scope="row">아우터</th>
						<td><a type="button" class="btn btn-primary btn-sm link"
							data-toggle="modal" data-target="#exampleModal">코트</a></td>
						<td><a type="button" class="btn btn-primary btn-sm"
							data-toggle="modal" data-target="#exampleModal">패딩</a></td>
						<td><a type="button" class="btn btn-primary btn-sm"
							data-toggle="modal" data-target="#exampleModal">자켓</a></td>
						<td><a type="button" class="btn btn-primary btn-sm"
							data-toggle="modal" data-target="#exampleModal">퍼자켓</a></td>
						<td><a type="button" class="btn btn-primary btn-sm"
							data-toggle="modal" data-target="#exampleModal">가죽자켓</a></td>
					</tr>

					<tr>
						<th scope="row">상위 카테고리2</th>
						<td><a type="button" class="btn btn-primary btn-sm"
							data-toggle="modal" data-target="#exampleModal"> 하위 카테고리1 </a></td>
						<td><a type="button" class="btn btn-primary btn-sm"
							data-toggle="modal" data-target="#exampleModal"> 하위 카테고리1 </a></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>

					<tr>
						<th scope="row">상위 카테고리3</th>
						<td><a type="button" class="btn btn-primary btn-sm"
							data-toggle="modal" data-target="#exampleModal"> 하위 카테고리1 </a></td>
						<td><a type="button" class="btn btn-primary btn-sm"
							data-toggle="modal" data-target="#exampleModal"> 하위 카테고리1 </a></td>
						<td><a type="button" class="btn btn-primary btn-sm"
							data-toggle="modal" data-target="#exampleModal"> 하위 카테고리1 </a></td>
						<td><a type="button" class="btn btn-primary btn-sm"
							data-toggle="modal" data-target="#exampleModal"> 하위 카테고리1 </a></td>
						<td></td>
					</tr>
				</tbody>
			</table>

			<!-- Modal -->
			<!-- 클릭한 카테고리에 따라서 다르게 정보 넣어서 불러오기 -->
			<!-- DB연동 필수 -->
			<jsp:include page="/WEB-INF/views/admins/categoryInfoModal.jsp" />

			<!-- 제품 업로드 -->
			<!-- DB연동 필수 -->
			<div id="productUploadForm" class="mt-5 mb-5">
				<h3>제품 업로드</h3>
				<hr>
				<div class="input-group mb-3" style="width:300px;">
					<div class="input-group-prepend">
						<label class="input-group-text" for="inputGroupSelect01">상위 카테고리</label>
					</div>
					<select class="custom-select" id="inputGroupSelect01">
						<option selected></option>
						<option value="outer">아우터</option>
						<option value="top">탑</option>
						<option value="skirt">스커트</option>
					</select>
				</div>
				
				<div class="input-group mb-3" style="width:300px;">
					<div class="input-group-prepend">
						<label class="input-group-text" for="inputGroupSelect01">하위 카테고리</label>
					</div>
					<select class="custom-select" id="inputGroupSelect01">
						<option selected></option>
						<option value="coat">코트</option>
						<option value="padding">패딩</option>
						<option value="jacket">자켓</option>
						<option value="furjacket">퍼자켓</option>
						<option value="leatherjacket">가죽자켓</option>
					</select>
				</div>
			</div>





			<jsp:include page="/WEB-INF/views/include/footer.jsp" />
		</div>

		<!-- 우측 메뉴 -->
		<jsp:include page="/WEB-INF/views/include/right_area.jsp" />
	</div>



</body>
</html>