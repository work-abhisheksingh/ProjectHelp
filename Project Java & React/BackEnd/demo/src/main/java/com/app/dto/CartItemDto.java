package com.app.dto;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.app.Entities.Cart;
import com.app.Entities.Food;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class CartItemDto {
	
	private int cartItemId;

	private int quantity;
	
	private double totalPrice;
	
	@JsonIgnore
	private CartDto cart;
	
	private FoodDto food;

	public CartItemDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartItemDto(int cartItemId, int quantity, double totalPrice, CartDto cart, FoodDto food) {
		super();
		this.cartItemId = cartItemId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.cart = cart;
		this.food = food;
	}

	public int getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public CartDto getCart() {
		return cart;
	}

	public void setCart(CartDto cart) {
		this.cart = cart;
	}

	public FoodDto getFood() {
		return food;
	}

	public void setFood(FoodDto food) {
		this.food = food;
	}

//	@Override
//	public String toString() {
//		return "CartItemDto [cartItemId=" + cartItemId + ", quantity=" + quantity + ", totalPrice=" + totalPrice
//				+ ", cart=" + cart + ", food=" + food + "]";
//	}
	
	
	
}
