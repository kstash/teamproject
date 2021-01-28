package teamproject.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import teamproject.dto.UserDB;
import teamproject.service.UserDBService;

@Controller
public class UserDBController {

	@Resource
	private UserDBService userDBService;
	
	@PostMapping("/signup")
	public String signup(UserDB userDB) {
		userDBService.signup(userDB);
		return "redirect:/";
	} 
}
