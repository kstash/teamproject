package teamproject.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import teamproject.dto.ProductDB;
import teamproject.service.rightsearchService;

@Controller
public class rightsearchController {
	@Resource
	private rightsearchService rightsearchService;
	//경로 설정 다시 보기
	@GetMapping("/")
	public String rightsearch(ProductDB productDb) {
		rightsearchService.search();
		return "rightsearchDetail";
	}
}
