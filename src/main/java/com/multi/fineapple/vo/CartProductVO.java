package com.multi.fineapple.vo;

public class CartProductVO {
	
	private int cartProductId;
	private int cartId;
	private int productId;
	
	
	public int getCartProductId() {
		return cartProductId;
	}
	public void setCartProductId(int cartProductId) {
		this.cartProductId = cartProductId;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	@Override
	public String toString() {
		return "CartProductVO [cartProductId=" + cartProductId + ", cartId=" + cartId + ", productId=" + productId
				+ "]";
	}
	
}
