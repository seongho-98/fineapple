package com.multi.fineapple.vo;

public class CartVO {
	
	private int cartId;
	private String memberId;
	
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	@Override
	public String toString() {
		return "CartVO [cartId=" + cartId + ", memberId=" + memberId + "]";
	}
	
}
