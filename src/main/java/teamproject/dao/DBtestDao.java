package teamproject.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository
public class DBtestDao {
	
	@Resource
	private SqlSessionTemplate sst;

	public String selectOneTest() {
		String data = sst.selectOne("upcategory.selectOneTest");
		return data;
	}
	

}
