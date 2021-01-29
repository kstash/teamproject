<%@ page contentType="text/html; charset=UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<div id="wrapper">
	<span id="signupTitle">SIGN UP</span>
	<form id="signupForm" name="signupForm" action="signup" method="post">
		<div>
			<label for="userid">아이디</label>
			<input type="text" class="form-control" id="userid" name="userid"/>
		</div>
		
		
		<div>
			<label for="userpw">비밀번호</label>
			<input type="password" class="form-control" id="userpw" name="userpw" placeholder="8~16자리로 구성해주세요."/>
		</div>
		
		<div>
			<label for="userpwchk" >비밀번호 확인</label>
			<input type="password" class="form-control" id="userpwchk" name="userpwchk" onkeyup="chkPw(this)"/>
			<span id="notsame"></span>
		</div>
		
		
		<div>
			<label for="username">이름</label>
			<input type="text" class="form-control" id="username" name="username"/>
		</div>
		
		<div>
			<label for="useraddr">주소</label>
			<input type="text" class="form-control" id="useraddr" name="useraddr"/>
		</div>
		
		<div>
			<label for="useremail">이메일</label>
			<input type="email" class="form-control" id="useremail" name="useremail"/>
		</div>
		
		<div>
			<label for="userphone">핸드폰 번호</label>
			<input type="tel" class="form-control" id="userphone" name="userphone"/>
		</div>
		
		<div id="btns">
			<button id="signupSubmit" class="btn">Sign up</button>
			<a class="btn" href="login">Cancel</a>
		</div>
	
	</form>
</div>

<script>
	var userpw = $('#userpw').val();
	var userpwchk = $('#userpwchk').val();
	function chkPw(){
		$('#userpw').keyup(function(){
			$('notsame').html('');
		});
		
		$('#userpwchk').keyup(function(){
			if(userpw === userpwchk){
				$('#notsame').html('');
				$('#notsame').attr('display','none');
			} else{
				$('#notsame').html('Wrong Password');
				//$('#signupSubmit').attr('disabled');
			}
		});
	} 
	
	$("#signupSubmit").click(function (){
		alert('환영합니다. 사랑과 관심으로 모시겠습니다.');
	});
	
	$(window).on('load', function (){
		alert('환영합니다. 사랑과 관심으로 모시겠습니다.');
		
		var userpw = $('#userpw').val();
		var userpwchk = $('#userpwchk').val();
		
			if(userpw != userpwchk){
				$('#signupSubmit').attr('color','white');
			}
		
	});
	
	/* var userpw = $('#userpw').val();
	var userpwchk = $('#userpwchk').val();
	
		if(userpw != userpwchk){
			$('#signupSubmit').attr('disabled');
		} */
</script>