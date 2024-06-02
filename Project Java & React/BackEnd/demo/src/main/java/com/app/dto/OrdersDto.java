package com.app.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.app.Entities.OrderItems;
import com.app.Entities.User;

public class OrdersDto {

	private int orderId;
	
	private String orderstatus;
	
	private String paymentstatus;
	
	private LocalDate orderdelivered;
	
	private double orderAmt;
	
	private String billingAddress;
	
	private UserDto user;
	
	private List<OrderItemsDto> orderitem =  new ArrayList<OrderItemsDto>();

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

	public LocalDate getOrderdelivered() {
		return orderdelivered;
	}

	public void setOrderdelivered(LocalDate orderdelivered) {
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

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public List<OrderItemsDto> getOrderitem() {
		return orderitem;
	}

	public void setOrderitem(List<OrderItemsDto> orderitem) {
		this.orderitem = orderitem;
	}
	
	
}
