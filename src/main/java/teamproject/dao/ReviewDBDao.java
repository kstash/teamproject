package teamproject.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import teamproject.dto.ReviewDB;

@Repository
public class ReviewDBDao {

	@Resource
	private SqlSessionTemplate sst;

	public List<ReviewDB> getReviewListByPd(long productCode) {
		List<ReviewDB> reviewList = sst.selectList("review.selectByPd", productCode);
		return reviewList;
	}

	public ReviewDB getReviewByO(String orderCode) {
		ReviewDB reviewOne = sst.selectOne("review.selectByO", orderCode);
		return reviewOne;
	}
}
