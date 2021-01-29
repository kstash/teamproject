<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <html>
  <head>
   <meta charset="UTF-8">
   <link rel="shortcut icon" type="image/x-icon" href="<%=application.getContextPath()%>/resources/img/title/heart.svg">
   <title>www.stylenanda.com</title>
   		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
   		<link rel="stylesheet" href="<%=application.getContextPath() %>/resources/css/index/index.css">
		<link rel="stylesheet" href="<%=application.getContextPath() %>/resources/css/index/header.css">
		<link rel="stylesheet" href="<%=application.getContextPath() %>/resources/css/index/left_area.css">
		<link rel="stylesheet" href="<%=application.getContextPath() %>/resources/css/index/right_area.css">
		<link rel="stylesheet" href="<%=application.getContextPath() %>/resources/css/base_element/footermen.css">
		
		<link rel="stylesheet" href="<%=application.getContextPath() %>/resources/css/cart/cart.css">
		
		<!-- 아이콘 사용 -->
		<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
  </head>
  
  <body>
	<div class="wrap_content">
		<!-- 좌측 메뉴 -->
		<jsp:include page="/WEB-INF/views/include/left_area.jsp" />

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
			<!-- 장바구니  / 푸터-->
			<div id="lf">
				<jsp:include page="/WEB-INF/views/cart/cartForm.jsp" />
				<jsp:include page="/WEB-INF/views/include/footer.jsp" />
			</div>
		</div>
		<!-- 우측 메뉴 -->
		<jsp:include page="/WEB-INF/views/include/right_area.jsp" />

	</div>

  </body>
 </html>