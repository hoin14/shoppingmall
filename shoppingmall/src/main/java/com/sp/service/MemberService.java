package com.sp.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.sp.domain.MemberVO;

@Service
public interface MemberService {
	
	//signup
	public void signup(MemberVO vo) throws Exception;
	
	//login
	public MemberVO signin(MemberVO vo) throws Exception;
	
	//logout
	public void signout(HttpSession session) throws Exception;
	
}
