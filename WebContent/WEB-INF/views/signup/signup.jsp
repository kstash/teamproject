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
		<link rel="stylesheet" href="<%=application.getContextPath() %>/resources/css/signup/signup.css">
		<link rel="stylesheet" href="<%=application.getContextPath() %>/resources/css/base_element/footermen.css">
		<%-- <link rel="stylesheet" href="<%=application.getContextPath() %>/resources/js/signup/signup.js"> --%>
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
			
			<!-- 중간에 감싸는 부분이 없으면 가운데 부분이 다 독립적으로 flex에 반영하여 가로로 정렬 됩니다 -->
			<div>
				<!-- 회원가입 -->
				<jsp:include page="/WEB-INF/views/signup/signupForm.jsp" />
				
				<jsp:include page="/WEB-INF/views/include/footer.jsp" />
				</div>
			<!-- 우측 메뉴 -->
			<jsp:include page="/WEB-INF/views/include/right_area.jsp" />
		</div>

  </body>
 </html>