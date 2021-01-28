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

}
