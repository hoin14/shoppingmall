package com.sp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sp.domain.CategoryVO;
import com.sp.domain.GoodsVO;
import com.sp.domain.GoodsViewVO;

@Service
public interface AdminService {

	// category
	public List<CategoryVO> category() throws Exception;

	// register
	public void register(GoodsVO vo) throws Exception;

	// list
	public List<GoodsVO> goodslist() throws Exception;

	// view
	public GoodsViewVO goodView(int gdsNum) throws Exception;

	// update
	public void goodsModify(GoodsVO vo) throws Exception;
	
	// delete
	public void goodsDelete(int gdsNum) throws Exception;
		
}
