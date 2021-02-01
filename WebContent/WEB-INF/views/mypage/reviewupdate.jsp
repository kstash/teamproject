<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 이거 모달로 바꾸고 집감 -->
<div class="modal" id="reviewreadModal${param.ordercode}" tabindex="-1" role="dialog"
	aria-labelledby="reviewwriteModalTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalCenterTitle">리뷰수정</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<!-- review write form -->
				<form enctype="multipart/form-data" name="reviewupdateform" action="reviewupdate" method="post">
					<input type="hidden" name="orderCode" value="${param.ordercode}" />
					<input type="hidden" name="reviewLikes" value="${param.reviewlikes}" />
					<input type="hidden" name="reviewIsimage" value="${param.reviewisimage}" />
					<div class="form-group">
						<label>상품 별점</label><br />
						<c:forEach var="i" begin="1" end="5">
							<div class="form-check form-check-inline">
								<c:if test="${param.reviewpoint == i}">
									<input class="form-check-input" type="radio" name="reviewPoint" id="inlineRadio${i}" value="${i}" checked="checked">
									<label class="form-check-label" for="inlineRadio${i}">${i}</label>
								</c:if>
								<c:if test="${param.reviewpoint != i}">
									<input class="form-check-input" type="radio" name="reviewPoint" id="inlineRadio${i}" value="${i}">
									<label class="form-check-label" for="inlineRadio${i}">${i}</label>
								</c:if>
							</div>
						</c:forEach>
					</div>

					<div class="form-group">
						<label for="reviewContents">리뷰내용</label>
						<textarea class="form-control" id="reviewContents" name="reviewContents" rows="5" cols="50">${param.reviewcontents}</textarea>
					</div>
					<button class="btn btn-primary">저장</button>
					<a class="btn btn-danger" href="reviewdelete?ordercode=${param.ordercode}">삭제</a>
				</form>
			</div>
		</div>
	</div>
</div>










