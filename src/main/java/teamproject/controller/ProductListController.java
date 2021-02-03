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
import teamproject.dto.ProductDB;
import teamproject.dto.ProductInfoList;
import teamproject.dto.StockDB;
import teamproject.service.ProdimageDBService;
import teamproject.service.ProductDBService;
import teamproject.service.StockDBService;
@Controller
@RequestMapping("/products")
public class ProductListController {
	private static final Logger logger = LoggerFactory.getLogger(ProductListController.class);
	// 이미지 파일 읽어올때 1,2,3,...,9,10,11,... 에서 1,10,11,...,2,20,... 순으로 읽어옴.
	// --> 01,02,03...으로 이미지 파일 이름 수정
	
	@Resource
	private ProdimageDBService prodimageService; 
	
	@Resource
	private ProductDBService productService;
	
	@Resource
	private StockDBService stockService;
	
	@SuppressWarnings("null")
	@GetMapping("/productCardList")
	public void productList(Model model, String upcategoryeng, String lowcategoryeng) {
		logger.info("실행");
		
		model.addAttribute("upcategoryeng", upcategoryeng);
		model.addAttribute("lowcategoryeng", lowcategoryeng);
		
		//list.jpg만
		List<ProductInfoList> productinfoList = new ArrayList<ProductInfoList>();
		
		List<ProductDB> productList = productService.getProductsByLowCategory(lowcategoryeng);
		
		for(ProductDB product : productList) {
			long productCode = product.getProductCode();
			
			//해당 제품의 이미지들 불러오기
			List<ProdimageDB> prodimageList = prodimageService.selectByCode(productCode);
			List<StockDB> stockList = stockService.getStocklistByPd(productCode);
			
			for(ProdimageDB prodimage : prodimageList) {
				String filename = prodimage.getProdImageoname();
				
				//해당 제품의 이미지들중 리스트용 이미지 사용하기 위해서 저장해두기 (리스트 페이지에서 뿌려주는거라)
				if(filename.contains("list")) {
					ProductInfoList productInfo = new ProductInfoList();
					productInfo.setProdimgdb(prodimage);
					productInfo.setProductdb(product);
					productInfo.setStockdb(stockList);
					productinfoList.add(productInfo);
				}
			}
			
		}
		model.addAttribute("productinfoList", productinfoList);
	}
	
	@GetMapping("/upcategoryCardList")
	public void upcategoryCardList(Model model, String upcategoryeng) {
		logger.info("실행");
		
		model.addAttribute("upcategoryeng", upcategoryeng);
		
		//list.jpg만
		List<ProductInfoList> productinfoList = new ArrayList<ProductInfoList>();
		
		List<ProductDB> productList = productService.getEveryProductByUp(upcategoryeng);
		
		for(ProductDB product : productList) {
			long productCode = product.getProductCode();
			
			//해당 제품의 이미지들 불러오기
			List<ProdimageDB> prodimageList = prodimageService.selectByCode(productCode);
			List<StockDB> stockList = stockService.getStocklistByPd(productCode);
			
			for(ProdimageDB prodimage : prodimageList) {
				String filename = prodimage.getProdImageoname();
				
				//해당 제품의 이미지들중 리스트용 이미지 사용하기 위해서 저장해두기 (리스트 페이지에서 뿌려주는거라)
				if(filename.contains("list")) {
					ProductInfoList productInfo = new ProductInfoList();
					productInfo.setProdimgdb(prodimage);
					productInfo.setProductdb(product);
					productInfo.setStockdb(stockList);
					productinfoList.add(productInfo);
				}
			}
			
		}
		model.addAttribute("productinfoList", productinfoList);
	}
	@GetMapping("/productRedir")
	public String productRedir() {
		//해당제품 상세 페이지로 이동
		return "redirect:/category/outer";
	}
	@GetMapping("/sortbylowprice")
	public String sortbylowprice(Model model, String upcategoryeng, String lowcategoryeng) {
		logger.info("실행");
		
		model.addAttribute("upcategoryeng", upcategoryeng);
		model.addAttribute("lowcategoryeng", lowcategoryeng);
		
		//list.jpg만
		List<ProductInfoList> productinfoList = new ArrayList<ProductInfoList>();
		
		List<ProductDB> productList = productService.getProductsByLowCategory_sortbylowprice(lowcategoryeng);
		
		for(ProductDB product : productList) {
			long productCode = product.getProductCode();
			
			//해당 제품의 이미지들 불러오기
			List<ProdimageDB> prodimageList = prodimageService.selectByCode(productCode);
			List<StockDB> stockList = stockService.getStocklistByPd(productCode);
			
			for(ProdimageDB prodimage : prodimageList) {
				String filename = prodimage.getProdImageoname();
				
				//해당 제품의 이미지들중 리스트용 이미지 사용하기 위해서 저장해두기 (리스트 페이지에서 뿌려주는거라)
				if(filename.contains("list")) {
					ProductInfoList productInfo = new ProductInfoList();
					productInfo.setProdimgdb(prodimage);
					productInfo.setProductdb(product);
					productInfo.setStockdb(stockList);
					productinfoList.add(productInfo);
				}
			}
			
		}
		model.addAttribute("productinfoList", productinfoList);
		return "products/productCardList";
	}
	@GetMapping("/sortbyhighprice")
	public String sortbyhighprice(Model model, String upcategoryeng, String lowcategoryeng) {
		logger.info("실행");
		
		model.addAttribute("upcategoryeng", upcategoryeng);
		model.addAttribute("lowcategoryeng", lowcategoryeng);
		
		//list.jpg만
		List<ProductInfoList> productinfoList = new ArrayList<ProductInfoList>();
		
		List<ProductDB> productList = productService.getProductsByLowCategory_sortbyhighprice(lowcategoryeng);
		
		for(ProductDB product : productList) {
			long productCode = product.getProductCode();
			
			//해당 제품의 이미지들 불러오기
			List<ProdimageDB> prodimageList = prodimageService.selectByCode(productCode);
			List<StockDB> stockList = stockService.getStocklistByPd(productCode);
			
			for(ProdimageDB prodimage : prodimageList) {
				String filename = prodimage.getProdImageoname();
				
				//해당 제품의 이미지들중 리스트용 이미지 사용하기 위해서 저장해두기 (리스트 페이지에서 뿌려주는거라)
				if(filename.contains("list")) {
					ProductInfoList productInfo = new ProductInfoList();
					productInfo.setProdimgdb(prodimage);
					productInfo.setProductdb(product);
					productInfo.setStockdb(stockList);
					productinfoList.add(productInfo);
				}
			}
			
		}
		model.addAttribute("productinfoList", productinfoList);
		return "products/productCardList";
	}
	@GetMapping("/sortbyname")
	public String sortbyname(Model model, String upcategoryeng, String lowcategoryeng) {
		logger.info("실행");
		
		model.addAttribute("upcategoryeng", upcategoryeng);
		model.addAttribute("lowcategoryeng", lowcategoryeng);
		
		//list.jpg만
		List<ProductInfoList> productinfoList = new ArrayList<ProductInfoList>();
		
		List<ProductDB> productList = productService.getProductsByLowCategory_sortbyname(lowcategoryeng);
		
		for(ProductDB product : productList) {
			long productCode = product.getProductCode();
			
			//해당 제품의 이미지들 불러오기
			List<ProdimageDB> prodimageList = prodimageService.selectByCode(productCode);
			List<StockDB> stockList = stockService.getStocklistByPd(productCode);
			
			for(ProdimageDB prodimage : prodimageList) {
				String filename = prodimage.getProdImageoname();
				
				//해당 제품의 이미지들중 리스트용 이미지 사용하기 위해서 저장해두기 (리스트 페이지에서 뿌려주는거라)
				if(filename.contains("list")) {
					ProductInfoList productInfo = new ProductInfoList();
					productInfo.setProdimgdb(prodimage);
					productInfo.setProductdb(product);
					productInfo.setStockdb(stockList);
					productinfoList.add(productInfo);
				}
			}
			
		}
		model.addAttribute("productinfoList", productinfoList);
		return "products/productCardList";
	}
}
