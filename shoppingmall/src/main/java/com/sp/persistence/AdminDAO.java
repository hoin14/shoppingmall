package com.sp.persistence;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sp.domain.CategoryVO;

@Service
public interface AdminDAO {

	// category
	public List<CategoryVO> category() throws Exception;

}
