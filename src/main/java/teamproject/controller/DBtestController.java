package teamproject.controller;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import teamproject.service.DBtestService;

@Controller
public class DBtestController {
	
	@Resource
	private DataSource dataSource;
	
	@Resource
	private DBtestService dbService;
	
	@RequestMapping("/test")
	public String dbtest(Model model) {
		String data = dbService.getDatatest();
		model.addAttribute("data",data);
		return "test";
	}
}
