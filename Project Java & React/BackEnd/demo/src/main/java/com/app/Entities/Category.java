package com.app.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Categories")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryId;

	@Column(name = "category_name")
	private String categoryName;

	@JsonBackReference
	@OneToMany(mappedBy = "foodcategory", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY) // after
																													// deleting
																													// cat
																													// refernece
																													// from
																													// food
																													// food
																													// become
																													// orphan
	private List<Food> foods = new ArrayList<>(); // better to initialize empty than null ,to not get nullpointer
													// exception while constructor initialization

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Food> getFoods() {
		return foods;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}

	public Category(String categoryName, List<Food> foods) {
		super();
		this.categoryName = categoryName;
		this.foods = foods;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", foods=" + foods + "]";
	}

	public void addfood(Food f) { // helper method to add food
		foods.add(f); // forward link
		f.setFoodcategory(this); // reverse link
	}

	public void deleteFood(Food f) {
		foods.remove(f);
		f.setFoodcategory(null);
	}

}
