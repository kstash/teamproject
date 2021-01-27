package teamproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping("/")
	public String index() {
		logger.info("homepage");
		return "index";
	}
	//왼쪽영역
	@RequestMapping("/cart")
	public String cart() {
		logger.info("장바구니 페이지");

		return "leftArea/cart";
	}
	
	//오른쪽영역
	@RequestMapping("/menusearch")
	public String menusearch() {
		logger.info("로그인 페이지");

		return "rightArea/menusearch";
	}
	
	@RequestMapping("/login")
	public String login() {
		logger.info("로그인 페이지");

		return "login/login";
	}
	
	@RequestMapping("/mypage")
	public String mypage() {
		logger.info("마이페이지 페이지");

		return "mypage/mypage";
	}
	
	@RequestMapping("/language")
	public String language() {
		logger.info("마이페이지 페이지");

		return "rightArea/language";
	}
	
}
