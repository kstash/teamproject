<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/mypage/reviewwrite.jsp" />
<c:if test="${review == null}">
	<a class="btn btn-success btn-sm" data-toggle="modal" href="#reviewwriteModal">작성하기</a>
</c:if>
<c:if test="${review != null}">
	작성됨
</c:if>