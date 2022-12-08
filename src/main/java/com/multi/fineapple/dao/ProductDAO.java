package com.multi.fineapple.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.multi.fineapple.vo.ProductVO;

@Component
public class ProductDAO {
	
	@Autowired
	SqlSessionTemplate product;
	
	public ProductVO oneProduct(ProductVO productVO) {
		return product.selectOne("mapper.productMapper.oneProduct", productVO);
	}

}
