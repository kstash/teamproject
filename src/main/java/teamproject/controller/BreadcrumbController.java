package teamproject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import teamproject.dto.MenuData;

@Controller
@RequestMapping("/categoryDetail")
public class BreadcrumbController {
	private static final Logger logger = LoggerFactory.getLogger(BreadcrumbController.class);
	
	//breadcrumb.jsp실행
	@GetMapping("/breadcrumb")
	public String breadcrumb(Model model, HttpServletRequest request) {
		
		String target = request.getRequestURI();
		logger.warn(target);
		String upper = target.substring(36, target.lastIndexOf("/"));
		logger.warn(upper);
		String now = target.substring(target.lastIndexOf("/")+1, target.length()-4);
		logger.warn(now);
		//하위메뉴 전달
		String[] menuarr = MenuData.upperList(upper);
		String[] menuarrk = MenuData.upperListk(upper);
		String upperk = MenuData.upperK(upper);
		String nowk = MenuData.nowK(upper, now);
		
		List<MenuData> menuList = new ArrayList<>(); 
		
		for(int i=0 ; i<menuarr.length ; i++) {
			MenuData menu = new MenuData();
			menu.setLinkpart(menuarr[i]);
			menu.setKorean(menuarrk[i]);
			menuList.add(menu); 
		} 
		model.addAttribute("menuList", menuList);
		
		//현재 위치
		model.addAttribute("upper", upper);
		model.addAttribute("upperk", upperk);
		model.addAttribute("nowk", nowk);
		return "categoryDetail/breadcrumb";
	}


	
}
