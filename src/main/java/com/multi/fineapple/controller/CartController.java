package com.multi.fineapple.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.multi.fineapple.dao.CartDAO;
import com.multi.fineapple.dao.CartProductDAO;
import com.multi.fineapple.vo.CartProductDetailVO;
import com.multi.fineapple.vo.CartVO;
import com.multi.fineapple.vo.MemberVO;


@Controller
public class CartController {
	
	private CartDAO cartDao;
	private CartProductDAO cartProductDao;
	
	@Autowired
	public CartController(CartDAO cartDao, CartProductDAO cartProductDao) {
		this.cartDao = cartDao;
		this.cartProductDao = cartProductDao;
	}
	
	@GetMapping("/cart")
	public String cart(HttpSession session, Model model) {
		session.setAttribute("id", "root");		// 로그인
		
		String id = (String) session.getAttribute("id");
		
		if(id == null) {
			return "login";
		}
		
		MemberVO member = new MemberVO();
		member.setMember_id(id);
		CartVO cart = cartDao.getCart(member);
		
		List<CartProductDetailVO> cartProductDetailList = cartProductDao.getCartProductDetailList(cart);
		
		model.addAttribute("cartProductDetailList", cartProductDetailList);
		
		return "cart/cart_list";
	}
	
	@PostMapping("/cart/order")
	public String cartOrder() {
		
		return "";
	}
}
