package teamproject.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import teamproject.dao.LowcategoryDBDao;
import teamproject.dto.LowcategoryDB;

@Service
public class LowcategoryDBService {

	@Resource
	private LowcategoryDBDao lowcategoryDao;
	
	public List<LowcategoryDB> getLowCategories() {
		
		List<LowcategoryDB> lowcategories = lowcategoryDao.selectLowCategories();
		return lowcategories;
	}

}
