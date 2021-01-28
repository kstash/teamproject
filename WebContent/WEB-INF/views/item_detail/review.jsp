<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>

<!-- 상품별 리뷰 -->
<div id="review_header">
	<b>REVIEW</b>
	<div id="review_header_right">
		<a href="">more></a>
	</div>
	<a href=""><img id="review_header_event" alt="리뷰_이벤트" src="<%=application.getContextPath()%>/resources/img/review/review_de.jpg"></a>
	
	<!-- 리뷰 요약 상자 -->
	<div id="review_summary">
		<div id="review_summaryleft">
			<div id="review_graph">
				<div id="review_score">
					<div id="review_scorebox">${fivescore}</div>
					${stars}개 리뷰 평점
				</div>

				<div id="review_bar">
					<ul>
						<li>5 star
							<div class="review_redbar" style="flex: ${star5}"></div>
							<div class="review_graybar" style="flex: ${starelse5}"></div>
							<div class="review_score">(${star5})</div>
						</li>
						<li>4 star
							<div class="review_redbar" style="flex: ${star4}"></div>
							<div class="review_graybar" style="flex: ${starelse4}"></div>
							<div class="review_score">(${star4})</div>
						</li>
						<li>3 star
							<div class="review_redbar" style="flex: ${star3}"></div>
							<div class="review_graybar" style="flex: ${starelse3}"></div>
							<div class="review_score">(${star3})</div>
						</li>
						<li>2 star
							<div class="review_redbar" style="flex: ${star2}"></div>
							<div class="review_graybar" style="flex: ${starelse2}"></div> 
							<div class="review_score">(${star2})</div>
						</li>
						<li>1 star
							<div class="review_redbar" style="flex: ${star1}"></div>
							<div class="review_graybar" style="flex: ${starelse1}"></div>
							<div class="review_score">(${star1})</div>
						</li>
					</ul>
				</div>
			</div>

			${fivescore*20}% 의 구매자들이 이 상품을 좋아합니다. ( ${stars}명 중 ${star5+star4}명 )
		</div>

		<div id="review_imgdiv">
			<div id="review_imgreview">
				<ul>
					<li>
						<c:if test="${orderCodeList[0] != null }">
							<img src="battach?ordercode=${orderCodeList[0]}" width="100%" height="100%">
						</c:if>
					</li>
					<li>
						<c:if test="${orderCodeList[1] != null }">
							<img src="battach?ordercode=${orderCodeList[1]}" width="100%" height="100%" >
						</c:if>
					</li>
					<li>
						<c:if test="${orderCodeList[2] != null }">
							<img src="battach?ordercode=${orderCodeList[1]}" width="100%" height="100%" >
						</c:if>
					</li>
					<li>
						<c:if test="${orderCodeList[3] != null }">
							<img src="battach?ordercode=${orderCodeList[1]}" width="100%" height="100%" >
						</c:if>
					</li>
				</ul>
				<ul>
					<li>
						<c:if test="${orderCodeList[4] != null }">
							<img src="battach?ordercode=${orderCodeList[0]}" width="100%" height="100%">
						</c:if>
					</li>
					<li>
						<c:if test="${orderCodeList[5] != null }">
							<img src="battach?ordercode=${orderCodeList[0]}" width="100%" height="100%">
						</c:if>
					</li>
					<li>
						<c:if test="${orderCodeList[6] != null }">
							<img src="battach?ordercode=${orderCodeList[0]}" width="100%" height="100%">
						</c:if>
					</li>
					<li>
						<c:if test="${orderCodeList[7] != null }">
							<img src="battach?ordercode=${orderCodeList[0]}" width="100%" height="100%">
						</c:if>
					</li>
					
				</ul>
			</div>
			이 상품의 포토리뷰 모아보기
		</div>

	</div>
	
	<!-- 리뷰 정렬기준 -->
	<div id="review_sort">
		<p id="review_action"><b>최신순 </b> 리뷰(${stars})</p>
		<p>|</p>
		<a href="">추천순</a>
		<p>|</p>
		<a href="">평점순</a>
		<div id="review_sort_info">i 리뷰정렬기준</div>
	</div>
	
	<div class="review_sizesort">
		<div>
			<select class="custom-select">
			  <option selected>SHOE SIZE</option>
			  <option value="1">One</option>
			  <option value="2">Two</option>
			  <option value="3">Three</option>
			</select>
		</div>
		<div>
			<select class="custom-select">
			  <option selected>BODY SIZE</option>
			  <option value="1">One</option>
			  <option value="2">Two</option>
			  <option value="3">Three</option>
			</select>
		</div>
		<div>
			<select class="custom-select">
			  <option selected>WEIGHTE</option>
			  <option value="1">One</option>
			  <option value="2">Two</option>
			  <option value="3">Three</option>
			</select>
		</div>
		<div>
			<select class="custom-select">
			  <option selected>HEIGHT</option>
			  <option value="1">One</option>
			  <option value="2">Two</option>
			  <option value="3">Three</option>
			</select>
		</div>
	</div>

	<c:forEach var="review" items="${reviewList}">
	<div class="review_case">	
		<div class="review_point_stars">
			<c:forEach begin="1" end="${review.reviewPoint}">
				<span class="review_point_star" style="background-image:url('<%=application.getContextPath()%>/resources/img/review/point_star.png');"></span>
			</c:forEach>
			<div class="review_writer">
			<br/>작성자<br/>
			<b>${review.userId}</b>
			</div>
		</div>
		<br/>
			${review.reviewContents}
		<c:if test="${review.reviewIsimage != null && review.reviewIsimage != 0 }">
			<br/>
			<img class="rounded" src="battach?ordercode=${review.orderCode}" width="200px"/>
		</c:if>
	</div>
	</c:forEach>
	

</div>