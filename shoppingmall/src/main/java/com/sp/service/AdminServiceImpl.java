package com.sp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.sp.domain.CategoryVO;
import com.sp.persistence.AdminDAO;

@Repository
public class AdminServiceImpl implements AdminService {

	@Inject
	private AdminDAO dao;

	@Override
	public List<CategoryVO> category() throws Exception {
		return dao.category();
	}

}
