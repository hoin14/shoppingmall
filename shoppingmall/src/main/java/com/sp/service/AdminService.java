package com.sp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sp.domain.CategoryVO;
import com.sp.domain.GoodsVO;
import com.sp.domain.GoodsViewVO;
import com.sp.domain.OrderListVO;
import com.sp.domain.OrderVO;
import com.sp.domain.ReplyListVO;

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

	// 상품 수량조절
	public void changeStock(GoodsVO goods) throws Exception;

	// 모든 댓글
	public List<ReplyListVO> allReply() throws Exception;

	// 댓글 삭제
	public void deleteReply(int repNum) throws Exception;
}
