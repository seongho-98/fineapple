package com.multi.fineapple.vo;

public class CartProductDetailVO {
	
	private int cartProductId;
	private String cartProductName;
	private int cartProductPrice;
	private String cartProductImg;
	private int productId;
	
	
	public int getCartProductId() {
		return cartProductId;
	}
	public void setCartProductId(int cartProductId) {
		this.cartProductId = cartProductId;
	}
	public String getCartProductName() {
		return cartProductName;
	}
	public void setCartProductName(String cartProductName) {
		this.cartProductName = cartProductName;
	}
	public int getCartProductPrice() {
		return cartProductPrice;
	}
	public void setCartProductPrice(int cartProductPrice) {
		this.cartProductPrice = cartProductPrice;
	}
	public String getCartProductImg() {
		return cartProductImg;
	}
	public void setCartProductImg(String cartProductImg) {
		this.cartProductImg = cartProductImg;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	@Override
	public String toString() {
		return "CartProductDetailVO [cartProductId=" + cartProductId + ", cartProductName=" + cartProductName
				+ ", cartProductPrice=" + cartProductPrice + ", cartProductImg=" + cartProductImg + ", productId="
				+ productId + "]";
	}
	
}
