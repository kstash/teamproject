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
	
	@Resource
	private SqlSessionTemplate sst;

	//upEng->lowlistDTO
	public List<LowcategoryDB> getgetLowcategorylistEngByUpEng(String upcategoryeng) {
		List<LowcategoryDB> lowcategorylist =sst.selectList("lowcategory.selectlistEngByEng", upcategoryeng);
		return lowcategorylist;
	}
	
	

}
