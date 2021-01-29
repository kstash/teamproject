package teamproject.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import teamproject.dto.OrderDB;
import teamproject.dto.ProductDB;

@Repository
public class OrderDBDao {
	private static final Logger logger = LoggerFactory.getLogger(OrderDBDao.class);

	@Resource
	private SqlSessionTemplate sst;
	

	public List<OrderDB> getOrderlistByUid(String userId) {
		List<OrderDB> orderlist = sst.selectList("order.selectListByUid", userId);
		return orderlist;
	}
	
	
	
}
