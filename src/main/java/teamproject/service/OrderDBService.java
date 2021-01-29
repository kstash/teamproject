package teamproject.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import teamproject.dao.OrderDBDao;
import teamproject.dto.OrderDB;

@Service
public class OrderDBService {
	private static Logger logger = LoggerFactory.getLogger(OrderDBService.class);
	
	@Resource
	private OrderDBDao orderdbDao;

	public List<OrderDB> getOrderlistByUid(String userId) {
		List<OrderDB> orderlist = orderdbDao.getOrderlistByUid(userId);
		return orderlist;
	}
}
