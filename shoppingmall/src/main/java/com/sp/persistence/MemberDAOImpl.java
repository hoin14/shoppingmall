package com.sp.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sp.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	private SqlSession sql;

	// signup
	@Override
	public void signup(MemberVO vo) throws Exception {
		sql.insert("com.sp.mappers.memberMapper.signup", vo);

	}

	// login
	@Override
	public MemberVO signin(MemberVO vo) throws Exception {
		return sql.selectOne("com.sp.mappers.memberMapper.signin", vo);
		
	}
}
