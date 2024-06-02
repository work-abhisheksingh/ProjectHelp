package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Entities.Food;
import com.app.dto.DeleteResponse;
import com.app.dto.FoodDto;
import com.app.services.FoodService;

@CrossOrigin(origins = "*" , allowedHeaders = "*")
@RestController
@RequestMapping("/api/food")

public class FoodController {

	@Autowired
	private FoodService foodservice;
	

	
	@PostMapping(path="/addfood" )
	public ResponseEntity<FoodDto> addfood(@RequestBody FoodDto food /*, @PathVariable int catid*/) {
			
		//System.out.println(" ************************************"+food.get);
		//System.out.println(food.getFoodcategory().getCategoryName());
		FoodDto createdfood = this.foodservice.addFood(food );
		
		return new ResponseEntity<FoodDto>(createdfood,HttpStatus.CREATED);
	}
	
	@GetMapping("/viewall")
	public ResponseEntity<List<FoodDto>> getallfoods(){
		System.out.println("in controller GetAll");
		List<FoodDto> viewall = this.foodservice.getAllFoods();
		return new ResponseEntity<List<FoodDto>>(viewall,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/viewbyid/{foodid}")
	public ResponseEntity<FoodDto> getById(@PathVariable int foodid) {
		FoodDto viewById = foodservice.getbyId(foodid);
		return new ResponseEntity<FoodDto>(viewById,HttpStatus.ACCEPTED);
	}
	
	
	
	@DeleteMapping("/delete/{foodid}")
	public ResponseEntity<String> deleteFood(@PathVariable Integer foodid) {
		
		foodservice.deleteFood(foodid);
		
		return new ResponseEntity<String>("Food deleted", HttpStatus.OK);
	}
	
	@PutMapping("/update/{foodid}")
	public ResponseEntity<FoodDto> updateFood(@PathVariable int foodid , @RequestBody FoodDto newfood) {
	
		FoodDto updatefood = foodservice.updateFood(foodid , newfood);
		
		return new ResponseEntity<FoodDto> (updatefood , HttpStatus.ACCEPTED);
	}
	
	
//	@GetMapping("/getbycategory/{catid}")
//	public ResponseEntity<List<FoodDto>> getProductByCategory(@PathVariable int catid){
//		
//		List<FoodDto > foodlist = this.foodservice.getProductByCategory(catid); //faster xml error - we get repeated list of items
//		
//		return new ResponseEntity<List<FoodDto>>( foodlist , HttpStatus.ACCEPTED);
//		
//	}
//	
	
}
