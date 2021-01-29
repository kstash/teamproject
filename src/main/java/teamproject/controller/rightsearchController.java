package teamproject.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import teamproject.dto.ProductDB;
import teamproject.service.ProductDBService;

@Controller
public class rightsearchController {
	/*private static final Logger logger = 
			LoggerFactory.getLogger(rightsearchController.class);
	
	@Resource
	private ProductDBService productService;
	
	//경로 설정 !! , 어디서든 가능하게
	@GetMapping("/rightmenu")
	public void rightsearch(String searchKeyword, ProductDB product) {
		logger.info("rightsearch() 실행");
		logger.info(searchKeyword);
		productService.search(product);
	}*/
}
