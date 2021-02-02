package teamproject.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teamproject.dao.LowcategoryDBDao;
import teamproject.dto.LowcategoryDB;

@Service
public class LowcategoryDBService {
	private static final Logger logger = LoggerFactory.getLogger(LowcategoryDBService.class);

	@Autowired
	private LowcategoryDBDao lowcategorydbDao;

	public List<LowcategoryDB> getLowCategories() {
		List<LowcategoryDB> lowCategories = lowcategorydbDao.getLowCategories();
		return lowCategories;
	}
	
	//upEng->lowlistDTO
	public List<LowcategoryDB> getLowcategorylistEngByUpEng(String upcategoryeng) {
		List<LowcategoryDB> lowcategorylist = lowcategorydbDao.getLowcategorylistEngByUpEng(upcategoryeng);
		return lowcategorylist;
	}
	
	public List<LowcategoryDB> getLowcategorylistAllByUpEng(String upcategoryeng) {
		logger.info("실행");
		List<LowcategoryDB> lowcategorylist = lowcategorydbDao.getLowcategorylistAllByUpEng(upcategoryeng);
		return lowcategorylist;
	}

	public String getUpEngByLowEng(String lowcategoryeng) {
		logger.info("실행");
		String upcategoryeng = lowcategorydbDao.getUpEngByLowEng(lowcategoryeng);
		return upcategoryeng;
	}
}
