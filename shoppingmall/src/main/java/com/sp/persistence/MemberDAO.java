package com.sp.persistence;

import org.springframework.stereotype.Service;

import com.sp.domain.MemberVO;

@Service
public interface MemberDAO {
	
	//signup
	public void signup(MemberVO vo) throws Exception;
	
	//login
	public MemberVO signin(MemberVO vo) throws Exception;
}
