<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div id="InnerCategory">
	<!-- 내부 카테고리 -->
	<ul class="inner_menu">
		<!-- 첫번째만 고정으로 설정하고 -->
		<div id="inner_stl">Stylenanda</div>
		<!-- 모델을 사용하여 메뉴 리스트 생성-->
		<c:forEach var="lowcategory" items="${lowcategorylist}">
			<li><a
				<c:if test="${lowcategory.lowcategoryKr == lowcategoryKr }"> class="inner_active" </c:if>
				href="<%=application.getContextPath()%>/category/?upcategoryeng=${lowcategory.upcategoryEng}&lowcategoryeng=${lowcategory.lowcategoryEng}">
					${lowcategory.lowcategoryKr}</a></li>
		</c:forEach>
	</ul>
	<div></div>

	<!-- 사이트 이동경로 -->
	<div id="inner_brd">
		<a class="inner_bread" href="<%=application.getContextPath()%>/">HOME</a>
		> <a class="inner_bread"
			href="<%=application.getContextPath()%>/categoryDetail/index">Stylenanda</a>
		<c:if test="${upcategoryKr != lowcategoryKr}">	
			>
		<a class="inner_bread"
				href="<%=application.getContextPath()%>/category/?upcategoryeng=${upcategoryeng}">${upcategoryKr}</a>
		</c:if>
		> <a class="inner_bread inner_active" href="">${lowcategoryKr}</a>
	</div>

	<!-- 목록정렬 -->
	<ul id="menu2">
		<li href="">
			<div class="chkbox"></div> 신상품
		</li>
		<li href="">
			<div class="chkbox"></div> 낮은가격
		</li>
		<li href="">
			<div class="chkbox"></div> 높은가격
		</li>
		<li href="">
			<div class="chkbox"></div> 이름
		</li>
	</ul>
</div>
