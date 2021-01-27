<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <html>
  <head>
   <meta charset="UTF-8">
   <title>www.stylenanda.com</title>
   		<link rel="stylesheet" href="<%=application.getContextPath() %>/resources/css/index/index.css">
		<link rel="stylesheet" href="<%=application.getContextPath() %>/resources/css/index/header.css">
		<link rel="stylesheet" href="<%=application.getContextPath() %>/resources/css/index/left_area.css">
		<link rel="stylesheet" href="<%=application.getContextPath() %>/resources/css/index/right_area.css">
		<link rel="stylesheet" href="<%=application.getContextPath() %>/resources/css/login/login.css">
		<link rel="stylesheet" href="<%=application.getContextPath() %>/resources/css/base_element/footermen.css">
  </head>
  
  <body>
		<div class="wrapper">
			<div id="header">
				<%-- 중앙 --%>
				<jsp:include page="/WEB-INF/views/include/header.jsp" />
			</div>
			
			<div class="wrap_content">
				<!-- 좌측 메뉴 -->
				<jsp:include page="/WEB-INF/views/include/left_area.jsp" />
				
				<!-- 로그인 -->
				<jsp:include page="/WEB-INF/views/login/loginform.jsp" />
				
				<!-- 우측 메뉴 -->
				<jsp:include page="/WEB-INF/views/include/right_area.jsp" />
			</div>
			
			<jsp:include page="/WEB-INF/views/include/footer.jsp" />
		</div>   
  </body>
 </html>