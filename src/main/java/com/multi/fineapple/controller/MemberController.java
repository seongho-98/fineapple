package com.multi.fineapple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.fineapple.dao.MemberDAO;
import com.multi.fineapple.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	MemberDAO dao;
	
	@RequestMapping("member_one")
	public void one(MemberVO vo, Model model) {
		MemberVO result = dao.one(vo);
		model.addAttribute("vo", result);
	}
}
