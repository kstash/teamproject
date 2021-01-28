package teamproject.controller;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import teamproject.dto.UserDB;
import teamproject.service.UserDBService;

@Controller
public class loginController {
	private static final Logger logger = 
			LoggerFactory.getLogger(loginController.class);
	
	@Resource
	private UserDBService userDBService;
	
	@PostMapping("/login")
	public String login(UserDB userDB, HttpSession session, 
			HttpServletResponse response){
		logger.info(userDB.getUserid());
		
		//서비스 호출
		//success, wrongUserid, wrongUserpw
		
		String result = userDBService.login(userDB);
		logger.info("result값 저장");
		
		if(result.equals("success")) {
			session.setAttribute("sessionUserid", userDB.getUserid());
			logger.info((String) session.getAttribute("sessionUserid"));
			//로그인 시 메인 이동
			logger.info("로그인 성공");
			return "redirect:/";
		} else {
			return "redirect:/login";
		}
			
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		logger.info("로그아웃");
		//로그아웃 시 메인 이동
		return "redirect:/";
	}
	
	@RequestMapping("/signup") //메소드 이름 변경
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
