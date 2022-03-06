package com.sp.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.jca.cci.CannotGetCciConnectionException;
import org.springframework.stereotype.Repository;

import com.sp.domain.GoodsViewVO;
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

}
