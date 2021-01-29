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
/* 해당 AdminsController는 관리자용 페이지에서 사용될 수 있는 것들을 
 * 종합적으로 컨트롤 하는 곳 입니다.
 * 1. 카테고리(상위, 하위) 설정.
 * 2. 특정 (최소)하위 카테고리에 종속된 product 정보를 추가, 수정, 제거
 * 3.  
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
	
	//adminspage--관리 페이지
	@RequestMapping("/adminspage")
	public String adminspage(Model model) {
		
		//관리자 권한 체크 필수
		
		//관리자용 페이지 불러오기
		
		List<UpcategoryDB> upcategories =  upcategoryService.getUpCategories();
		List<LowcategoryDB> lowcategories =  lowcategoryService.getLowCategories();
		
		model.addAttribute("upcategories", upcategories);
		model.addAttribute("lowcategories", lowcategories);
		
		
		return "admins/adminspage";
	}
	
	@GetMapping("/choseUpCategory")
	public void	choseUpCategory(String chosenUpCategory, HttpServletResponse response, Model model) throws Exception {
		logger.info("choseupcategory");
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		JSONArray root = new JSONArray();
		List<LowcategoryDB> retrievedlowcategories =  lowcategoryService.getLowcategorylistEngByUpEng(chosenUpCategory);
		model.addAttribute("retrievedlowcategories", retrievedlowcategories);
		
		for(int i = 0; i < retrievedlowcategories.size(); i++) {
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
	public String requestImageFiles(MultipartHttpServletRequest request, String upcategoryEng) throws IllegalStateException, IOException {
		
		
		//상세 페이지 이미지들
		List<MultipartFile> imageFiles = request.getFiles("detailImages");
		String src = request.getParameter("");
		String path = "C:/git/teamproject/WebContent/resources/img/product/";
		
		for(MultipartFile mf : imageFiles) {
			String originalName = mf.getOriginalFilename();
			String savedFile = path + System.currentTimeMillis() + originalName;
			
			mf.transferTo(new File(savedFile));
		}
		
		return "redirect:/admins/adminspage";
	}
	
	//카테고리에 등록된 제품 테이블
	/*
	@GetMapping("/categoryInfoModal")
	public String categoryInfoModal(Model model) {
		model.addAttribute("")
		return "admins/categoryInfoModal";
	}
	*/
	
	//새로운 제품 등록
	@PostMapping("/postProduct")
	public void postProduct(ProductDB product, HttpServletRequest request, Model model) throws Exception {
		
		MultipartHttpServletRequest multipartrequest = (MultipartHttpServletRequest) request;
		long currentTime = System.currentTimeMillis();
		
		String path = "C:/git/teamproject/WebContent/resources/img/product/";
		String madeFolderPath = path + currentTime + "/";
		String originalName;
		String fileType;
		String savedFile;
		
		String lowcategoryEng = "outer";
		
		product.setProductCode(currentTime);
		product.setLowcategoryEng(lowcategoryEng);
		
		productService.insertProduct(product);
		
		/*
		상세 페이지 상세 이미지들
		prodimage가 insert되기전에 product를 먼저 생성해야함
		product/ 에 currentTime(숫자) 폴더명 만들고 거기 아래에 파일 저장
		eg)
		제품폴더 : 
			product/1611831882231/
		
		제품 상세 이미지 파일 : 
			product/1611831882231/1611831882231_0_originalName.jpg
			product/1611831882231/1611831882231_1_originalName.jpg
			product/1611831882231/1611831882231_2_originalName.jpg
			product/1611831882231/1611831882231_3_originalName.jpg
			product/1611831882231/1611831882231_4_originalName.jpg
			product/1611831882231/1611831882231_5_originalName.jpg
		제품 상세 이미지 파일 : 
			product/1611831882231/list.jpg
		제품 상세 이미지 파일 : 
			product/1611831882231/main.jpg
		*/
		
		MultipartFile productMainImageFile = multipartrequest.getFile("productMainImageFile");
		ProdimageDB prodMainImage = new ProdimageDB();
		originalName = productMainImageFile.getOriginalFilename();
		int beginIndexMainImageName = originalName.indexOf("."); 
		int endIndexMainImageName = originalName.length();
		String contentTypeStrMainImage = originalName.substring(beginIndexMainImageName, endIndexMainImageName); //기댓값 : ".jpg"
		
		prodMainImage.setProdImageoname("list" + contentTypeStrMainImage); //기댓값 : list.jpg
		prodMainImage.setProdImagepath(madeFolderPath);
		prodMainImage.setProdImagetype(productMainImageFile.getContentType());
		prodMainImage.setProductCode(currentTime);
		
		productMainImageFile.transferTo(new File(madeFolderPath+"list"+contentTypeStrMainImage));
		prodimageService.insertProdImage(prodMainImage);

		
		
		MultipartFile productListImageFile = multipartrequest.getFile("productListImageFile");
		ProdimageDB prodListImage = new ProdimageDB();
		originalName = productListImageFile.getOriginalFilename();
		int beginIndexListImageName = originalName.indexOf("."); 
		int endIndexListImageName = originalName.length();
		String contentTypeStrListImage = originalName.substring(beginIndexListImageName, endIndexListImageName); //기댓값 : ".jpg"
		
		prodListImage.setProdImageoname("main" + contentTypeStrListImage); //기댓값 : main.jpg
		prodListImage.setProdImagepath(madeFolderPath+"/");
		prodListImage.setProdImagetype(productListImageFile.getContentType());
		prodListImage.setProductCode(currentTime);
		
		productListImageFile.transferTo(new File(madeFolderPath+"main"+contentTypeStrListImage));
		prodimageService.insertProdImage(prodListImage);
		
		
		
		List<MultipartFile> detailImages = multipartrequest.getFiles("detailImages");
		if(!detailImages.isEmpty()) {
			int iterationCode = 0;
			for(MultipartFile mf : detailImages) {
				ProdimageDB prodimageDetail = new ProdimageDB();
				
				originalName = mf.getOriginalFilename();
				savedFile = madeFolderPath + (currentTime + "_" + iterationCode + "_" + originalName);
				iterationCode++;
				fileType = mf.getContentType();
				
				mf.transferTo(new File(savedFile));
				
				prodimageDetail.setProdImageoname(originalName);
				prodimageDetail.setProdImagepath(madeFolderPath);
				prodimageDetail.setProdImagetype(fileType);
				prodimageDetail.setProductCode(currentTime);
				
				prodimageService.insertProdImage(prodimageDetail);
			}
		}
	}
	
	@PostMapping("/postProdimg")
	public String postProdimg() {
		
		
		return "redirect:/admins/adminspage";
	}
	
	
	
	@GetMapping("/getProducts")
	public void getProducts() {
		
	}
	
}
