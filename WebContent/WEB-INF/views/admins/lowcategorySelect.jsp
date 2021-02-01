<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<label for="FormControlSelectLowCategory">하위 카테고리</label>
<select class="form-control" id="FormControlSelectLowCategory" onchange="javascript:f2(this.value)">
	<c:forEach var="lowcategorySelect" items="${confirmedLowcategories}">
		<option id="lowcategorySelectOption" value="${lowcategorySelect.lowcategoryEng}">
			${lowcategorySelect.lowcategoryKr}
		</option>
	</c:forEach>
</select>