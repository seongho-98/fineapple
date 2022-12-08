package com.multi.fineapple.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multi.fineapple.vo.CartVO;
import com.multi.fineapple.vo.MemberVO;

@Repository
public class CartDAO {

	private SqlSessionTemplate my;
	
	@Autowired
	public CartDAO(SqlSessionTemplate my) {
		this.my = my;
	}
	
	public CartVO getCart(MemberVO vo) {
		CartVO cart = my.selectOne("cart.getCart", vo);
		return cart;
	}
}
