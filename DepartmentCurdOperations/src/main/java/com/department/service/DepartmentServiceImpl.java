package com.department.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.department.entity.Department;
import com.department.repository.DepartmentRepository;

// It is used to annotated with SeviceImpl class or Service class
@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository departmentRepository;
	
	//In post use save 
	@Override
	public Department createDepartment(Department department) {
		return departmentRepository.save(department);
	}

	//In getAll use find all 
	@Override
	public List<Department> getAllDepartmentData() {
		return departmentRepository.findAll();
	}

	//In get by id use findById
	@Override
	public Department getDataByUsingId(Long departmentId) {
		return departmentRepository.findById(departmentId).get();
	}
	
	//In get by id use findById
	/*	@Override
		public Optional<Department> getDataByUsingId(Long departmentId) {
			return departmentRepository.findById(departmentId);
		} */
		

	//In delete by id use deleteById
	@Override
	public String deleteDataByUsingId(Long departmentId) {
		departmentRepository.deleteById(departmentId);
		return "Data is deleted sucessfully!!";
	}

	@Override
	public Department updateDataByUsingId(Long departmentId, Department department) {
//		Optional<Department> depData=departmentRepository.findById(departmentId);
		Department depData=departmentRepository.findById(departmentId).get();
		 
		//Department name is not null and empty then update the data otherwise skip the data
		if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
			depData.setDepartmentName(department.getDepartmentName());
		}
		
		//set the department address
		if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
			depData.setDepartmentAddress(department.getDepartmentAddress());
		}
		
		//set department code
		if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
			depData.setDepartmentCode(department.getDepartmentCode());
		}
		 return departmentRepository.save(depData);
	}

	@Override
	public Department getDataByUsingName(String departmentName) {
		return departmentRepository.findByDepartmentName(departmentName);
	}
	
	
	
	

}
