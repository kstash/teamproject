package teamproject.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import teamproject.controller.AdminsController;
import teamproject.dto.LowcategoryDB;

@Repository
public class LowcategoryDBDao {
	private static final Logger logger = LoggerFactory.getLogger(LowcategoryDBDao.class);

	@Resource
	private SqlSessionTemplate sst;

	public List<LowcategoryDB> getLowCategories() {
		List<LowcategoryDB> lowcategories = sst.selectList("lowcategory.selectAll");
		return lowcategories;
	}
	
	//upEng->lowlistDTO
	public List<LowcategoryDB> getLowcategorylistEngByUpEng(String upcategoryeng) {
		List<LowcategoryDB> lowcategorylist =sst.selectList("lowcategory.selectlistEngByEng", upcategoryeng);
		return lowcategorylist;
	}
	
	public List<LowcategoryDB> getLowcategorylistAllByUpEng(String upcategoryeng) {
		logger.info("실행");
		List<LowcategoryDB> lowcategorylist =sst.selectList("lowcategory.selectlistAllByEng", upcategoryeng);
		logger.info("업카테고리: "+upcategoryeng);
		return lowcategorylist;
	}

	public String getUpEngByLowEng(String lowcategoryeng) {
		String upcategoryeng = sst.selectOne("lowcategory.selectUpEngByLowEng", lowcategoryeng);
		return upcategoryeng;
	}
}
