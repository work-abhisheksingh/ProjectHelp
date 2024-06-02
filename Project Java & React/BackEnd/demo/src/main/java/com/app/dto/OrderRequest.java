package com.app.dto;

public class OrderRequest {

	private String orderAddress;
	
	private int cartId;

	
	
	public OrderRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public OrderRequest(String orderAddress, int cartId) {
		super();
		this.orderAddress = orderAddress;
		this.cartId = cartId;
	}


	public String getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	
}
