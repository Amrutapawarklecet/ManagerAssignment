package com.department.service;

import java.util.List;

import com.department.entity.Department;

public interface DepartmentService {

	public Department createDepartment(Department department);

	public List<Department> getAllDepartmentData();

	public Department getDataByUsingId(Long departmentId);

	public String deleteDataByUsingId(Long departmentId);

	public Department updateDataByUsingId(Long departmentId, Department department);

	public Department getDataByUsingName(String departmentName);

}
