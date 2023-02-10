package com.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.department.entity.Department;
import com.department.service.DepartmentService;

//It is particular controller as a component and it is always return response body
//@RequestMapping("/")
@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	//Save the particular apis/data 
	@PostMapping("/departments") 
	public Department createDepartment(@RequestBody Department department) { //Json data is converted into Particular Entity class type data(Entity class Object)
		return departmentService.createDepartment(department);	
	}
	
	//Get all the data
	@GetMapping("/departments")
	public List<Department> getAllDepartmentData(){
		return departmentService.getAllDepartmentData();	
	}
	
	//Get the data by using id
	@GetMapping("/departments/{id}")
	public Department getDataByUsingId(@PathVariable("id") Long departmentId) {
		return departmentService.getDataByUsingId(departmentId);
	}
	
	//Delete the data using id
	@DeleteMapping("/departments/{id}")
	public String deleteDataByUsingId(@PathVariable("id") Long departmentId,
			@RequestParam("name") String departmentName) {
		return departmentService.deleteDataByUsingId(departmentId);
	}
	
	//Update the data using id
	@PutMapping("/departments/{id}")
	public Department updateDataByUsingId(@PathVariable("id") Long departmentId, @RequestBody Department department) {
		return departmentService.updateDataByUsingId(departmentId, department);
	}
	
	//Get the data by using name
	@GetMapping("/departments/name/{name}")
	public Department getDataByUsingName(@PathVariable("name") String departmentName) {
		return departmentService.getDataByUsingName(departmentName);
	}
	
}
