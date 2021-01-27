package teamproject.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class SlideshowController {
	private static final Logger logger = LoggerFactory.getLogger(SlideshowController.class);

	// 카테고리별 TOP5 슬라이드쇼가 모두 다르므로 개별적으로 구분하여 작성
	// 이후에는 DB자체에서 개별 테이블 정보로 읽어서 GET을 하도록
	@GetMapping("/slideshow")
	public String indexSlideshow(Model model, HttpServletRequest request) {
		logger.info("실행");
		System.out.println("슬라이드쇼!!");
		String slidesDirPath = "/WEB-INF/resources/img/product/img/index/slides/";
		logger.info("request: " + request);


		File slides = new File(slidesDirPath);
		String[] slideList = slides.list();

		
		model.addAttribute("slideList", slideList);
		// 깃으로 공유 중이므로 파일은 resources/img에 보관
		
		return "products/slideshow";
	}
	
	@GetMapping("/outerslideshow")
	public String outerSlideshow(Model model, HttpServletRequest request) {
		logger.info("실행");
		System.out.println("슬라이드쇼!!");
		String slidesDirPath = "/WEB-INF/resources/img/product/img/outer/slides/";
		logger.info("request: " + request);


		File slides = new File(slidesDirPath);
		String[] slideList = slides.list();

		
		model.addAttribute("slideList", slideList);
		// 깃으로 공유 중이므로 파일은 resources/img에 보관
		
		return "products/outerslideshow";
	}
	
	@GetMapping("/pantsslideshow")
	public String pantsSlideshow(Model model, HttpServletRequest request) {
		logger.info("실행");
		System.out.println("슬라이드쇼!!");
		String slidesDirPath = "/WEB-INF/resources/img/product/img/pants/slides/";
		logger.info("request: " + request);


		File slides = new File(slidesDirPath);
		String[] slideList = slides.list();

		
		model.addAttribute("slideList", slideList);
		// 깃으로 공유 중이므로 파일은 resources/img에 보관
		
		return "products/pantsslideshow";
	}
	
	@GetMapping("/skirtslideshow")
	public String skirtSlideshow(Model model, HttpServletRequest request) {
		logger.info("실행");
		System.out.println("슬라이드쇼!!");
		String slidesDirPath = "/WEB-INF/resources/img/product/img/skirt/slides/";
		logger.info("request: " + request);


		File slides = new File(slidesDirPath);
		String[] slideList = slides.list();

		
		model.addAttribute("slideList", slideList);
		// 깃으로 공유 중이므로 파일은 resources/img에 보관
		
		return "products/skirtslideshow";
	}
	
	@GetMapping("/topslideshow")
	public String topSlideshow(Model model, HttpServletRequest request) {
		logger.info("실행");
		System.out.println("슬라이드쇼!!");
		String slidesDirPath = "/WEB-INF/resources/img/product/img/top/slides/";
		logger.info("request: " + request);


		File slides = new File(slidesDirPath);
		String[] slideList = slides.list();

		
		model.addAttribute("slideList", slideList);
		// 깃으로 공유 중이므로 파일은 resources/img에 보관
		
		return "products/topslideshow";
	}
}
