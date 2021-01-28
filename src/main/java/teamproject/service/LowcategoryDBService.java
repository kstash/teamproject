package teamproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teamproject.dao.LowcategoryDBDao;
import teamproject.dto.LowcategoryDB;

@Service
public class LowcategoryDBService {

	
	
	@Autowired
	private LowcategoryDBDao lowcategorydbDao;

	//upEng->lowlistDTO
	public List<LowcategoryDB> getLowcategorylistEngByUpEng(String upcategoryeng) {
		List<LowcategoryDB> lowcategorylist = lowcategorydbDao.getgetLowcategorylistEngByUpEng(upcategoryeng);
		return lowcategorylist;
	}



}
