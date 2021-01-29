<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${review == null}">
	<a class="btn btn-success btn-sm" href="reviewwrite?ordercode=${ordercode}&productcode=${productcode}">작성하기</a>
</c:if>
<c:if test="${review != null}">
	작성됨
</c:if>