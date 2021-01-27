package teamproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teamproject.dao.UpcategoryDBDao;
import teamproject.dto.UpcategoryDB;

@Service
public class UpcategoryDBService {

	@Autowired
	private UpcategoryDBDao dbDao;

	
	public String getDatatest() {
		String upcategoryKr = dbDao.selectOneTest();
		return upcategoryKr;
	}


	public List<UpcategoryDB> getUpCategories() {
		// TODO Auto-generated method stub
		return null;
	}

}
