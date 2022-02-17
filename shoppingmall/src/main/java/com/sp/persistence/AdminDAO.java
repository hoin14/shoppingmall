package com.sp.persistence;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sp.domain.CategoryVO;
import com.sp.domain.GoodsVO;

@Service
public interface AdminDAO {

	// category
	public List<CategoryVO> category() throws Exception;

	// register
	public void register(GoodsVO vo) throws Exception;

	// list
	public List<GoodsVO> goodslist() throws Exception;

	// view
	public GoodsVO goodsView(int gdsNum) throws Exception;

}
