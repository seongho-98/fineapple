package com.multi.fineapple.vo;

public class OrderVO {

	private int order_id;
	private String buyer_id;
	private String deal_date;
	private int order_price;
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getBuyer_id() {
		return buyer_id;
	}
	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}
	public String getDeal_date() {
		return deal_date;
	}
	public void setDeal_date(String deal_date) {
		this.deal_date = deal_date;
	}
	public int getOrder_price() {
		return order_price;
	}
	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}
	
	@Override
	public String toString() {
		return "OrderVO [order_id=" + order_id + ", buyer_id=" + buyer_id + ", deal_date=" + deal_date
				+ ", order_price=" + order_price + "]";
	}
	
}
