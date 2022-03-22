package com.sp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sp.domain.CategoryVO;
import com.sp.domain.GoodsVO;
import com.sp.domain.GoodsViewVO;
import com.sp.domain.OrderListVO;
import com.sp.domain.OrderVO;

@Service
public interface AdminService {

	// category
	public List<CategoryVO> category() throws Exception;

	// register
	public void register(GoodsVO vo) throws Exception;

	// list
	public List<GoodsViewVO> goodslist() throws Exception;

	// view
	public GoodsViewVO goodView(int gdsNum) throws Exception;

	// update
	public void goodsModify(GoodsVO vo) throws Exception;
	
	// delete
	public void goodsDelete(int gdsNum) throws Exception;
	
	// 주문 목록
	public List<OrderVO> orderList() throws Exception;
	
	// 특정 주문 목록
	public List<OrderListVO> orderView(OrderVO order) throws Exception;
	
	// 배송 상태
	public void delivery(OrderVO order) throws Exception;
}
