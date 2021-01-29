package teamproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teamproject.dao.ReviewDBDao;
import teamproject.dto.ReviewDB;

@Service
public class ReviewDBService {
	
	@Autowired
	private ReviewDBDao reviewdbDao;

	public List<ReviewDB> getReviewListByPd(long productCode) {
		 List<ReviewDB> reviewList = reviewdbDao.getReviewListByPd(productCode);
		return reviewList;
	}

	public ReviewDB getReviewByO(String ordercode) {
		ReviewDB reviewOne = reviewdbDao.getReviewByO(ordercode);
		return reviewOne;
	}

	public List<ReviewDB> getReviewlistByUid(String userId) {
		List<ReviewDB> reviewlist = reviewdbDao.getReviewlistByUid(userId);
		return reviewlist;
	}

	public void saveReview(ReviewDB review) {
		reviewdbDao.insert(review);
	}

}
