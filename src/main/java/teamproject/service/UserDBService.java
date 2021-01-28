package teamproject.service;

import javax.annotation.Resource;

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

}
