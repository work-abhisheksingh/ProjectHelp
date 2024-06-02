package com.app.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.app.Entities.CartItems;
import com.app.Entities.Category;
import com.fasterxml.jackson.annotation.JsonProperty;


public class FoodDto {

	private int foodId;

	private String name;

	private String description;

	private double price;

	private byte[] img;

	private CategoryDto foodcategory;
	
	private CartItemDto cartitemdto;

	public FoodDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FoodDto(int foodId, String name, String description, double price, byte[] img) {
		super();
		this.foodId = foodId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.img = img;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getName() {
		return name;
	}

	//@JsonProperty(value="name")
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	//@JsonProperty(value="description")
	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public CategoryDto getFoodcategory() {
		return foodcategory;
	}

	public void setFoodcategory(CategoryDto foodcategory) {
		this.foodcategory = foodcategory;
	}


	public CartItemDto getCartitemdto() {
		return cartitemdto;
	}

	public void setCartitemdto(CartItemDto cartitemdto) {
		this.cartitemdto = cartitemdto;
	}

}
