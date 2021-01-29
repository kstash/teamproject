package teamproject.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import teamproject.dao.ProdimageDBDao;
import teamproject.dto.ProdimageDB;

@Service
public class ProdimageDBService {
	
	@Resource
	private ProdimageDBDao prodimageDao;
	
	public void insertProdImage(ProdimageDB prodimage) {
		prodimageDao.insertProdImage(prodimage);
	}

}
