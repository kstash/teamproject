package teamproject.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import teamproject.dao.ProdimageDBDao;
import teamproject.dto.LowcategoryDB;
import teamproject.dto.ProdimageDB;

@Service
public class ProdimageDBService {
	
	@Resource
	private ProdimageDBDao prodimageDao;
	
	private static final Logger logger = LoggerFactory.getLogger(ProdimageDBService.class);

	public void insertProdImage(ProdimageDB prodimage) {
		prodimageDao.insertProdImage(prodimage);
	}
	
	public List<ProdimageDB> selectByPath(String prodimagePath) {
		logger.info("실행");
		logger.info("prodimagePath: " + prodimagePath);
		return prodimageDao.selectByPath(prodimagePath);
	}
}
