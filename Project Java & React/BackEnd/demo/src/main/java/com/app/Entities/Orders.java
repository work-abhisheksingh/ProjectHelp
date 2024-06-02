package com.app.Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	private String orderstatus;
	
	private String paymentstatus;
	
	@CreationTimestamp
	private Date created_on;
	
	private Date orderdelivered;
	
	private double orderAmt;
	
	private String billingAddress;
	
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	
	@OneToMany(mappedBy = "order" , cascade = CascadeType.ALL , orphanRemoval = true )
	private List<OrderItems> orderitem =  new ArrayList<OrderItems>();

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(int orderId, String orderstatus, String paymentstatus, Date created_on, Date orderdelivered,
			double orderAmt, String billingAddress, User user, List<OrderItems> orderitem) {
		super();
		this.orderId = orderId;
		this.orderstatus = orderstatus;
		this.paymentstatus = paymentstatus;
		this.created_on = created_on;
		this.orderdelivered = orderdelivered;
		this.orderAmt = orderAmt;
		this.billingAddress = billingAddress;
		this.user = user;
		this.orderitem = orderitem;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	public String getPaymentstatus() {
		return paymentstatus;
	}

	public void setPaymentstatus(String paymentstatus) {
		this.paymentstatus = paymentstatus;
	}

	public Date getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}

	public Date getOrderdelivered() {
		return orderdelivered;
	}

	public void setOrderdelivered(Date orderdelivered) {
		this.orderdelivered = orderdelivered;
	}

	public double getOrderAmt() {
		return orderAmt;
	}

	public void setOrderAmt(double orderAmt) {
		this.orderAmt = orderAmt;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderItems> getOrderitem() {
		return orderitem;
	}

	public void setOrderitem(List<OrderItems> orderitem) {
		this.orderitem = orderitem;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderstatus=" + orderstatus + ", paymentstatus=" + paymentstatus
				+ ", created_on=" + created_on + ", orderdelivered=" + orderdelivered + ", orderAmt=" + orderAmt
				+ ", billingAddress=" + billingAddress + ", user=" + user + ", orderitem=" + orderitem + "]";
	}

	
}

	