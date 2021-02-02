package teamproject.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import teamproject.dto.CartDB;
import teamproject.dto.StockDB;

@Repository
public class StockDBDao {
	private static final Logger logger = 
			LoggerFactory.getLogger(StockDBDao.class);
	
	@Resource
	private SqlSessionTemplate sst;

	public List<StockDB> getStocklistByPd(long productCode) {
		List<StockDB> stocklist = sst.selectList("stock.selectlistByPd", productCode);
		return stocklist;
	}

	public StockDB getstockByK(StockDB stockKey) {
		StockDB stocksearch = sst.selectOne("stock.selectByk", stockKey);
		return stocksearch;
	}

	public void release(StockDB stock) {
		sst.update("stock.release", stock);
	}

	public void delete(StockDB stock) {
		sst.delete("stock.delete", stock);
	}

	public void update(StockDB stock) {
		sst.delete("stock.update", stock);
	}

	public void insertByPd(long productCode) {
		sst.insert("stock.insertByPd", productCode);
	}
}
