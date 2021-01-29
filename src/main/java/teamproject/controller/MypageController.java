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
@RequestMapping("/mypage")
public class MypageController {
	private static final Logger logger = LoggerFactory.getLogger(MypageController.class);
	
	@GetMapping("/orderlist")
	public String orderlist() {
		logger.info("orderlist 실행");
		return "mypage/orderlist";
	}
	
	@GetMapping("/reviewlist")
	public String reviewlist() {
		logger.info("reviewlist 실행");
		return "mypage/reviewlist";
	}
}
