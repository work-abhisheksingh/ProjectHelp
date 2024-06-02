package com.app.dto;

public class ItemRequest {

	private int foodId;
	private int quantity;
	
	
	
	public ItemRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public ItemRequest(int foodId, int quantity) {
		super();
		this.foodId = foodId;
		this.quantity = quantity;
	}


	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
