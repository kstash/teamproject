<%@ page contentType="text/html; charset=UTF-8"%>
<div class="modal" id="mypageModal" tabindex="-1" role="dialog" aria-labelledby="mypageModalTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalCenterTitle">Mypage</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <button type="button" onclick="location.href = 'mypage/orderlist' " class="btn btn-primary">주문내역</button>
        : 내가 주문한 내역 확인
        <br/><br/>
        <button type="button" onclick="location.href = 'mypage/reviewlist'" class="btn btn-primary">리뷰내역</button>
        : 내가 작성한 리뷰 확인
      </div>
    </div>
  </div>
</div>
