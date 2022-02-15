package com.sp.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sp.domain.CategoryVO;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Inject
	private SqlSession sql;

	@Override
	public List<CategoryVO> category() throws Exception {
		return sql.selectList("com.sp.mappers.adminMapper.category");
	}

}
