package teamproject.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import teamproject.dto.RevimageDB;

@Repository
public class RevimageDBDao {

	@Resource
	private SqlSessionTemplate sst;

	public RevimageDB getReviewByO(String orderCode) {
		RevimageDB reviewOne = sst.selectOne("revimage.selectByO", orderCode);
		return reviewOne;
	}
}
