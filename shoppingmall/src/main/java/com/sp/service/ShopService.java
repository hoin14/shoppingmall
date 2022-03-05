package com.sp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sp.domain.GoodsViewVO;
import com.sp.domain.ReplyListVO;
import com.sp.domain.ReplyVO;

@Service
public interface ShopService {

	// list
	public List<GoodsViewVO> list(int cateCode) throws Exception;

	// 상품조회
	public GoodsViewVO goodsView(int gdsNum) throws Exception;
	
	// 상품댓글 작성
	public void registReply(ReplyVO reply) throws Exception;
	
	// 상품댓글 리스트
	public List<ReplyListVO> replyList(int gdsNum) throws Exception;
		
}
