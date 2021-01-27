package teamproject.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UpcategoryDBDao {
	private static final Logger logger = LoggerFactory.getLogger(UpcategoryDBDao.class);

	@Resource
	private SqlSessionTemplate sst;
}
