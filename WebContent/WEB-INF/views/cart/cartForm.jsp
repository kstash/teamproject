<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div id="wrapper">
<div id="empty"></div>
<div id="empty"></div>
<div id="empty"></div>
<div id="empty"></div>
<div id="empty"></div>
<div id="empty"></div>
<div id="empty"></div>
<div id="empty"></div>
<div id="empty"></div>
<div id="empty"></div>
	<span id="cartTitle"> C A R T </span>
	<c:if test="${sessionUserid == null}">
		<div id="empty"></div>
		<span id="emptyCart">장바구니가 비었습니다.</span>
		<a id="cartLogin"class="btn" href="login">로그인하기</a>
	</c:if>
	<c:if test="${sessionUserid != null}">
	<table id="cartTable" class="table table-hover">
		<thead>
		    <tr>
		      <th>
		      	선택<input type="checkbox" id="selectAllBtn"></input>
		      </th>
		      <th>코드</th>
		      <th>상품</th>
		      <th>사이즈</th>
		      <th>색상</th>
		      <th>수량</th>
		      <th>가격</th>
		      <th></th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach  var="cartlist" items="${cartlist}">
		  		<c:if test="${sessionUserid == cartlist.userid}">
			  		<tr id="cartRow">
			  			<td id="tdcartChk">
			  				<input class="form-check-input" type="checkbox" id="cartChk" name="cartChk"></input>
			  				</td>
			  			<td>${cartlist.cartcode}</td>
			  			<td id="product">${cartlist.productname}</td>
			  			<td>${cartlist.cartsize}</td>
			  			<td>${cartlist.cartcolor}</td>
			  			<td id="count">${cartlist.cartcount}</td>
			  			<td id="price">${cartlist.productprice}</td>
			  			<td id="deleteRow">
			  				<a id="deleteBtn" class="btn btn-sm" href="deleteCart?cartcode=${cartlist.cartcode}">삭제</a>
			  			</td>

			  		</tr>
		  		</c:if>
		  	</c:forEach>
		  			<tr id="totalRow">
		  				<td colspan="3"></td>
		  				<td>배송비</td>
		  				<td id="shiping"></td>
		  				<td  colspan="2">상품금액</td>
		  				<td id="productTotal"></td>
		  			</tr>
		  			<tr id="totalPrice">
		  				<td></td>
		  				<td colspan="6">결제 금액</td>
		  				<td id="pricetoPay"></td>
		  			</tr>
		  </tbody>
	</table>
	
	<!-- cart 테이블 정보 order 테이블로 넘기기 -->
	<!-- orderFromCarts 어떻게 써야함? -->
	<div id="btns">
			<button id="cartBuy" class="btn" href="cartBuy">구매하기</button>
			<a id="cartCancel"class="btn" href="index">취소</a>
	</div>
	</c:if>
</div>
<script>
console.log("스크립트 실행");

//cartTable 로드 시 체크된 row 값 가져오기
$("#selectAllBtn").on('click', function() {
	console.log("click시 실행");
	if($("#selectAllBtn").prop("checked")) {
		$("input[type=checkbox]").prop("checked",true); 
	} else {
		$("input[type=checkbox]").prop("checked",false); 
	}

	var cartRow = new Array();
	var prices = new Array();
	
 	var checkbox = $("input[name=cartChk]:checked");	

	//체크된 체크박스 값 가져오기
	checkbox.each(function(i){
		
		// checkbox.parent() : checkbox의 부모는 <td>이다.
	    // checkbox.parent().parent() : <td>의 부모이므로 <tr>이다.
		var tr = checkbox.parent().parent().eq(i);
		var td = tr.children();
		
		// 체크된 row의 모든 값을 배열에 담는다.
		cartRow.push(tr.text());
		
		// td.eq(0)은 체크박스 이므로  td.eq(1)의 값부터 가져온다.
		var cartcode = td.eq(1).text();
		var pcount = td.eq(5).text();
		var pprice = td.eq(6).text();

		console.log(pprice);
		console.log(pcount);
		
		prices.push(pprice * pcount);
		var sum = 0;
		for(var i=0; i<price.length; i++){
			sum = sum + parseInt(prices[i]);
			console.log(prices[i]);
		}
		
		//배송비, 상품가격, 결제 금액 구하기
		if(sum >= 50000){
			$("#shiping").html("0원");
			$("#productTotal").html(sum+"원");
			$("#pricetoPay").html(sum+"원");
		} else {
			$("#shiping").html("3000원");
			$("#productTotal").html(sum+"원");
			$("#pricetoPay").html(sum+3000+"원");
		}

	});
});

//상품 클릭 시 상세정보 보여주기
$('#product').on('click', function () {
	//상세페이지 경로
	
});

</script>
