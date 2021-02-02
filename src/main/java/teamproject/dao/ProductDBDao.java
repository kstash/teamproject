package teamproject.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import teamproject.dto.ProductDB;

@Repository
public class ProductDBDao {
	private static final Logger logger = LoggerFactory.getLogger(ProductDBDao.class);

	@Resource
	private SqlSessionTemplate sst;
	
	public int insertProduct(ProductDB product) {
		int rows = sst.insert("product.product", product);
		return rows;
	}

	public ProductDB getProductByPd(long productCode) {
		ProductDB product = sst.selectOne("product.selectByPk", productCode);
		return product;
	}

	/*
	 * public ProductDB searchProduct(int productCode) {
	 * logger.info("ProductDBDao 실행"); ProductDB product =
	 * sst.selectOne("product.searchProduct",productCode); return product; }
	 */
	
}
