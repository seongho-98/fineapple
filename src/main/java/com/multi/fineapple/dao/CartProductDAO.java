package com.multi.fineapple.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multi.fineapple.vo.CartProductDetailVO;
import com.multi.fineapple.vo.CartProductVO;
import com.multi.fineapple.vo.CartVO;
import com.multi.fineapple.vo.MemberVO;

@Repository
public class CartProductDAO {
	
	private SqlSessionTemplate my;
	
	@Autowired
	public CartProductDAO(SqlSessionTemplate my) {
		this.my = my;
	}
	
	public List<CartProductVO> getCartProductList(MemberVO vo) {
		List<CartProductVO> list = my.selectList("cartProduct.getCartProductList", vo);
		return list;
	}
	
	public List<CartProductDetailVO> getCartProductDetailList(CartVO vo) {
		List<CartProductDetailVO> list = my.selectList("cartProduct.getCartProductDetailList", vo);
		return list;
	}
}
