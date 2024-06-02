package com.app.Entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name = "Carts")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartId;

//	@Column(name = "cart_items")
//	private int items;
//
//	@Column(name = "cart_total")
//	private double totalprice;

	@Column(name = "Created_On")
	@CreationTimestamp
	private LocalDateTime createdOn;

	@Column(name = "updated_on")
	@UpdateTimestamp
	private LocalDateTime updatedOn;

	// 1 cart <---> 1customer
	@OneToOne
	//@JsonManagedReference
	@JoinColumn(name = "userId") // to specify FK col name
	private User user;

	// 1 cart --- * cart items

	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
	
	private List<CartItems> cartitems = new ArrayList<CartItems>();

	
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(int items, double totalprice, LocalDateTime createdOn, LocalDateTime updatedOn, User customer,
			List<CartItems> cartitems) {
		super();
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.user = customer;
		this.cartitems = cartitems;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public User getCustomer() {
		return user;
	}

	public void setCustomer(User customer) {
		this.user = customer;
	}

	public List<CartItems> getCartitems() {
		return cartitems;
	}

	public void setCartitems(List<CartItems> cartitems) {
		this.cartitems = cartitems;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", customer="
				+ user + ", cartitems=" + cartitems + "]";
	}



	public void addUser(User user) {
		setCustomer(user);
		user.setCart(this);
	}

}
