package com.app.services;

import com.app.dto.CartDto;
import com.app.dto.ItemRequest;

public interface CartService {
	
	public CartDto addToCart(ItemRequest item , int userId); 
	
	public CartDto getallcart(int userId);
	
	public CartDto removecartitems(String email, int foodid);
}
