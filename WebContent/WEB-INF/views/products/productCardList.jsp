<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
​
<div id="imageCardList">
	<ul>
		<!-- 제품에 대한 모든 내용을 담고 있어야함 -->
		<c:forEach var="productinfo" items="${productinfoList}">
			<li>
				<div id="imageCard">
					<img id="imageCard_img" src="<%=application.getContextPath()%>/resources/img/product/${productinfo.prodimgdb.prodImagepath}/${productinfo.prodimgdb.productCode}/${productinfo.prodimgdb.prodImageoname}">
					
					<div id="imageCard_color">
						<!-- stock 테이블 정보로 foreach 사용해서 inline style 개별 적용 -->
						<div id="div1"></div>
						<div id="div2"></div>
						<div id="div3"></div>
					</div>
					<br><br>
					<div id="imageCard_name">${productinfo.productdb.productName}</div>
					
					<div id="imageCard_price">${productinfo.productdb.productPrice}</div>
				</div>
			</li>
		</c:forEach>
	</ul>
</div>