package teamproject.controller;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	public void login(UserDB userDB, HttpSession session, 
			HttpServletResponse response) throws Exception{
		logger.info(userDB.getUserid());
		
		//서비스 호출
		//success, wrongUserid, wrongUserpw
		String result = userDBService.login(userDB);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		
		if(result.equals("admin")) {
			logger.info("admin 로그인 성공");
			pw.println("<script>alert('admin입니다.'); "
					+ "location.href='admins/adminspage';</script>");
			pw.flush();
		}else if(result.equals("success")) {
			session.setAttribute("sessionUserid", userDB.getUserid());
			logger.info("로그인 성공");
			pw.println("<script>alert('환영합니다.'); "
					+ "location.href='index';</script>");
			pw.flush();
		} else {
			logger.info("로그인 실패");
			pw.println("<script>alert('로그인 정보를 확인해주세요.'); "
					+ "location.href='login';</script>");
			pw.flush();
			
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
