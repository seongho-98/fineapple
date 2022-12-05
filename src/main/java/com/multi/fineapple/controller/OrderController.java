package com.multi.fineapple.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.fineapple.dao.OrderDAO;
import com.multi.fineapple.vo.MemberVO;
import com.multi.fineapple.vo.ProductVO;

@Controller
public class OrderController {

	@Autowired
	OrderDAO dao;
	
	@RequestMapping("order_all")
	public void one(MemberVO vo, Model model) {
		List<ProductVO> result = dao.all(vo);
		model.addAttribute("vo", result);
	}
}
