package com.app.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class OrderItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderItemId;
	
	@OneToOne
	private Food food;
	
	private int quantity;
	
	private double totalfoodprice;
	
	@ManyToOne
	private Orders order;

	public OrderItems() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItems(int orderItemId, Food food, int quantity, double totalfoodprice, Orders order) {
		super();
		this.orderItemId = orderItemId;
		this.food = food;
		this.quantity = quantity;
		this.totalfoodprice = totalfoodprice;
		this.order = order;
	}

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

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderItems [orderItemId=" + orderItemId + ", food=" + food + ", quantity=" + quantity
				+ ", totalfoodprice=" + totalfoodprice + ", order=" + order + "]";
	}

	

}
	