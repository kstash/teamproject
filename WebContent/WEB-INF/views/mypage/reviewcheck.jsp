<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${review == null}">
	<a class="btn btn-success btn-sm" data-toggle="modal" href="#reviewwrite${ordercode}Modal">작성하기</a>
</c:if>
<c:if test="${review != null}">
	작성됨
</c:if>
<div class="modal" id="reviewwrite${ordercode}Modal" tabindex="-1" role="dialog" aria-labelledby="reviewwriteModalTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalCenterTitle">상품 리뷰</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<!-- review write form -->
				<form enctype="multipart/form-data" name="reviewwriteform" action="reviewwrite" method="post">
					<input type="hidden" name="orderCode" value="${ordercode}" />
					<input type="hidden" name="productCode" value="${productcode}" />
					<div class="form-group">
						<label>상품 별점</label><br />
						<c:forEach var="i" begin="1" end="5">
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="reviewPoint"
									id="inlineRadio${i}" value="${i}"> <label
									class="form-check-label" for="inlineRadio${i}">${i}</label>
							</div>
						</c:forEach>
					</div>

					<div class="form-group">
						<label for="reviewContents">리뷰내용</label>
						<textarea class="form-control" id="reviewContents"
							name="reviewContents" rows="5" cols="50"></textarea>
					</div>
					
					<div class="form-group">
						<label for="rphoto">첨부파일</label>
						<input type="file" id="rphoto" name="rphoto"/>
					</div>
					
					<button class="btn btn-primary">저장</button>
				</form>
			</div>
		</div>
	</div>
</div>