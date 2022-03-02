package com.sp.persistence;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sp.domain.CategoryVO;
import com.sp.domain.GoodsVO;
import com.sp.domain.GoodsViewVO;

@Service
public interface AdminDAO {

	// category
	public List<CategoryVO> category() throws Exception;

	// register
	public void register(GoodsVO vo) throws Exception;

	// list
	public List<GoodsViewVO> goodslist() throws Exception;

	// view
	public GoodsViewVO goodsView(int gdsNum) throws Exception;
	
	// update
	public void goodsModify(GoodsVO vo) throws Exception;
	
	// delete
	public void goodsDelete(int gdsNum) throws Exception;
		
}
