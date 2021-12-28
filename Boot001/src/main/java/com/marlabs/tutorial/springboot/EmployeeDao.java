package com.marlabs.tutorial.springboot;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
	private static EmployeePojo list = new EmployeePojo();

	//In below static block, we are adding three students
	static
	{
	list.getEmployeeList().add(new EmployeePojo(1, "amruta", 23));
	list.getEmployeeList().add(new EmployeePojo(2, "abhi", 23));
	list.getEmployeeList().add(new EmployeePojo(3, "afreen", 23));
	}

	//method to return the employee list
	public EmployeePojo getAllEmployees()
	{
	return list;
	}

	//method to add the employee in the list
	public void addEmployee(EmployeePojo employee) {
	list.getEmployeeList().add(employee);
	}
	
	/*@Autowired  
	
	
}
