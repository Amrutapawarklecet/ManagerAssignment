package com.blog.app.services.impl;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.blog.app.entities.Category;
import com.blog.app.playloads.CategoryDTO;
import com.blog.app.repositories.CategoryRepo;
import com.blog.app.sevices.CategoryService;

@SpringBootTest
class CategoryServiceImplTest {

	@MockBean // don't want take values from the data base
	private CategoryRepo categoryRepo;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ModelMapper modelMapper;

	@Test
	void CreateCategoryTest() {
		Category cat = new Category(1, "python", "This is related to python");

		when(categoryRepo.save(cat)).thenReturn(cat);

		assertEquals(cat, categoryService.createCategory(modelMapper.map(cat, CategoryDTO.class)));
	}

	@Test
	void UpdateCategoryTest() {
		Category cat1 = new Category(1, "python", "This is related to python");
		
		when(categoryRepo.findById(1)).thenReturn(Optional.ofNullable(cat1));
		cat1.setCategoryTitle("Java");
		cat1.setCategoryDescription("Java Programming");
		
		Category cat2=categoryRepo.save(cat1);
		when(categoryRepo.save(cat1)).thenReturn(cat2);
		assertEquals(cat1, categoryService.updateCategory(modelMapper.map(cat1, CategoryDTO.class), cat1.getCategoryId()));
		
	}

	@Test
	void GetCategoryTest() {
		Category cat = new Category(1, "python", "This is related to python");
		when(categoryRepo.findById(1)).thenReturn(Optional.ofNullable(cat));
		
		assertEquals(cat, categoryService.getCategory(cat.getCategoryId()));
	}

	@Test
	void GetAllCategoriesTest() {
		
		List<Category> categories=new ArrayList<>();
		categories.add(new Category(1, "python", "This is related to python"));
		categories.add( new Category(2, "python", "This is related to python"));

		when(categoryRepo.findAll()).thenReturn(categories);
		assertEquals(categories, categoryService.getAllCategories());
	}	

	@Test
	void DeleteCategoryTest() {
		Category cat = new Category(1, "python", "This is related to python");
		categoryRepo.delete(cat);
		verify(cat, times(1));
		
	}

}
