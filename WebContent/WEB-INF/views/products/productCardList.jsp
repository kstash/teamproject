<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
​
<div id="imageCardList">
${upcategoryeng}
	<ul>
		<c:forEach var="prodimage" items="${prodimage_list}">
			<li>
				<div id="imageCard" onclick="location.href='${prodimage.productCode}'">
					<img id="imageCard_img" src="<%=application.getContextPath()%>/resources/img/product/outer/products/${prodimage.prodImagepath}/${prodimage.productCode}/${prodimage.prodImageoname}">
					
					<div id="imageCard_color">
						<div id="div1"></div>
						<div id="div2"></div>
						<div id="div3"></div>
					</div>
					<br><br>
					<div id="imageCard_name">=== 제품 이름 위치 ===</div>
					
					<div id="imageCard_price">=== 제품 가격 위치 ===</div>
				</div>
			</li>
		</c:forEach>
	</ul>
</div>