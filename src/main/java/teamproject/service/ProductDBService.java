package teamproject.service;

import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import teamproject.dao.ProductDBDao;
import teamproject.dto.ProductDB;

@Service
public class ProductDBService {
	private static Logger logger = LoggerFactory.getLogger(ProductDBService.class);
	
	@Resource
	private ProductDBDao productDao;
	
	public void insertProduct(ProductDB product) {
		productDao.insertProduct(product);
	}
	
	public void setupProductInfo(ProductDB product) {
		productDao.setProductInfo(product);
	}

	public ProductDB getSelfByPk(long productCode) {
		ProductDB self = productDao.getSelfByPk(productCode);
		return self;
	}
	
	public String getUpCategoryByLowCategory(ProductDB product) {
		String productWithUpCategoryFilled = productDao.getUpCategoryByLowCategory(product);
		
		return productWithUpCategoryFilled;
	}

	public ProductDB getProductByPd(long productcode) {
		ProductDB product = productDao.getProductByPd(productcode);
		return product;
	}

	public List<ProductDB> getProductsByLowCategory(String lowcategoryeng) {
		return productDao.getProductsByLowCategory(lowcategoryeng);
	}
	
	/*public void search(ProductDB product) {
		ProductDB productSearched = 
				productDao.searchProduct(product.getProductCode());
		logger.info("rightsearchService 실행");
	}*/
}
