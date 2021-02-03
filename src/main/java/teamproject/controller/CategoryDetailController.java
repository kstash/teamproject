package teamproject.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryDetailController {
	private static final Logger logger = LoggerFactory.getLogger(CategoryDetailController.class);
	
	/* 아우터 */	
	@RequestMapping("/outer")
	public String outer() {
		logger.info("아우터 실행");
		return "category/outer/index";
	}
	
	@RequestMapping("/outer/*")
	public String outerCardigan(HttpServletRequest request) {
		String target= request.getRequestURI();
		String end= target.substring(target.lastIndexOf("/")+1);
		logger.info("아우터-" + end + "실행");
		return "category/outer/"+end;
	}

	//call parameter category page
	@GetMapping("/")
	public String callcategorypage(Model model, String upcategoryeng, String lowcategoryeng) {
		logger.info("실행");
		
		logger.info("lowcategoryeng값: "+lowcategoryeng);
		
		if(upcategoryeng != null && lowcategoryeng == null) {
			model.addAttribute("upcategoryeng", upcategoryeng);
			return "categoryDetail/up";
		} else {
			model.addAttribute("upcategoryeng", upcategoryeng);
			model.addAttribute("lowcategoryeng", lowcategoryeng);
			
			return "categoryDetail/index";
		}
		
		
		
	}
}