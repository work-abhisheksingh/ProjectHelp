package com.app.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.Entities.Category;
import com.app.Entities.Food;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.CategoryDto;
import com.app.dto.FoodDto;
import com.app.repository.CategoryRepository;
import com.app.repository.FoodRepository;

@Service
@Transactional
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodRepository foodrepo;
	
	@Autowired
	private CategoryRepository catrepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public FoodDto addFood(FoodDto food /*, int catid*/) {

		//see if category is present
		
		//System.out.println(" ************************************"+food.getFoodcategory().getCategoryId());
		
		Category cat = this.catrepo.findById(food.getFoodcategory().getCategoryId()).orElseThrow(() -> new ResourceNotFoundException("Entered category not found"));
		
		//Category cat = this.catrepo.findById(food.getCategoryid()).orElseThrow(() -> new ResourceNotFoundException("Entered category not found"));
		
		//Food foodentity = toEntity(food); // changing dto to entity
		
		Food foodentity = this.mapper.map(food, Food.class);
		
		foodentity.setFoodcategory(cat);

		Food createdfood = this.foodrepo.save(foodentity);
		
		FoodDto fooddto = this.mapper.map(createdfood, FoodDto.class);

		return fooddto;
	}

	@Override
	public List<FoodDto> getAllFoods() {

		List<Food> getall = this.foodrepo.findAll();
		
	
		//System.out.println(getall);
		
		List<FoodDto> getAllDto = getall.stream().map(food -> this.mapper.map(food, FoodDto.class)).collect(Collectors.toList());
		
		return getAllDto;
	}



//	@Override
//	public Food updateFood(FoodDto detachedfood) {
//		
//		if(foodrepo.existsById(detachedfood.getFoodId()) {
//			System.out.println("food ID "+detachedfood);
//			return foodrepo.save(detachedfood);
//		}
//		throw new ResourceNotFoundException("Updation failed : Invalid food id");
//	}

	@Override
	public Food addToCart(Integer food_id) {
		// TODO Auto-generated method stub
		return null;
	}

	//get item by id
	
	@Override
	public FoodDto getbyId(int foodId) {
		
		Food foundproduct = foodrepo.findById(foodId)
				.orElseThrow(() -> new ResourceNotFoundException(+foodId + " " + " not Found"));
		
		FoodDto dto = this.mapper.map(foundproduct, FoodDto.class);
		return dto;
	}
	
	//delete item
	
	@Override
	public String deleteFood(Integer foodId) {

		if (foodrepo.existsById(foodId)) {
			foodrepo.deleteById(foodId);
			return "Food Deleted successfully";
		}
		return "Deletion failed : Please enter valid food Id";
	}

	@Override
	public FoodDto updateFood(int foodId, FoodDto newfood) {

		Food oldfood = foodrepo.findById(foodId)
				.orElseThrow(() -> new ResourceNotFoundException(+foodId + " " + " not Found"));
		oldfood.setName(newfood.getName());
		oldfood.setPrice(newfood.getPrice());
		oldfood.setDescription(newfood.getDescription());
		oldfood.setImg(newfood.getImg());

		Food save = foodrepo.save(oldfood);
		
		FoodDto fdto = this.mapper.map(save, FoodDto.class);
		
		return  fdto;
	}

//method to convert DTO to entity
	public Food toEntity(FoodDto fooddto) {

		Food f = new Food();
		f.setName(fooddto.getName());
		f.setDescription(fooddto.getDescription());
		f.setPrice(fooddto.getPrice());
		f.setImg(fooddto.getImg());

		return f;

	}
	
	//method to convert entity to DTO
	
//	public FoodDto toDto(Food food) {
//		FoodDto fDto = new FoodDto();
//		
//		fDto.setName(food.getName());
//		fDto.setDescription(food.getDescription());
//		fDto.setPrice(food.getPrice());
//		fDto.setImg(food.getImg());
//		
//		//changig category to catdto
//		CategoryDto catDto = new CategoryDto();
//		catDto.setCategoryId(food.getFoodcategory().getCategoryId());
//		catDto.setCategoryName(food.getFoodcategory().getCategoryName());
//		
//		fDto.setFoodcategory(catDto);
//		
//		return fDto; 
//	}

//	@Override
//	public List<FoodDto> getProductByCategory(int catid) {
//
//		Category foundcat = this.catrepo.findById(catid).orElseThrow(() -> new ResourceNotFoundException("Entered category not found"));
//		
//		List<Food> foods =  this.foodrepo.findByCategory(foundcat);
//		
//		List<FoodDto> fooddto = foods.stream().map(food -> toDto(food)).collect(Collectors.toList());
//		
//		return fooddto;
//		
//	}

}
