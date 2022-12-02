package com.multi.fineapple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.multi.fineapple.dao.OrderProductDAO;

@Controller
public class OrderProductController {

	@Autowired
	OrderProductDAO dao;
}
