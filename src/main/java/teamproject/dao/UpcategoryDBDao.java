package teamproject.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UpcategoryDBDao {
	private static final Logger logger = LoggerFactory.getLogger(UpcategoryDBDao.class);

	@Resource
	private SqlSessionTemplate sst;

	public String getUpcategoryKrByEng(String upcategoryEng) {
		String upcategoryKr = sst.selectOne("upcategory.selectKrByEng", upcategoryEng);
		return upcategoryKr;
	}
}
