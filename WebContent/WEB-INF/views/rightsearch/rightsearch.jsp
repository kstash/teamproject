<%@ page contentType="text/html; charset=UTF-8"%>
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
        	<input type="text" id="searchKeyword" name="searchKeyword" placeholder="검색어를 입력하세요."/>
        </form>
      </div>
      <!-- 버튼 -->
      <div class="modal-footer">
        <button type="button" id="modalSearchBtn" class="btn btn-primary">Go</button>
      </div>  
    </div>
  </div>
</div>

<script>
	$('#modalSearchBtn').on('click',function(){
		
	});
	
</script>
