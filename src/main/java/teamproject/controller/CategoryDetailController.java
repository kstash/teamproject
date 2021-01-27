package teamproject.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
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
	
	
	/* 팬츠 */
	@RequestMapping("/pants")
	public String pants() {
		logger.info("팬츠 실행");
		return "category/pants/index";
	}
	@RequestMapping("/pants/*")
	public String pantsunder(HttpServletRequest request) {
		
		String target= request.getRequestURI();
		String end= target.substring(target.lastIndexOf("/")+1);
		logger.info("팬츠-" + end + "실행");
		return "category/pants/"+end;
	}
	
	
	/* 스커트 */
	@RequestMapping("/skirt")
	public String skirt() {
		logger.info("스커트 실행");
		return "category/skirt/index";
	}
	
	@RequestMapping("/skirt/*")
	public String skirtunder(HttpServletRequest request) {
		String target= request.getRequestURI();
		String end= target.substring(target.lastIndexOf("/")+1);
		logger.info("스커트-"+ end + "실행");
		return "category/skirt/"+ end;
	}

	
	
	/* 탑 */
	@RequestMapping("/top")
	public String top() {
		logger.info("탑 실행");
		return "category/top/index";
	}
	
	@RequestMapping("/top/*")
	public String topunder(HttpServletRequest request) {
		String target= request.getRequestURI();
		String end= target.substring(target.lastIndexOf("/")+1);
		logger.info("탑-"+ end + "실행");
		return "category/top/"+ end;
	}
}