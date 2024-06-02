package com.app.services;

import java.security.Principal;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Entities.Cart;
import com.app.Entities.CartItems;
import com.app.Entities.Food;
import com.app.Entities.User;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.CartDto;
import com.app.dto.ItemRequest;
import com.app.repository.CartItemRepository;
import com.app.repository.CartRepository;
import com.app.repository.FoodRepository;
import com.app.repository.UserRepository;

@Service
@Transactional
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartrepo;

	@Autowired
	private FoodRepository foodrepo;

	@Autowired
	private CartItemRepository cartitemrepo;

	@Autowired
	private UserRepository userrepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public CartDto addToCart(ItemRequest item, int userId) {

		int foodid = item.getFoodId();
		int qty = item.getQuantity();
		
		System.out.println(userId);
		System.out.println(qty);

		User user = this.userrepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User Not found"));

		Food food = this.foodrepo.findById(foodid).orElseThrow(() -> new ResourceNotFoundException("Food not found"));

		// creating cart item for given data
		CartItems cartitem = new CartItems();
		cartitem.setFood(food);
		cartitem.setQuantity(qty);
		

		double totalprice = food.getPrice() * qty;

		cartitem.setTotalPrice(totalprice);

		// get cart of user

		Cart cart = user.getCart();
		
		System.out.println(cart.getCustomer());

//		if (cart == null) {
//			cart = new Cart(); // means user dont have cart create it
//		}

		cartitem.setCart(cart);
		
		List<CartItems> items = cart.getCartitems(); // retrieve all items from his carts

		// if item available just increase qty else add new item
		AtomicReference<Boolean> flag = new AtomicReference<Boolean>(false); // adding this because in lambda function we
																		// cant change value of
																		// normal boolean flag

		List<CartItems> newitem = items.stream().map((i) -> { // iterating the list to check if item already there
			if (i.getFood().getFoodId() == food.getFoodId()) {
				i.setQuantity(qty);
				i.setTotalPrice(totalprice);
				flag.set(true);
			}
			return i;
		}).collect(Collectors.toList());

		if (flag.get()) {
			items.clear();
			items.addAll(newitem);
		} else {
			cartitem.setCart(cart);
			items.add(cartitem);
		}
		
		System.out.println(cart.getCustomer());
		

		Cart savedcart = this.cartrepo.save(cart);

		return this.mapper.map(savedcart, CartDto.class);
	}

	@Override
	public CartDto getallcart(int userId) {
		
		User user =this.userrepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
		
		Cart cart = this.cartrepo.findByUser(user).orElseThrow(() -> new ResourceNotFoundException("Cart not found"));

		return this.mapper.map(cart, CartDto.class);
	}

//	@Override
//	public String addToCart( CartDto transientitem) {
//		
//		Cart cart = cartrepo.findByCustomer_id(transientitem.getCustomerId()).orElseThrow(() -> new ResourceNotFoundException("Cart not found"));
//		
//		Food food = foodrepo.findById(transientitem.getFoodId()).orElseThrow(() -> new ResourceNotFoundException("Food not found"));
//		
//		double totalprice= food.getPrice() * transientitem.getQuantity();
//		
//		CartItems newitem = new CartItems(transientitem.getQuantity() , totalprice , cart , food);
//		
//		CartItems saveditem = cartitemrepo.save(newitem);
//		
//		cart.getCartitems().add(saveditem);
//		
//		cart.setTotalprice(cart.getTotalprice()+totalprice);
//		
//		cart.setItems(cart.getItems()+1);
//		
//
//		return "Product added in the cart successfully !";
//	}
	
	public CartDto removecartitems(String email , int foodid) {
		User user =this.userrepo.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User not found"));
		
		Cart cart = user.getCart();
		List<CartItems> items= cart.getCartitems();
		
		items.removeIf((i) -> i.getFood().getFoodId() == foodid);
		
		 Cart updatedcart = this.cartrepo.save(cart);
		 
		 return this.mapper.map(updatedcart, CartDto.class);
		 
		}
	

}
