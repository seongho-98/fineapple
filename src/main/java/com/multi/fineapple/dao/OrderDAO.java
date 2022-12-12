package com.multi.fineapple.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.multi.fineapple.vo.OrderVO;

@Component
public class OrderDAO {

	@Autowired
	SqlSessionTemplate my;
	
	public int orderInsert(OrderVO orderVO) {
		return my.insert("order.orderInsert", orderVO);
	}
}
