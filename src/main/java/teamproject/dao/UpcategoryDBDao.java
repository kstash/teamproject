package teamproject.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import teamproject.dto.ProductDB;
import teamproject.dto.UpcategoryDB;

@Repository
public class UpcategoryDBDao {

	@Resource
	private SqlSessionTemplate sst;

	public String getUpcategoryKrByEng(String upcategoryEng) {
		String upcategoryKr = sst.selectOne("upcategory.selectKrByEng", upcategoryEng);
		return upcategoryKr;
	}
	
	public List<UpcategoryDB> getUpcategories() {
		List<UpcategoryDB> upcategories = sst.selectList("upcategory.selectAll");
		return upcategories;
	}

	public UpcategoryDB insert(UpcategoryDB upcategory) {
		UpcategoryDB newupcategory = (UpcategoryDB) sst.selectOne("upcategory.insert", upcategory);
		return newupcategory;
	}
}
