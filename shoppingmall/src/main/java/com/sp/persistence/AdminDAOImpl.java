package com.sp.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sp.domain.CategoryVO;
import com.sp.domain.GoodsVO;
import com.sp.domain.GoodsViewVO;
import com.sp.domain.OrderListVO;
import com.sp.domain.OrderVO;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Inject
	private SqlSession sql;

	@Override
	public List<CategoryVO> category() throws Exception {
		return sql.selectList("com.sp.mappers.adminMapper.category");
	}

	@Override
	public void register(GoodsVO vo) throws Exception {
		sql.insert("com.sp.mappers.adminMapper.register", vo);
	}

	@Override
	public List<GoodsViewVO> goodslist() throws Exception {
		return sql.selectList("com.sp.mappers.adminMapper.goodslist");
	}

	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		return sql.selectOne("com.sp.mappers.adminMapper.goodsView", gdsNum);
	}

	@Override
	public void goodsModify(GoodsVO vo) throws Exception {
		sql.update("com.sp.mappers.adminMapper.goodsModify", vo);
	}

	@Override
	public void goodsDelete(int gdsNum) throws Exception {
		sql.delete("com.sp.mappers.adminMapper.goodsDelete", gdsNum);
	}

	@Override
	public List<OrderVO> orderList() throws Exception {
		return sql.selectList("com.sp.mappers.adminMapper.orderList");
	}

	@Override
	public List<OrderListVO> orderView(OrderVO order) throws Exception {
		return sql.selectList("com.sp.mappers.adminMapper.orderView", order);
	}

	@Override
	public void delivery(OrderVO order) throws Exception {
		sql.update("com.sp.mappers.adminMapper.delivery", order);
	}

}
