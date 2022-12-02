package com.multi.fineapple.vo;

public class OrderProductVO {
	private int orderProductId;
	private int orderId;
	private int productId;
	
	public int getOrderProductId() {
		return orderProductId;
	}
	public void setOrderProductId(int orderProductId) {
		this.orderProductId = orderProductId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	@Override
	public String toString() {
		return "OrderProductVO [orderProductId=" + orderProductId + ", orderId=" + orderId + ", productId=" + productId
				+ "]";
	}
	
}
