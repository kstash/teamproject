package teamproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teamproject.dao.UpcategoryDBDao;
import teamproject.dto.LowcategoryDB;
import teamproject.dto.ProductDB;
import teamproject.dto.UpcategoryDB;

@Service
public class UpcategoryDBService {
	
	@Autowired
	private UpcategoryDBDao upcategorydbDao;

	
	public String getUpcategoryKrByEng(String upcategoryEng) {
		String upcategoryKr = upcategorydbDao.getUpcategoryKrByEng(upcategoryEng);
		return upcategoryKr;
	}
	
	public List<UpcategoryDB> getUpCategories() {
		List<UpcategoryDB> upcategories = upcategorydbDao.getUpcategories();
		return upcategories;
	}

	public UpcategoryDB insert(UpcategoryDB upcategory) {
		UpcategoryDB newupcategory = upcategorydbDao.insert(upcategory);
		return newupcategory;
	}

}
