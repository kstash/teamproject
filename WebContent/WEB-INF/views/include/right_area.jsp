<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="right_area">
	<div id="main">
		<!-- 메인 홈페이지로 링크 -->
		<a href="index" style="color:black;"> www.stylenanda.com </a>
	</div>
	<div id="MenuSearch">
		<a href="menusearch"><i class="fas fa-bars"></i></a> <a href=""><i
			class="fas fa-search"></i></a>
	</div>
	
		<div id="loginBox">
			<!-- 로그인 안됐을 때 -->
			<c:if test="${loginStatus == null}">
				<a href="login" style="color:black;">Log in</a> 
			</c:if>
			<!-- 로그인 됐을 때 -->
			<c:if test="${loginStatus != null}">
				<a href="logout" style="color:black;">Log out</a> 
			</c:if>
		</div>
		<div id="buttons">
			<a href="mypage" style="color:black;">My page</a> 
			<a href="language" style="color:black;">Language <i class="fas fa-globe"></i></a>
		</div>
</div>