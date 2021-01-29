package teamproject.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import teamproject.dto.ProdimageDB;

@Repository
public class ProdimageDBDao {
	
	@Resource
	private SqlSessionTemplate sst;
	
	public int insertProdImage(ProdimageDB prodimage) {
		int rows = sst.selectOne("prodimage.insert", prodimage);
		return rows;
	}
}
