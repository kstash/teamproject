package teamproject.controller;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import teamproject.dto.ProdimageDB;
import teamproject.service.ProdimageDBService;
@Controller
@RequestMapping("/products")
public class ProductListController {
	private static final Logger logger = LoggerFactory.getLogger(ProductListController.class);
	// 이미지 파일 읽어올때 1,2,3,...,9,10,11,... 에서 1,10,11,...,2,20,... 순으로 읽어옴.
	// --> 01,02,03...으로 이미지 파일 이름 수정
	
	@Resource
	private ProdimageDBService prodimageService; 
	
	@SuppressWarnings("null")
	@GetMapping("/productCardList")
	public void productList(Model model, String upcategoryeng, String lowcategoryeng) {
		logger.info("실행");
		
		model.addAttribute("upcategoryeng", upcategoryeng);
		model.addAttribute("lowcategoryeng", lowcategoryeng);

		String productImageDirPath = "C:/git/teamproject/WebContent/resources/img/product/";
		String productsPath = productImageDirPath+upcategoryeng+"/"+lowcategoryeng+"/";
		File prodImgDirPath = new File(productImageDirPath);
		
		File prodImgDirPath_up[] = new File(productImageDirPath+upcategoryeng+"/").listFiles();
		
		File prodImgDirPath_up_low[] = new File(productsPath).listFiles();
		String prodimagePath = upcategoryeng+"/"+lowcategoryeng+"/";
		logger.info("검색 경로: " + prodimagePath);
		List<ProdimageDB> prodimageList = prodimageService.selectByPath(prodimagePath);
		
		//list.jpg만
		List<ProdimageDB> prodimage_list = new ArrayList<ProdimageDB>();
		
		for(ProdimageDB prodimage : prodimageList) {
			/*
			 * logger.info(prodimage.getProdImageoname());
			 * logger.info(prodimage.getProdImagepath());
			 */
			logger.info(prodimage.getProdImageoname());
			String filename = prodimage.getProdImageoname();
			
			//String filewithnoextend = filename.substring(0, 5);
			
			if(filename.contains("list")) {
				prodimage_list.add(prodimage);
			}
		}
		model.addAttribute("prodimage_list", prodimage_list);
	}
	@GetMapping("/productRedir")
	public String productRedir() {
		//해당제품 상세 페이지로 이동
		return "redirect:/category/outer";
	}
}