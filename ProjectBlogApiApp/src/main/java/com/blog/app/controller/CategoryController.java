package com.blog.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.app.playloads.ApiResponse;
import com.blog.app.playloads.CategoryDTO;
import com.blog.app.sevices.CategoryService;

@RestController
@RequestMapping("/api/categories/")
public class CategoryController {
	
	
	@Autowired
	private CategoryService categoryService;
	
	//create
	@PostMapping("/")
	public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDto){
		
		CategoryDTO createCategory=categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDTO>(createCategory,HttpStatus.CREATED);
	}
	
	//update
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDto, @PathVariable Integer categoryId){
		
		CategoryDTO updateCategory=categoryService.updateCategory(categoryDto, categoryId);
		return new ResponseEntity<CategoryDTO>(updateCategory,HttpStatus.OK);
	}
	
	//delete
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId){
		
		categoryService.deleteCategory(categoryId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category deleted successfully!!", true),HttpStatus.OK);
	}
	
	//get
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDTO> getCategory(@PathVariable Integer categoryId){
		
		CategoryDTO getCategory=categoryService.getCategory(categoryId);
		return new ResponseEntity<CategoryDTO>(getCategory,HttpStatus.OK);
	
	}
	
	//getall
	@GetMapping("/")
	public ResponseEntity<List<CategoryDTO>> getAllCategories(){
		
		List<CategoryDTO> getAllCategories=categoryService.getAllCategories();
		return new ResponseEntity<List<CategoryDTO>>(getAllCategories,HttpStatus.OK);
//		return ResponseEntity.ok(getAllCategories);
	
	}

}
