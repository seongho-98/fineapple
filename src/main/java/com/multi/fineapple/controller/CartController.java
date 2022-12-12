package com.multi.fineapple.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.multi.fineapple.dao.CartDAO;
import com.multi.fineapple.dao.CartProductDAO;
import com.multi.fineapple.dao.OrderDAO;
import com.multi.fineapple.dao.OrderProductDAO;
import com.multi.fineapple.dao.ProductDAO;
import com.multi.fineapple.vo.CartOrderVO;
import com.multi.fineapple.vo.CartProductDetailVO;
import com.multi.fineapple.vo.CartProductVO;
import com.multi.fineapple.vo.CartVO;
import com.multi.fineapple.vo.MemberVO;
import com.multi.fineapple.vo.OrderProductVO;
import com.multi.fineapple.vo.OrderVO;
import com.multi.fineapple.vo.ProductVO;


@Controller
public class CartController {
	
	private CartDAO cartDao;
	private CartProductDAO cartProductDao;
	private ProductDAO productDao;
	private OrderDAO orderDao;
	private OrderProductDAO orderProductDao;
	
	@Autowired
	public CartController(CartDAO cartDao, CartProductDAO cartProductDao, ProductDAO productDao, OrderDAO orderDao, OrderProductDAO orderProductDao) {
		this.cartDao = cartDao;
		this.cartProductDao = cartProductDao;
		this.productDao = productDao;
		this.orderDao = orderDao;
		this.orderProductDao = orderProductDao;
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
		
		List<CartProductDetailVO> cartProductDetailList = cartProductDao.getCartProductDetailListByCartId(cart);
		
		model.addAttribute("cartProductDetailList", cartProductDetailList);
		
		return "cart/cart_list";
	}
	
	@PostMapping("/cart/order")
	public @ResponseBody ResponseEntity cartOrder(HttpSession session, @RequestBody CartOrderVO cartOrderVO) {
		session.setAttribute("id", "root");		// 로그인
		
		String id = (String) session.getAttribute("id");
		
		if(id == null) {
			return new ResponseEntity<String>("로그인 해주세요", HttpStatus.FORBIDDEN);
		}
		
		List<CartProductVO> cartProductVOList = cartOrderVO.getCartProductVOList();
		List<CartProductDetailVO> cartProductDetailVOList = new ArrayList<CartProductDetailVO>();
		
		int orderPrice = 0;
		for (CartProductVO cartProductVO : cartProductVOList) {
			CartProductDetailVO cartProductDetailVO = cartProductDao.getCartProductDetailByCartProductId(cartProductVO);
			orderPrice += cartProductDetailVO.getCartProductPrice();
			cartProductDetailVOList.add(cartProductDetailVO);
		}
		
		OrderVO orderVO = new OrderVO();
		orderVO.setBuyer_id(id);
		orderVO.setDeal_date(LocalDateTime.now().toString());
		orderVO.setOrder_price(orderPrice);
		int orderId = orderDao.orderInsert(orderVO);
		
		for (CartProductDetailVO cartProductDetailVO : cartProductDetailVOList) {
			OrderProductVO orderProductVO = new OrderProductVO();
			orderProductVO.setOrderId(orderId);
			int productId = cartProductDetailVO.getProductId();
			orderProductVO.setProductId(productId);
			orderProductDao.insert(orderProductVO);
			ProductVO productVO = new ProductVO();
			productVO.setProduct_id(productId);
			cartProductDao.delete(productVO);
		}
		
		return new ResponseEntity<Integer>(orderId, HttpStatus.OK);
	}
}
