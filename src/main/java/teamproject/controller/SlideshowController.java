package teamproject.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import teamproject.dto.ProdimageDB;
import teamproject.dto.ProductDB;
import teamproject.dto.ProductInfoList;
import teamproject.dto.StockDB;
import teamproject.service.ProdimageDBService;
import teamproject.service.ProductDBService;
import teamproject.service.StockDBService;

@Controller
@RequestMapping("/products")
public class SlideshowController {
	private static final Logger logger = LoggerFactory.getLogger(SlideshowController.class);
	
	@Resource
	private ProdimageDBService prodimageService;
	
	@Resource
	private ProductDBService productService;
	
	@Resource
	private StockDBService stockService;
	
	// 카테고리별 TOP5 슬라이드쇼가 모두 다르므로 개별적으로 구분하여 작성
	// 이후에는 DB자체에서 개별 테이블 정보로 읽어서 GET을 하도록
	@GetMapping("/slideshow")
	public String indexSlideshow(Model model, String upcategoryeng) {
		logger.info("실행");
		
		List<ProductInfoList> slideinfoList = new ArrayList<ProductInfoList>();
		
		String uppath = "/WEB-INF/resources/img/product/"+upcategoryeng+"/";
		
		//상위 카테고리가 아우터(outer)일때, 코트, 자켓, 퍼자켓, 가죽자켓, 가디건, 점퍼가 있으니까
		//각각의 하위 카테고리가 가지고 있는 아이템 하나씩을 가져와 슬라이드로 사용.		
		
		File up = new File(uppath);
		String[] lows = up.list();
		
		for(String low : lows) {
			//하위카테고리 한 개를 의미하는 low
			ProductInfoList slideinfo = new ProductInfoList();
			long productCode = Long.parseLong(low);
			ProductDB product = productService.getProductByPd(productCode);
			slideinfo.setProductdb(product);
			
			List<StockDB> stock = stockService.getStocklistByPd(productCode);
			slideinfo.setStockdb(stock);
			
			List<ProdimageDB> prodimage = prodimageService.selectByCode(productCode);
			for(ProdimageDB image : prodimage) {
				if(image.getProdImageoname().contains("main")) {
					slideinfo.setProdimgdb(image);
				}
			}
			
		}
		
		model.addAttribute("slideinfoList", slideinfoList);
		
		return "products/slideshow";
	}
}
