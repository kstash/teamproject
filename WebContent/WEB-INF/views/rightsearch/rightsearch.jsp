<%@ page contentType="text/html; charset=UTF-8"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=application.getContextPath()%>/resources/js/rightsearch/rightsearch.js">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


<div class="modal" id="searchModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
    
      <!-- Search 타이틀 -->
      <div class="modal-header">
        <h6 class="modal-title" id="exampleModalLabel">Search</h6>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      
      <!-- 검색창 -->
      <div class="modal-body">
      	<form name="rightsearch" action="rightsearch" method="get">
        	<input type="text" id="inputsearch" name="inputsearch" value="검색어를 입력하세요."/>
        	<!-- go 클릭 시 페이지 이동 -->
        	<a class="btn" href="rightsearchDetail">go</a><br>
        </form>
      </div>
      
    </div>
  </div>
</div>