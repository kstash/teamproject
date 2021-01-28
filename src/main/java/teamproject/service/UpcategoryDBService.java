package teamproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teamproject.dao.UpcategoryDBDao;
import teamproject.dto.LowcategoryDB;

@Service
public class UpcategoryDBService {

	
	
	@Autowired
	private UpcategoryDBDao upcategorydbDao;

	
	public String getUpcategoryKrByEng(String upcategoryEng) {
		String upcategoryKr = upcategorydbDao.getUpcategoryKrByEng(upcategoryEng);
		return upcategoryKr;
	}


	public List<UpcategoryDB> getUpCategories() {
		// TODO Auto-generated method stub
		return null;
	}

}
