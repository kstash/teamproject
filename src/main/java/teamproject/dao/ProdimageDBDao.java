package teamproject.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import teamproject.controller.AdminsController;
import teamproject.dto.ProdimageDB;

@Repository
public class ProdimageDBDao {
	
	@Resource
	private SqlSessionTemplate sst;
	
	private static final Logger logger = LoggerFactory.getLogger(ProdimageDBDao.class);

	
	public int insertProdImage(ProdimageDB prodimage) {
		int rows = sst.insert("prodimage.insert", prodimage);
		return rows;
	}

	public List<ProdimageDB> selectByPath(String prodImagePath) {
		logger.info("prodimagePath: " + prodImagePath);
		return sst.selectList("selectByPath", prodImagePath);
	}

	public List<ProdimageDB> selectByCode(long productCode) {
		return sst.selectList("prodimage.selectByCode", productCode);
	}
}
