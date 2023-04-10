package com.blog.app.sevices;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.blog.app.entities.Category;
import com.blog.app.playloads.CategoryDTO;
import com.blog.app.repositories.CategoryRepo;

@SpringBootTest
@RunWith(SpringRunner.class)
class CategoryServiceTest {

	@MockBean //don't want take values from the data base
	private CategoryRepo categoryRepo;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Test
	void CreateCategoryTest() {
		Category cat=new Category(1,"python","This is related to python");
		
		when(categoryRepo.save(cat)).thenReturn(cat);
		
		assertEquals(cat, categoryService.createCategory(modelMapper.map(cat,CategoryDTO.class)));
	}
	@Test
	void testUpdateCategory() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCategory() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllCategories() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteCategory() {
		fail("Not yet implemented");
	}

}
