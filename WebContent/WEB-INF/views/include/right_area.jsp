<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- 모달 (본 태그 위치 조정 시 아래로 숨음) -->
<jsp:include page="/WEB-INF/views/rightsearch/rightsearch.jsp"/>
<div id="right_area">
	<div id="empty"></div>
	<div id="main">
		<!-- 메인 홈페이지로 링크 -->
		<a href="index" style="color:black;writing-mode: vertical-rl;"> www.stylenanda.com </a>
	</div>
	<div id="MenuSearch">
		<a href="rightmenu"><i class="fas fa-bars"></i></a> 
		<!-- 모달 버튼 -->
		<a data-toggle="modal" data-target="#exampleModal" role="button">
			<i class="fas fa-search"></i>
		</a>
	</div>
	
	<div id="buttons">
		<div id="loginBox">
			<!-- 로그인 안됐을 때 -->
			<c:if test="${sessionUserid == null}">
				<a href="login" style="color:black; writing-mode: vertical-rl;">Log in</a> 
			</c:if>
			<!-- 로그인 됐을 때 -->
			<c:if test="${sessionUserid != null}">
				<a href="logout" style="color:black; writing-mode: vertical-rl;">Log out</a> 
			</c:if>
		</div>
		<div id="empty"></div>
		<a href="mypage" style="color:black; writing-mode: vertical-rl;">My page</a> 
		<div id="empty"></div>
		<a href="language" style="color:black; writing-mode: vertical-rl;">Language <i class="fas fa-globe"></i></a>
	</div>	
</div>