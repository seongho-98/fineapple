package com.multi.fineapple.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.multi.fineapple.vo.MemberVO;
import com.multi.fineapple.vo.ProductVO;

@Component
public class OrderDAO {

	@Autowired
	SqlSessionTemplate my;
	
	public List<ProductVO> all(MemberVO vo) {
		return my.selectList("order.orderAll");
	}
}
