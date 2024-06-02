package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.Entities.Orders;
import com.app.dto.DeleteResponse;
import com.app.dto.OrderRequest;
import com.app.dto.OrdersDto;
import com.app.services.OrderService;

@CrossOrigin(origins = "*" , allowedHeaders = "*")
@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderService orderservice;
	
	@PostMapping("/create/{userid}")
	public ResponseEntity<OrdersDto> createdorder(@RequestBody OrderRequest orderreq ,@PathVariable int userid){
		
		System.out.println(orderreq.getCartId());
		OrdersDto orderdto = this.orderservice.createorder(orderreq,  userid);
		
		return new ResponseEntity<OrdersDto>(orderdto , HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/cancel/{orderid}")
	public ResponseEntity<?> cancelorderbyid(@PathVariable int orderid) {
		
		this.orderservice.cancelorder(orderid);
		
		return new ResponseEntity<DeleteResponse>(new DeleteResponse("Order Cancelled"),HttpStatus.OK);
	}
	
	@GetMapping("/{orderid}")
	public ResponseEntity<OrdersDto> getbyid(@PathVariable int orderid){
		
		OrdersDto order =  this.orderservice.findorderbyid(orderid);
		
		return new ResponseEntity<OrdersDto>(order , HttpStatus.ACCEPTED);
		
	}
	
}
