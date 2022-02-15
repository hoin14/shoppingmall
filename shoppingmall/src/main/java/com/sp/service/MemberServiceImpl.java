package com.sp.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

import com.sp.domain.MemberVO;
import com.sp.persistence.MemberDAO;

@Repository
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO dao;

	// signup
	@Override
	public void signup(MemberVO vo) throws Exception {
		dao.signup(vo);

	}

	// signin
	@Override
	public MemberVO signin(MemberVO vo) throws Exception {
		return dao.signin(vo);
	}

	// signout
	@Override
	public void signout(HttpSession session) throws Exception {
		session.invalidate();

	}

}
