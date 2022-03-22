package com.sp.persistence;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sp.domain.CartListVO;
import com.sp.domain.CartVO;
import com.sp.domain.GoodsViewVO;
import com.sp.domain.OrderDetailVO;
import com.sp.domain.OrderListVO;
import com.sp.domain.OrderVO;
import com.sp.domain.ReplyListVO;
import com.sp.domain.ReplyVO;

@Service
public interface ShopDAO {

	// list
	public List<GoodsViewVO> list(int cateCode) throws Exception;

	// 상품조회
	public GoodsViewVO goodsView(int gdsNum) throws Exception;

	// 상품댓글 작성
	public void registReply(ReplyVO reply) throws Exception;

	// 상품댓글 리스트
	public List<ReplyListVO> replyList(int gdsNum) throws Exception;

	// 상품댓글 삭제
	public void deleteReply(ReplyVO reply) throws Exception;

	// 아이디체크
	public String idCheck(int repNum) throws Exception;

	// 상품댓글 수정
	public void modifyReply(ReplyVO reply) throws Exception;

	// 카드 담기
	public void addCart(CartVO cart) throws Exception;

	// 카트 리스트
	public List<CartListVO> cartList(String userId) throws Exception;

	// 카드 삭제
	public void deleteCart(CartVO cart) throws Exception;

	// 주문 정보
	public void orderInfo(OrderVO order) throws Exception;

	// 주문 상세정보
	public void orderInfo_Details(OrderDetailVO orderDetail) throws Exception;

	// 카드 비우기
	public void cartAllDelete(String userId) throws Exception;
	
	// 주문 목록
	public List<OrderVO> orderList(OrderVO order) throws Exception;
	
	// 특정 주문 목록
	public List<OrderListVO> orderView(OrderVO order) throws Exception;
		
}
