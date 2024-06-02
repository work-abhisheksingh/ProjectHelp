package com.app.dto;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.app.Entities.Food;
import com.app.Entities.Orders;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class OrderItemsDto {

	private int orderItemId;
	
	private Food food;
	
	private int quantity;
	
	private double totalfoodprice;

	@JsonIgnore
	private OrdersDto order;

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalfoodprice() {
		return totalfoodprice;
	}

	public void setTotalfoodprice(double totalfoodprice) {
		this.totalfoodprice = totalfoodprice;
	}

	public OrdersDto getOrder() {
		return order;
	}

	public void setOrder(OrdersDto order) {
		this.order = order;
	}

	

	
	
	
	
	
}
