package com.app.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.app.dto.CartDto;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Cart_items")
public class CartItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartItemId;

	private int quantity;
	
	@Column(name="total_price")
	private double totalPrice;
	
	//* cartitem -- 1 cart
	
	@ManyToOne
	@JoinColumn(name="cart_id")
	
	private Cart cart;
	
	//1 cartitem --- 1 food
	@OneToOne
	@JoinColumn(name="food_id")
	private Food food;
	
	public CartItems() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CartItems(int cartItemId, int quantity, double totalPrice, Cart cart, Food food) {
		super();
		this.cartItemId = cartItemId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.cart = cart;
		this.food = food;
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

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	@Override
	public String toString() {
		return "CartItems [quantity=" + quantity + ", totalPrice=" + totalPrice + ", cart=" + cart + ", food=" + food
				+ "]";
	}

	public Integer getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(Integer cartItemId) {
		this.cartItemId = cartItemId;
	}
	
	
	
	
	
	
	
}
