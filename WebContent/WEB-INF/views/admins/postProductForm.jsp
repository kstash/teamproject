<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<form action="postProduct" method="post" enctype="multipart/form-data" class="row">
	
	<input type="hidden" name="lowcategoryEng" value="${lowcategoryeng}">
	<div class="row">
		<div class="col">
			<div>
				<label>제품명</label>
				<input type="text" name="productName">
			</div>
			<div class="row">
				<div class="col">
					<label>제품설명</label>
					<textarea rows="10" cols="50" name="productDesc"></textarea>
				</div>
				
				<div class="col">
					<label>제품원료</label>
					<textarea rows="5" cols="50" name="productFabric"></textarea>
				</div>
			</div>
			<div>
				<label>제품가격</label>
				<input type="number" name="productPrice">
			</div>
		</div>
		<div class="col">
			<div>
				<label>리스트 이미지</label>
				<input type="file" name="prodImageattachList">
			</div>
			<div>
				<label>메인 이미지</label>
				<input type="file" name="prodImageattachMain">
			</div>
			
			<div>
				<label>상세 이미지</label>
				<input type="file" name="prodImageattachDetail" multiple>
			</div>
		</div>
	</div>
	<div>
		<button type="submit">등록</button>
	</div>
</form>