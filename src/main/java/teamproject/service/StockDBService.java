package teamproject.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import teamproject.dao.StockDBDao;
import teamproject.dto.StockDB;

@Service
public class StockDBService {
	private static Logger logger = LoggerFactory.getLogger(StockDBService.class);
	
	@Resource
	private StockDBDao stockdbDao;

	public List<StockDB> getStocklistByPd(long productcode) {
		List<StockDB> stocklist = stockdbDao.getStocklistByPd(productcode); 
		return stocklist;
	}

	public StockDB getstockByK(StockDB stockKey) {
		StockDB stocksearch = stockdbDao.getstockByK(stockKey);
		return stocksearch;
	}
	
	
}
