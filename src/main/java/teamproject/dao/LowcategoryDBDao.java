package teamproject.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import teamproject.dto.LowcategoryDB;

@Repository
public class LowcategoryDBDao {
	private static final Logger logger = LoggerFactory.getLogger(LowcategoryDBDao.class);
	
	@Resource
	private SqlSessionTemplate sst;

	public List<LowcategoryDB> selectAll() {
		
		List<LowcategoryDB> lowcategories = sst.selectList("lowactegory.selectAll");
		
		return lowcategories;
	}
	
	public List<LowcategoryDB> selectLowCategories() {
		List<LowcategoryDB> lowcategories = sst.selectList("lowcategory.selectLowsByUp");
		return lowcategories;
	}
	
	
}
