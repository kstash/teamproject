<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<form action="postProduct" method="post" enctype="multipart/form-data" class="col">
	
	<input type="hidden" name="lowcategoryEng" value="${lowcategoryeng}">
	<div class="row">
		<div class="col">
			<div class="row">
				<div class="col">
					<label for="productName">제품명</label>
					<hr>
					<textarea rows="4" cols="50" name="productName" id="productName"></textarea>
				</div>
				<div class="col">
					<label for="productDesc">제품설명</label>
					<hr>
					<textarea rows="10" cols="50" name="productDesc" id="productDesc"></textarea>
				</div>
			</div>
		</div>
		<div class="col">
			<div>
				<label for="productFabric">제품원료</label>
				<hr>
				<input type="text" style="width:300px; height:50px;" name="productFabric" id="productFabric">
			</div>
			<div>
				<label for="productPrice">제품가격</label>
				<hr>
				<input type="number" name="productPrice" id="productPrice">원
			</div>
			<div>
				<label>리스트 이미지</label><br>
				<input type="file" name="prodImageattachList">
			</div>
			<div>
				<label>메인 이미지</label><br>
				<input type="file" name="prodImageattachMain">
			</div>
			
			<div>
				<label>상세 이미지</label><br>
				<input type="file" name="prodImageattachDetail" multiple>
			</div>
			<button class="btn btn-sm btn-success" style="float:right;" type="submit">제품 등록</button>
		</div>
	</div>
</form>