package teamproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teamproject.dao.RevimageDBDao;
import teamproject.dto.RevimageDB;

@Service
public class RevimageDBService {
	
	@Autowired
	private RevimageDBDao revimagedbDao;
	
	public RevimageDB getRevimageByO(String ordercode) {
		RevimageDB reviewOne = revimagedbDao.getReviewByO(ordercode);
		return reviewOne;
	}

}
