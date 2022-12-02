package com.multi.fineapple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.multi.fineapple.dao.MemberDAO;

@Controller
public class MemberController {
	
	@Autowired
	MemberDAO dao;
	
}
