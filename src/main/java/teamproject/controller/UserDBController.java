package teamproject.controller;

import org.springframework.web.bind.annotation.PostMapping;

import teamproject.dto.UserDB;

public class UserDBController {

	@PostMapping("/signup")
	public String signup(UserDB userDB) {
		
		
		return "/";
	} 
}
