package teamproject.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.core.compiler.CategorizedProblem;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import teamproject.dto.LowcategoryDB;
import teamproject.dto.ProdimageDB;
import teamproject.dto.ProductDB;
import teamproject.dto.UpcategoryDB;
import teamproject.service.LowcategoryDBService;
import teamproject.service.ProdimageDBService;
import teamproject.service.ProductDBService;
import teamproject.service.UpcategoryDBService;

@Controller
@RequestMapping("/admins")
public class AdminsController {
	/*
	 * 해당 AdminsController는 관리자용 페이지에서 사용될 수 있는 것들을 종합적으로 컨트롤 하는 곳 입니다. 1. 카테고리(상위,
	 * 하위) 설정. 2. 특정 (최소)하위 카테고리에 종속된 product 정보를 추가, 수정, 제거 3.
	 */
	private static final Logger logger = LoggerFactory.getLogger(AdminsController.class);

	@Resource
	private ProductDBService productService;

	@Resource
	private UpcategoryDBService upcategoryService;

	@Resource
	private LowcategoryDBService lowcategoryService;

	@Resource
	private ProdimageDBService prodimageService;

	// adminspage--관리 페이지
	@RequestMapping("/adminspage")
	public String adminspage(Model model) {

		// 관리자 권한 체크 필수

		// 관리자용 페이지 불러오기

		List<UpcategoryDB> upcategories = upcategoryService.getUpCategories();
		List<LowcategoryDB> lowcategories = lowcategoryService.getLowCategories();

		model.addAttribute("upcategories", upcategories);
		model.addAttribute("lowcategories", lowcategories);

		return "admins/adminspage";
	}

	@GetMapping("/choseUpCategory")
	public void choseUpCategory(String chosenUpCategory, HttpServletResponse response, Model model) throws Exception {
		logger.info("choseupcategory");
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		JSONArray root = new JSONArray();
		List<LowcategoryDB> retrievedlowcategories = lowcategoryService.getLowcategorylistEngByUpEng(chosenUpCategory);
		model.addAttribute("retrievedlowcategories", retrievedlowcategories);

		for (int i = 0; i < retrievedlowcategories.size(); i++) {
			JSONObject lowcategory = new JSONObject();
			lowcategory.put("lowcategoryKr", retrievedlowcategories.get(i));
			root.put(lowcategory);
		}
		String json = root.toString();
		pw.println(json);
		pw.flush();
		pw.close();
	}

	@PostMapping("/choseLowCategory")
	public void choseLowCategory(String chosenLowCategory, Model model) {

	}

	@PostMapping("/requestImageFiles")
	public String requestImageFiles(MultipartHttpServletRequest request, String upcategoryEng)
			throws IllegalStateException, IOException {

		// 상세 페이지 이미지들
		List<MultipartFile> imageFiles = request.getFiles("detailImages");
		String src = request.getParameter("");
		String path = "C:/git/teamproject/WebContent/resources/img/product/";

		for (MultipartFile mf : imageFiles) {
			String originalName = mf.getOriginalFilename();
			String savedFile = path + System.currentTimeMillis() + originalName;

			mf.transferTo(new File(savedFile));
		}

		return "redirect:/admins/adminspage";
	}

	// 카테고리에 등록된 제품 테이블
	/*
	 * @GetMapping("/categoryInfoModal") public String categoryInfoModal(Model
	 * model) { model.addAttribute("") return "admins/categoryInfoModal"; }
	 */

	// 새로운 제품 등록
	@PostMapping("/postProduct")
	public String postProduct(String lowcategoryEng, String productName, String productDesc, String productFabric, int productPrice, MultipartFile prodImageattachList,
			MultipartFile prodImageattachMain, List<MultipartFile> prodImageattachDetail, ProdimageDB prodImage, ProductDB product, Model model) throws Exception, IOException {
		logger.info("postProduct 실행");
		String upcategoryeng = lowcategoryService.getUpEngByLowEng(lowcategoryEng);
		model.addAttribute("upcateogryeng", upcategoryeng);
		logger.info("upcategoryEng: " + upcategoryeng);
		
		String defaultSavePath = "C:/git/teamproject/WebContent/resources/img/product/";
		
		long productCode = System.currentTimeMillis();
		
		// 제품정보
		logger.info("lowcategoryEng: " + lowcategoryEng);
		logger.info("name: " + productName);
		logger.info("desc: " + productDesc);
		logger.info("fabric: " + productFabric);
		logger.info("price: " + productPrice);
		
		product.setProductCode(productCode);
		product.setProductName(productName);
		product.setProductDesc(productDesc);
		product.setProductFabric(productFabric);
		product.setProductPrice(productPrice);
		product.setLowcategoryEng(lowcategoryEng);

		productService.insertProduct(product);
		String fullSavePath = defaultSavePath + upcategoryeng + "/" + lowcategoryEng + "/" + productCode + "/";

		// 제품리스트이미지
		logger.info("prodImageattachList: " + prodImageattachList.getName());
		logger.info("prodImageattachList: " + prodImageattachList.getContentType());
		logger.info("prodImageattachList: " + prodImageattachList.getOriginalFilename());
		
		String strFileType = prodImageattachList.getOriginalFilename().substring(prodImageattachList.getOriginalFilename().indexOf('.'));//.jpg
		prodImageattachList.transferTo(new File(fullSavePath+"list"+strFileType));
		
		prodImage.setProductCode(productCode);
		prodImage.setProdImagetype(prodImageattachList.getContentType());
		prodImage.setProdImageoname("list" + strFileType);
		prodImage.setProdImagepath(upcategoryeng+"/"+lowcategoryEng+"/");
		
		prodimageService.insertProdImage(prodImage);
		
		
		// 제품메인이미지
		logger.info("prodImageattachMain: " + prodImageattachMain.getName());
		logger.info("prodImageattachMain: " + prodImageattachMain.getContentType());
		logger.info("prodImageattachMain: " + "main"+prodImageattachMain.getOriginalFilename());
		
		strFileType = prodImageattachMain.getOriginalFilename().substring(prodImageattachMain.getOriginalFilename().indexOf('.'));//.jpg
		prodImageattachMain.transferTo(new File(fullSavePath+"main"+strFileType));
		
		prodImage.setProductCode(productCode);
		prodImage.setProdImagetype(prodImageattachMain.getContentType());
		prodImage.setProdImageoname("main" + strFileType);
		prodImage.setProdImagepath(upcategoryeng+"/"+lowcategoryEng+"/");
		
		prodimageService.insertProdImage(prodImage);
		
		
		// 제품상세이미지들
		int i = 1;
		for (MultipartFile detailImage : prodImageattachDetail) {
			logger.info("prodImageattachDetail: " + detailImage.getName());
			logger.info("prodImageattachDetail: " + detailImage.getContentType());
			logger.info("prodImageattachDetail: " + detailImage.getOriginalFilename());
			prodImage.setProductCode(productCode);
			prodImage.setProdImagetype(detailImage.getContentType());
			prodImage.setProdImageoname(i+"_"+detailImage.getOriginalFilename());
			
			prodImage.setProdImagepath(upcategoryeng+"/"+lowcategoryEng+"/");
			
			strFileType = detailImage.getOriginalFilename().substring(detailImage.getOriginalFilename().indexOf('.'));
			detailImage.transferTo(new File(fullSavePath + i + "_" + detailImage.getOriginalFilename()));
			prodimageService.insertProdImage(prodImage);
			i++;
		}
		
		return "redirect:/admins/adminspage";
	}

	@GetMapping("getLowcategories")
	public void getLowcategories(Model model, HttpServletRequest request) {
		String upcategoryeng = request.getAttribute("#FormControlSelectUpCategory").toString();
		List<LowcategoryDB> confirmedLowcategories = lowcategoryService.getLowcategorylistAllByUpEng(upcategoryeng);
		model.addAttribute("confirmedLowcategories",confirmedLowcategories);
	}
	
	@GetMapping("lowcategorySelect")
	public String lowcategorySelect(String upcategoryeng, Model model) {
		logger.info("실행");
		List<LowcategoryDB> confirmedLowcategories = lowcategoryService.getLowcategorylistAllByUpEng(upcategoryeng);
		model.addAttribute("confirmedLowcategories",confirmedLowcategories);
		logger.info("upcategoryEng: " + upcategoryeng);
		logger.info(confirmedLowcategories.size()+"");
		logger.info("confirmedLowcategories: " + confirmedLowcategories);
		return "admins/lowcategorySelect";
	}
	
	@GetMapping("postProductForm")
	public String postProductForm(String lowcategoryeng, Model model) {
		logger.info("lowcategoryeng: " + lowcategoryeng);
				
		model.addAttribute("lowcategoryeng", lowcategoryeng);
		
		return "admins/postProductForm";
	}

	@GetMapping("/getProducts")
	public void getProducts() {

	}
	@GetMapping("/stock")
	public String adminstock(long productcode, Model model) {
		logger.info("실행");
		//parameter 테스트를 위한 model
		model.addAttribute("productCode", productcode);
		//이후에 제작할 재고관리 페이지
		return "admins/stock";
	}

}
