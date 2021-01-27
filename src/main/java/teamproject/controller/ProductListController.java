package teamproject.controller;
import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/productll")
public class ProductListController {
	private static final Logger logger = LoggerFactory.getLogger(ProductListController.class);
	// 이미지 파일 읽어올때 1,2,3,...,9,10,11,... 에서 1,10,11,...,2,20,... 순으로 읽어옴.
	// --> 01,02,03...으로 이미지 파일 이름 수정
	
	@GetMapping("/productCardList")
	public String productList(Model model) {
		logger.info("실행");
		String productImageDirPath = "C:/git/teamproject/WebContent/resources/img/product/img/index/products/";
		File prodImgDirPath = new File(productImageDirPath);
		String[] products = prodImgDirPath.list();
		for(int i = 0; i < products.length; i++) {
			//홈페이지로 (index.jsp) 잡아놨음
			products[i] = "/teamproject/resources/img/product/img/index/products/" + products[i];
		}
		//JSP 파일별로 불러와야 하는 이미지가 다르기 때문에 해당 카테고리의 products 경로를 붙여놓은 String으로 보내기.
		model.addAttribute("products", products);
		return "products/productCardList";
	}
	@GetMapping("/productRedir")
	public String productRedir() {
		//해당제품 상세 페이지로 이동
		return "redirect:/category/outer";
	}
}