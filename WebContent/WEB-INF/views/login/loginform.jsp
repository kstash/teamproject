<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Login 및 버튼을 감싸는 wrapper -->
<div id="wrapper">
	<span>LOGIN</span><br>
	<!-- Input 및 버튼을 감싸는 login -->
	<form method="post" action="login" id="login">
		<input type="text" class="form-control" id="userid" name="userid" placeholder="ID"/> 
		<input type="password" class="form-control" id="userpw" name="userpw" placeholder="PASSWORD"/>
		
		<!-- 아이디 저장 및 보안접속 표시 -->
		<div id="login_option">
			<div id="chk_remember">
				<input type="checkbox" id="rememberid" name="rememberid" ${checked}/>
				<label for="rememberid" name="chk_remeber">아이디 저장</label>
			</div>
			<div id="secret_login">보안 접속</div>
		</div>
		<!-- 로그인 버튼 -->
			<div id="login_div">
				<button id="login_btn">로그인</button>
			</div>
	</form>
	
	<!-- 회원가입 버튼 -->
	<div id="signup_div">
		<a type="button" id="signup_btn" href="signup">회원가입</a>
	</div>
	
	
	<!-- 로그인 관련 정보 조회 버튼 -->
	<div id="login_find">
		<a id="findid" href='findid'
			style="text-decoration: none; color:black; font-size: 0.8rem;"
			>아이디 찾기</a><br>
		<a id="findpwd" href='findpwd'
			style="text-decoration: none; color:black; font-size: 0.8rem;"
			>비밀번호 찾기</a><br>
		<a id="guestorder" href='guestorder'
			style="text-decoration: none; color:black; font-size: 0.8rem;"
			>비회원 주문 조회</a>
	</div>
	
	
	<!-- sns로 로그인하기 -->
	<div id="login_sns">
		<input type="image" id="login_btn_fb" name="login_btn_fb" src="<%=application.getContextPath()%>/resources/img/login/fb.png" width="35px" height="35px"/>
		<input type="image" id="login_btn_kt" name="login_btn_kt" src="<%=application.getContextPath()%>/resources/img/login/kt.png" width="35px" height="35px"/>
		<input type="image" id="login_btn_ap" name="login_btn_ap" src="<%=application.getContextPath()%>/resources/img/login/ap.png" width="35px" height="35px"/>
		<input type="image" id="login_btn_nv" name="login_btn_nv" src="<%=application.getContextPath()%>/resources/img/login/nv.png" width="35px" height="35px"/>			
	</div>
</div>