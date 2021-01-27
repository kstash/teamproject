package teamproject.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class loginController {
	private static final Logger logger = 
			LoggerFactory.getLogger(loginController.class);
	
	@PostMapping("/login")
	public String login(@RequestParam String userid, @RequestParam String userpwd, HttpSession session) {
		if(userid.equals("admin") && userpwd.equals("111111")){
			session.setAttribute("loginStatus", userid);
		}
		logger.info("로그인 성공");
		
		//로그인 시 메인 이동
		return "category/outer/index";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		logger.info("로그아웃");
		//로그아웃 시 메인 이동
		return "category/outer/index";
	}
	
	@RequestMapping("/signup")
	public String signup() {
		logger.info("회원가입 페이지");
		return "signup/signup";
	}
	
	@RequestMapping("/findid")
	public String findid() {
		logger.info("아이디 찾기 페이지");
		return "login/findid";
	}
	
	@RequestMapping("/findpwd")
	public String findpwd() {
		logger.info("비밀번호 찾기 페이지");
		return "login/findpwd";
	}
}
