package com.emp.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.emp.demo.entity.Employee;

@Repository
public class EmpRepository {
	public List<Employee> employee=new ArrayList<Employee>();

	public List<Employee> getAll() {
		
		return employee;
	}

	public String add(Employee emp) {
		employee.add(emp);
		return "Sucessfully added";
	}

	public String edit(Employee emp) {
		employee.stream().filter(e->e.getEmployeeId()==emp.getEmployeeId()).forEach(e->{
			e.setAddress(emp.getAddress());
			e.setName(emp.getName());
		});
		return "Successfully Updated";
	}

	public String delete(int empNo) {
		employee.remove(empNo-1);
		return "Successfully Deleted";
	}
}
