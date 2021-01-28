package teamproject.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import teamproject.dto.LowcategoryDB;
import teamproject.dto.UpcategoryDB;
import teamproject.service.LowcategoryDBService;
import teamproject.service.UpcategoryDBService;

@Controller
public class IndexController {
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Resource
	private UpcategoryDBService upcategoryService;
	@Resource
	private LowcategoryDBService lowcategoryService;
	
	@RequestMapping("/")
	public String index() {
		logger.info("homepage");
		return "index";
	}
	//왼쪽영역
	@RequestMapping("/cart")
	public String cart() {
		logger.info("장바구니 페이지");

		return "cart/cart";
	}
	
	//오른쪽영역
	@RequestMapping("/rightmenu")
	public String menusearch() {
		logger.info("rightmenu 페이지");

		return "rightmenu/rightmenu";
	}
	
	@RequestMapping("/rightsearch")
	public String rightsearch() {
		logger.info("rightsearch");

		return "rightsearch/rightsearch";
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
		logger.info("랭귀지");

		return "rightmenu/language";
	}
	@RequestMapping("/header")
	public String headermenu(Model model) {
		logger.info("문제가 뭐야");
		List<UpcategoryDB> upcategories =  upcategoryService.getUpCategories();
		List<LowcategoryDB> lowcategories =  lowcategoryService.getLowCategories();
		model.addAttribute("upcategories", upcategories);
		model.addAttribute("lowcategories", lowcategories);
		
		return "include/header";
	}
	
}
