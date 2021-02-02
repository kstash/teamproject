<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="adminstest_product" method="post" enctype="multipart/form-data">
		productName:
		<input type="text" name="productName">
		productDesc:
		<input type="text" name="productDesc">
		productPrice:
		<input type="number" name="productPrice">
		
		<hr>
		prodImageattach_list:
		<input type="file" name="prodImageattachList">
		
		<hr>
		prodImageattach_main:
		<input type="file" name="prodImageattachMain">
		
		<hr>
		prodImageattach:
		<input type="file" name="prodImageattachDetail" multiple>
		<button type="submit">등록</button>
	</form>
</body>
</html>