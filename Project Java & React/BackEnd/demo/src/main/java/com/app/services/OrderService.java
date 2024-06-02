package com.app.services;

import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;

import com.app.dto.OrderRequest;
import com.app.dto.OrdersDto;

public interface OrderService {

	public OrdersDto createorder(OrderRequest request , int userid );
	
	public void cancelorder (int orderid);
	
	public OrdersDto findorderbyid(int orderid);
}
