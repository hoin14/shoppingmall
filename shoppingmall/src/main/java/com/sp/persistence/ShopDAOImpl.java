package com.sp.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.jca.cci.CannotGetCciConnectionException;
import org.springframework.stereotype.Repository;

import com.sp.domain.CartListVO;
import com.sp.domain.CartVO;
import com.sp.domain.GoodsViewVO;
import com.sp.domain.OrderDetailVO;
import com.sp.domain.OrderListVO;
import com.sp.domain.OrderVO;
import com.sp.domain.ReplyListVO;
import com.sp.domain.ReplyVO;

@Repository
public class ShopDAOImpl implements ShopDAO {

	@Inject
	private SqlSession sql;

	@Override
	public List<GoodsViewVO> list(int cateCode) throws Exception {
		return sql.selectList("com.sp.mappers.shopMapper.list", cateCode);
	}

	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		return sql.selectOne("com.sp.mappers.shopMapper.goodsView", gdsNum);
	}

	@Override
	public void registReply(ReplyVO reply) throws Exception {
		sql.insert("com.sp.mappers.shopMapper.registReply", reply);

	}

	@Override
	public List<ReplyListVO> replyList(int gdsNum) throws Exception {
		return sql.selectList("com.sp.mappers.shopMapper.replyList", gdsNum);
	}

	@Override
	public void deleteReply(ReplyVO reply) throws Exception {
		sql.delete("com.sp.mappers.shopMapper.deleteReply", reply);

	}

	@Override
	public String idCheck(int repNum) throws Exception {
		return sql.selectOne("com.sp.mappers.shopMapper.replyUserIdCheck", repNum);
	}

	@Override
	public void modifyReply(ReplyVO reply) throws Exception {
		sql.update("com.sp.mappers.shopMapper.modifyReply", reply);

	}

	@Override
	public void addCart(CartVO cart) throws Exception {
		sql.insert("com.sp.mappers.shopMapper.addCart", cart);
	}

	@Override
	public List<CartListVO> cartList(String userId) throws Exception {
		return sql.selectList("com.sp.mappers.shopMapper.cartList", userId);
	}

	@Override
	public void deleteCart(CartVO cart) throws Exception {
		sql.delete("com.sp.mappers.shopMapper.deleteCart", cart);
	}

	@Override
	public void orderInfo(OrderVO order) throws Exception {
		sql.insert("com.sp.mappers.shopMapper.orderInfo", order);
	}

	@Override
	public void orderInfo_Details(OrderDetailVO orderDetail) throws Exception {
		sql.insert("com.sp.mappers.shopMapper.orderInfo_Details", orderDetail);
	}

	@Override
	public void cartAllDelete(String userId) throws Exception {
		sql.delete("com.sp.mappers.shopMapper.cartAllDelete", userId);
	}

	@Override
	public List<OrderVO> orderList(OrderVO order) throws Exception {
		return sql.selectList("com.sp.mappers.shopMapper.orderList", order);
	}

	@Override
	public List<OrderListVO> orderView(OrderVO order) throws Exception {
		return sql.selectList("com.sp.mappers.shopMapper.orderView", order);
	}


}
