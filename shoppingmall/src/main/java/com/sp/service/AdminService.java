package com.sp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sp.domain.CategoryVO;

@Service
public interface AdminService {

	// category
	public List<CategoryVO> category() throws Exception;

}
