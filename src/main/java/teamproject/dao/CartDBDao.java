package teamproject.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import teamproject.dto.CartDB;

@Repository
public class CartDBDao {
	private static final Logger logger = 
			LoggerFactory.getLogger(CartDBDao.class);
	
	@Resource
	private SqlSessionTemplate sst;

	public List<CartDB> cartSelect() {
		logger.info("CartDBDao.cartSelect() 실행");
		List<CartDB> cartlist = sst.selectList("cart.cartSelect");
		
		return cartlist;
	}

	public int insertCart(CartDB cart) {
		int rows = sst.insert("cart.insert", cart);
		return rows;
	}

	public int getCartPriceByPd(long productCode) {
		int price = sst.selectOne("product.selectPriceByPk", productCode);
		return price;
	}

	public void deleteCartByK(int cartcode) {
		sst.delete("cart.delete", cartcode);
	}

}
