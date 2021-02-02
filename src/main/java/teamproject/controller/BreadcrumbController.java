package teamproject.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import teamproject.dto.LowcategoryDB;
import teamproject.service.LowcategoryDBService;
import teamproject.service.UpcategoryDBService;

@Controller
@RequestMapping("/categoryDetail")
public class BreadcrumbController {
	private static final Logger logger = LoggerFactory.getLogger(BreadcrumbController.class);
	
	@Resource
	private DataSource dataSource;
	
	@Resource
	private UpcategoryDBService upcategorydbService;
	
	@Resource
	private LowcategoryDBService lowcategorydbService;
	
	//breadcrumb.jsp실행
	@GetMapping("/breadcrumb")
	public String breadcrumb(Model model, String upcategoryeng, String lowcategoryeng) {
		
		//upEng->upKr
		String upcategoryKr = upcategorydbService.getUpcategoryKrByEng(upcategoryeng);
		//upEng->lowlistDTO
		List<LowcategoryDB> lowcategorylist = lowcategorydbService.getLowcategorylistEngByUpEng(upcategoryeng);
		
		model.addAttribute("upcategoryeng",upcategoryeng);
		model.addAttribute("upcategoryKr",upcategoryKr);
		model.addAttribute("lowcategorylist",lowcategorylist);
		
		if(lowcategoryeng.equals("")) {
			//lowEng = null ~> upKr -> lowKr
			model.addAttribute("lowcategoryKr",upcategoryKr);
		}else {
			//lowEng -> lowKR
			logger.info(lowcategorylist.size()+"");
			for(LowcategoryDB item : lowcategorylist) {
				if(item.getLowcategoryEng().equals(lowcategoryeng)) {
					model.addAttribute("lowcategoryKr",item.getLowcategoryKr());
				}
			}
		}
		
		
		
		return "categoryDetail/breadcrumb";
	}


	
}
