package com.multi.fineapple.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.multi.fineapple.vo.OrderProductVO;

@Component
public class OrderProductDAO {

	@Autowired
	SqlSessionTemplate my;
	
	public void insert(OrderProductVO orderProductVO) {
		my.insert("mapper.orderProductMapper.insert", orderProductVO);
	}
}
