package com.emp.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.demo.entity.Employee;
import com.emp.demo.repository.EmpRepository;

@Service
public class EmpService {
	@Autowired
	EmpRepository empRepository;
	
	public List<Employee> getAll(){
		return empRepository.getAll();
		
	}

	public String add(Employee emp) {
		
		return empRepository.add(emp);
	}

	public String edit(Employee emp) {
		
		return empRepository.edit(emp);
	}

	public String delete(int empNo) {
		
		return empRepository.delete(empNo);
	}
}
