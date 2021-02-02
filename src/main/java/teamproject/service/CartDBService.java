package teamproject.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import teamproject.dao.CartDBDao;
import teamproject.dto.CartDB;

@Service
public class CartDBService {
	private static Logger logger = 
			LoggerFactory.getLogger(CartDBService.class);
	
	@Resource
	private CartDBDao cartDao;
	
	public List<CartDB> getCartlist() {
		logger.info("CartDBService.getCartlist() 실행");
		List<CartDB> cartlist = cartDao.cartSelect();
		
		return cartlist;
	}

	public void deleteCart(int cartcode) {
		cartDao.deleteCart(cartcode);
	}

}
