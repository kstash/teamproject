package teamproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teamproject.dao.UpcategoryDBDao;

@Service
public class UpcategoryDBService {

	@Autowired
	private UpcategoryDBDao dbDao;

	
	public String getDatatest() {
		String data = dbDao.selectOneTest();
		return data;
	}

}
