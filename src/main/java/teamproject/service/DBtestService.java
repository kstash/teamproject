package teamproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teamproject.dao.DBtestDao;

@Service
public class DBtestService {

	@Autowired
	private DBtestDao dbDao;

	
	public String getDatatest() {
		String data = dbDao.selectOneTest();
		return data;
	}

}
