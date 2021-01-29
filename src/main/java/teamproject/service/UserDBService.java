package teamproject.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import teamproject.dao.UserDBDao;
import teamproject.dto.UserDB;

@Service
public class UserDBService {
	private static final Logger logger = 
			LoggerFactory.getLogger(UserDBService.class);
	
	@Resource
	private UserDBDao userDao;
	
	public void signup(UserDB userDB) {
		userDao.insert(userDB);
	}

	public String login(UserDB userDB) {
		UserDB dbUser = userDao.loginSelect(userDB.getUserid());
		logger.info("UserDBService.login()실행");
		if(dbUser == null) {
			logger.info("UserDBService.login()실행, wrongUserid");
			return "wrongUserid";
		} else if(dbUser.getUserpw().equals(userDB.getUserpw())) {
			//아이디 기억하기
			
			logger.info("UserDBService.login()실행, success");
			return "success";
		} else {
			logger.info("UserDBService.login()실행, wrongUserpw");
			return "wrongUserpw";
		}
	}
}
