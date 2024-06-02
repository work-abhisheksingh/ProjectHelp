package com.app.services;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.stereotype.Service;

import com.app.Entities.Cart;
import com.app.Entities.CartItems;
import com.app.Entities.OrderItems;
import com.app.Entities.Orders;
import com.app.Entities.User;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.CartDto;
import com.app.dto.OrderRequest;
import com.app.dto.OrdersDto;
import com.app.repository.CartRepository;
import com.app.repository.OrderRepository;
import com.app.repository.UserRepository;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;


@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private CartRepository cartrepo;
	
	@Autowired
	private OrderRepository orderrepo;
	
	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	public OrdersDto createorder(OrderRequest request, int userid) {
		User user = this.userrepo.findById(userid).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
		
//		System.out.println(request.getCartId());
//		System.out.println(request.getOrderAddress());
		int cartId = request.getCartId();
		
		String order_address = request.getOrderAddress();
		
		Cart cart = this.cartrepo.findById(cartId).orElseThrow(() -> new ResourceNotFoundException("Cart Not Found"));
		
		List<CartItems> items =  cart.getCartitems();
		
		Orders order = new Orders();
		
		AtomicReference<Double> total_order_amt = new AtomicReference<Double>(0.0);
		
		List<OrderItems> orderitems= items.stream().map((cartitem) -> {
		
		OrderItems orderitem = new OrderItems();
		
		//setting cartitems to orderitems
		orderitem.setFood(cartitem.getFood());
		orderitem.setQuantity(cartitem.getQuantity());
		
		orderitem.setTotalfoodprice(cartitem.getTotalPrice());
		
		orderitem.setOrder(order);
		
		total_order_amt.set(total_order_amt.get() + orderitem.getTotalfoodprice());
		
		int foodid= orderitem.getFood().getFoodId();
		
		return orderitem;
		}).collect(Collectors.toList());
		
		order.setBillingAddress(order_address);
		order.setOrderdelivered(null);
		order.setOrderstatus("Order Created");
		order.setPaymentstatus(" Not Paid");
		order.setUser(user);
		order.setOrderitem(orderitems);
		order.setOrderAmt(total_order_amt.get());
		order.setCreated_on(new Date());
		Orders save;
		if(order.getOrderAmt() > 0) {
			
			save = this.orderrepo.save(order);
			cart.getCartitems().clear();
			
			this.cartrepo.save(cart);
			
		}else {
			throw new ResourceNotFoundException("Please Add to cart first and then place order");
		}
		
		
		return this.mapper.map(save, OrdersDto.class);
	}
	
	
	public void cancelorder(int orderid) {
	
		Orders order= this.orderrepo.findById(orderid).orElseThrow(() -> new ResourceNotFoundException("Order Not Found"));
		
		this.orderrepo.delete(order);
	
	}


	@Override
	public OrdersDto findorderbyid(int orderid) {
		
		Orders order =this.orderrepo.findById(orderid).orElseThrow(() -> new ResourceNotFoundException("Order Not Found"));
		
		return this.mapper.map(order, OrdersDto.class);
	}


	
	
}
