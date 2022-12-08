package com.multi.fineapple.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.fineapple.dao.CartDAO;
import com.multi.fineapple.dao.CartProductDAO;
import com.multi.fineapple.dao.OrderDAO;
import com.multi.fineapple.dao.ProductDAO;

@Service
public class CartService {

	private CartDAO cartDao;
	private CartProductDAO cartProductDao;
	private ProductDAO productDao;
	private OrderDAO orderDao;
	
	@Autowired
	public CartService(CartDAO cartDao, CartProductDAO cartProductDao, ProductDAO productDao, OrderDAO orderDao) {
		this.cartDao = cartDao;
		this.cartProductDao = cartProductDao;
		this.productDao = productDao;
		this.orderDao = orderDao;
	}
}
