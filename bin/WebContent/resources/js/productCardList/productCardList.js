$(function() {
	$.ajax({
		url : "../products/productCardList",
		method : "get",
		success : function(data) {
			$("#productCardList").html(data);
		}
	});
});