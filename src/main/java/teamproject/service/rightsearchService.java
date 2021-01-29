package teamproject.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import teamproject.dao.ProductDBDao;
import teamproject.dto.ProductDB;


@Service
public class rightsearchService {
	private static final Logger logger = 
			LoggerFactory.getLogger(rightsearchService.class);
	
	@Resource
	private ProductDBDao productDao;
	
	public void search(ProductDB product) {
		ProductDB searchProduct = productDao.searchProduct(product.getProductCode());
		logger.info("rightsearchService 실행");
	}

}
