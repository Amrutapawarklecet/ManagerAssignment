package com.marlabs.tutorial.springboot;

import java.util.ArrayList;
import java.util.List;

public class EmployeePojo {
	private List<EmployeePojo> employeeList;

	public EmployeePojo() {
	}

//Constructor to store data in the instance variables
	public EmployeePojo(int empId, String empName, int empAge) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAge = empAge;
	}

//Method to retrieve the employees
	public List<EmployeePojo> getEmployeeList() {
		if (employeeList == null) {
			employeeList = new ArrayList<EmployeePojo>();
		}
		return employeeList;
	}
	   
	//getting a specific record by using the method findById() of CrudRepository  
	public employeeList getEmpById(int empId)   
	{  
	return EmployeePojo.findById(empId).get();  
	}  

  //Method for Addition of employee
	public void setEmployeeList(List<EmployeePojo> employeeList) {
		this.employeeList = employeeList;
	}
	
	//saving a specific record by using the method save() of CrudRepository  
		public void saveOrUpdate(Employee books)   
		{  
		booksRepository.save(books);  
		}  
		//deleting a specific record by using the method deleteById() of CrudRepository  
		public void delete(int id)   
		{  
		booksRepository.deleteById(id);  
		}  
		//updating a record  
		public void update(Books books, int bookid)   
		{  
		booksRepository.save(books);  
		} */ 

//Variables
	private int empId;
	private String empName;
	private int empAge;

	@Override
	public String toString() {
		return "Student [EmployeeId=" + empId + ", EmployeeId=" + empName + ",EmployeeAge=" + empAge + "]";
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

}
