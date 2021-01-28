<%@ page contentType="text/html; charset=UTF-8"%>

<div id="wrapper">
	<span>SIGN UP</span>
	<form id="signupForm" name="signupForm" action="signup" method="post">
		<label for="userid">아이디</label>
		<input type="text" class="form-control" id="userid" name="userid"/>
		<label for="userpw">비밀번호</label>
		<input type="password" class="form-control" id="userpw" name="userpw"/>
		<label for="userpwchk" >비밀번호 확인</label>
		<input type="password" class="form-control" id="userpwchk" name="userpwchk"/>
		<label for="username">이름</label>
		<input type="text" class="form-control" id="username" name="username"/>
		<label for="useraddr">주소</label>
		<input type="text" class="form-control" id="useraddr" name="useraddr"/>
		<label for="useremail">이메일</label>
		<input type="email" class="form-control" id="useremail" name="useremail"/>
		<label for="userphone">핸드폰 번호</label>
		<input type="tel" class="form-control" id="userphone" name="userphone"/>
		
		<div id="btns">
			<button class="btn">Sign up</button>
			<a class="btn" href="login">Cancel</a>
		</div>
	
	</form>
</div>