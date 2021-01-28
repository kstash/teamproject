package teamproject.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import teamproject.dto.LowcategoryDB;
import teamproject.dto.ProductDB;
import teamproject.dto.UpcategoryDB;
import teamproject.service.LowcategoryDBService;
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
	
	//adminspage--관리 페이지
	@GetMapping("/adminspage")
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
	}
		
	@PostMapping("/choseLowCategory")
	public void choseLowCategory(String chosenLowCategory, Model model) {
		
	}
	
	@PostMapping(value = "requestImageFiles")
	public String requestImageFiles(MultipartHttpServletRequest request, String upcategoryEng) throws IllegalStateException, IOException {
		
		
		//상세 페이지 이미지들
		List<MultipartFile> imageFiles = request.getFiles("file");
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
	@PostMapping("/newProduct")
	public String newProduct() {
		
		return "redirect:/admins/adminspage";
	}
}
