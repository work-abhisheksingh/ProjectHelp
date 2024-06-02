package com.app.dto;

import java.util.ArrayList;
import java.util.List;

import com.app.Entities.Cart;
import com.app.Entities.CartItems;
import com.app.Entities.User;

public class CartDto {
	
	private int cartId;

	private UserDto customer;
	
	private List<CartItemDto> cartitems = new ArrayList<CartItemDto>();

	public CartDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartDto(int cartId, UserDto customer, List<CartItemDto> cartitems) {
		super();
		this.cartId = cartId;
		this.customer = customer;
		this.cartitems = cartitems;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public UserDto getCustomer() {
		return customer;
	}

	public void setCustomer(UserDto customer) {
		this.customer = customer;
	}

	public List<CartItemDto> getCartitems() {
		return cartitems;
	}

	public void setCartitems(List<CartItemDto> cartitems) {
		this.cartitems = cartitems;
	}
	 
	
		
}