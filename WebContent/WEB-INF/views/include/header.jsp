<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 최상단 메뉴 -->
<div>
<ul id="main_menu">
	<c:forEach var="upcategory" items="${upcategories}" >
		<li><a style="color:black;" href="<%=application.getContextPath()%>/category/?upcategoryeng=${upcategory.upcategoryEng}">${upcategory.upcategoryKr}</a>
			<ul id="dropmenu1">
				<c:forEach var="lowcategory" items="${lowcategories}">
					<c:if test="${lowcategory.upcategoryEng == upcategory.upcategoryEng}" >
						<li style="margin:0px; width:60px"><a href="<%=application.getContextPath()%>/category/?upcategoryeng=${upcategory.upcategoryEng}&lowcategoryeng=${lowcategory.lowcategoryEng}">${lowcategory.lowcategoryKr}</a></li><br/>
					</c:if>
				</c:forEach>
			</ul>
		</li>
	</c:forEach>

	
	<br><br><br><br>
</div>
