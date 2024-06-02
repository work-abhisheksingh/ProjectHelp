package com.app.Entities;

import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Food")
public class Food {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer foodId;

	@Column(name = "Food_name", unique = true)
	private String name;

	@Column(name = "Food_desc")
	private String description;

	@Column(name = "Food_price")
	private double price;

	@Column(name = "Food_image")
	private byte[] img;
	
	@Column(name="Qty")
	private int qty;

	// * foods --- 1 category
	@ManyToOne( fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id", nullable = false)

	private Category foodcategory;

	// 1 food -- 1 cartitems
	@OneToOne/*(mappedBy = "food", cascade = CascadeType.ALL, orphanRemoval = true , fetch = FetchType.LAZY)*/
	private CartItems cartitems;

	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}






	public Food(Integer foodId, String name, String description, double price, byte[] img, int qty,
			Category foodcategory) {
		super();
		this.foodId = foodId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.img = img;
		this.qty = qty;
		this.foodcategory = foodcategory;
		
	}








	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

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

	public Category getFoodcategory() {
		return foodcategory;
	}

	public void setFoodcategory(Category foodcategory) {
		this.foodcategory = foodcategory;
	}


	
	

	public int getQty() {
		return qty;
	}





	public void setQty(int qty) {
		this.qty = qty;
	}





	@Override
	public String toString() {
		return "Food [name=" + name + ", description=" + description + ", price=" + price + ", img="
				+ Arrays.toString(img) + ", foodcategory=" + foodcategory + "]";
	}

}
