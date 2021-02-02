<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<label for="orderSize">size :</label>
<select class="form-select p-1" name="orderSize" id="orderSize" style="width: 200px">
	<option selected>사이즈선택</option>
	<c:if test="${stock.stockSizeS != null && stock.stockSizeS != 0}">
		<option value="S">S사이즈 : ${stock.stockSizeS}개</option>
	</c:if>
	<c:if test="${stock.stockSizeM != null && stock.stockSizeM != 0}">
		<option value="M">M사이즈 : ${stock.stockSizeM}개</option>
	</c:if>
	<c:if test="${stock.stockSizeL != null && stock.stockSizeL != 0}">
		<option value="L">L사이즈 : ${stock.stockSizeL}개</option>
	</c:if>
	<c:if test="${stock.stockSizeXL != null && stock.stockSizeXL != 0}">
		<option value="XL">XL사이즈 : ${stock.stockSizeXL}개</option>
	</c:if>
</select>