package com.multi.fineapple.vo;

import java.util.List;

public class CartOrderVO {
	
	private List<CartProductVO> cartProductVOList;

	public List<CartProductVO> getCartProductVOList() {
		return cartProductVOList;
	}
	public void setCartProductVOList(List<CartProductVO> cartProductVOList) {
		this.cartProductVOList = cartProductVOList;
	}

	@Override
	public String toString() {
		return "CartOrderVO [cartProductVOList=" + cartProductVOList + "]";
	}
	
}
