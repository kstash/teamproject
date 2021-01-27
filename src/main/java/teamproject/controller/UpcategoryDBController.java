package teamproject.controller;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import teamproject.service.UpcategoryDBService;

@Controller
public class UpcategoryDBController {
	
	@Resource
	private DataSource dataSource;
	
	@Resource
	private UpcategoryDBService dbService;
	
	@RequestMapping("/dbtest")
	public String dbtest(Model model) {
		String upcategoryKr = dbService.getDatatest();
		model.addAttribute("upcategoryKr",upcategoryKr);
		return "dbtest";
	}
}
