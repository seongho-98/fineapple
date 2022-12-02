package com.multi.fineapple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.multi.fineapple.dao.CartDAO;


@Controller
public class CartController {
	
	@Autowired
	private CartDAO cartDao;
}
