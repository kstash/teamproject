package teamproject.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import teamproject.dao.CartDBDao;
import teamproject.dao.OrderDBDao;
import teamproject.dao.StockDBDao;
import teamproject.dto.CartDB;
import teamproject.dto.OrderDB;
import teamproject.dto.StockDB;

@Service
public class CartDBService {
	private static Logger logger = 
			LoggerFactory.getLogger(CartDBService.class);
	
	@Resource
	private CartDBDao cartDao;
	
	@Resource
	private OrderDBDao orderDao;
	
	@Resource
	private StockDBDao stockDao;
	
	public List<CartDB> getCartlist() {
		logger.info("CartDBService.getCartlist() 실행");
		List<CartDB> cartlist = cartDao.cartSelect();
		
		return cartlist;
	}

	public void addCart(CartDB cart) {
		cartDao.insertCart(cart);
	}

	@Transactional
	public void orderFromCarts(List<CartDB> carts) {
		//cart의 리스트를 받아 for문으로 하나씩 order로 넘기고 stock에서 제거하는 메소드
		//freeshipping 계산
		int count=0;
		for(CartDB cart : carts) {
			long productCode = cart.getProductcode();
			count += cartDao.getCartPriceByPd(productCode) * cart.getCartcount();
		}
		for(CartDB cart : carts) {
			//order부터
			OrderDB order = new OrderDB();
			SimpleDateFormat format1 = new SimpleDateFormat ("yyyyMMddHHmmss");
			Date time = new Date();
			String time1 = format1.format(time);
			order.setOrderCode(time1);
			order.setOrderColor(cart.getCartcolor());
			order.setOrderCount(cart.getCartcount());
			if(count>50000) {
				order.setOrderFreeshipping("Y");
			}else {
				order.setOrderFreeshipping("N");
			}
			order.setOrderSize(cart.getCartsize());
			order.setOrderStatus("preparing");
			order.setProductCode(cart.getProductcode());
			order.setUserId(cart.getUserid());
			orderDao.insert(order);
			//stock
			StockDB stock = new StockDB();
			stock.setStockColor(cart.getCartcolor());
			stock.setProductCode(cart.getProductcode());
			//cart size에 맞는 사이즈만 값입력
			switch (cart.getCartsize()) {
			case "S":
				stock.setStockSizeS(cart.getCartcount());
				break;
			case "M":
				stock.setStockSizeM(cart.getCartcount());
				break;
			case "L":
				stock.setStockSizeL(cart.getCartcount());
				break;
			case "XL":
				stock.setStockSizeXL(cart.getCartcount());
				break;
			}
			stockDao.release(stock);
			cartDao.deleteCartByK(cart.getCartcode());
		}
	}



}
