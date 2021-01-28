package teamproject.dao;

public class UserDBDao {
import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import teamproject.dto.UserDB;

@Repository
public class UserDBDao {
	private static final Logger logger = 
			LoggerFactory.getLogger(UserDBDao.class);

	@Resource
	private SqlSessionTemplate sst;
	
	public int insert(UserDB userDB) {
		int rows = sst.insert("user.insert",userDB);
		return rows;
	}

	public UserDB loginSelect(String userid) {
		logger.info("UserDao.loginSelect() 실행");
		UserDB userDB = sst.selectOne("user.loginSelect",userid);
		return userDB;
	}

}
