package teamproject.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository
public class UpcategoryDBDao {
	
	@Resource
	private SqlSessionTemplate sst;

	public String selectOneTest() {
		String upcategoryKr = sst.selectOne("upcategory.selectOneTest");
		return upcategoryKr;
	}
	

}
