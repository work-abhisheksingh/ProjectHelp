package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.app.Entities.Category;
import com.app.dto.CategoryDto;
import com.app.dto.DeleteResponse;
import com.app.services.CategoryService;
import com.app.services.FoodService;

@CrossOrigin(origins = "*" , allowedHeaders = "*")
@RestController
@RequestMapping("/api/cat")
public class CategoryController {

//	@Autowired
//	private FoodService foodservice;
	
	@Autowired
	private CategoryService categoryservice;
	
	
//	@GetMapping("/getcategories")
//	public List<Category> getallcategories(){
//		System.out.println("Getting all categories");
//		return null
//	}
	
	@PostMapping("/create")
	public ResponseEntity<CategoryDto> addcategory(@RequestBody CategoryDto catdto) {
		System.out.println("in add category");
		
		CategoryDto created = this.categoryservice.create(catdto);
		return new ResponseEntity<CategoryDto>(created , HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update/{catid}")
	public ResponseEntity<CategoryDto> updatecategory(@RequestBody CategoryDto catdto , @PathVariable int catid){
		CategoryDto updated = this.categoryservice.update(catdto , catid);
		
		return new ResponseEntity<CategoryDto>(updated , HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{catid}")
	public ResponseEntity<DeleteResponse> delete(@PathVariable int catid){
		
		this.categoryservice.delete(catid);
		return new ResponseEntity<DeleteResponse>((new DeleteResponse("Deleted successfully")),HttpStatus.OK);
		
	}
	
	@GetMapping("/getbyid/{catid}")
	public ResponseEntity<CategoryDto> getById(@PathVariable int catid){
		CategoryDto getById = this.categoryservice.get(catid);
		return new ResponseEntity<CategoryDto>(getById , HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<CategoryDto>> getall(){
		List<CategoryDto> all = this.categoryservice.getall();
		
		return new ResponseEntity<List<CategoryDto>>(all,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
}
