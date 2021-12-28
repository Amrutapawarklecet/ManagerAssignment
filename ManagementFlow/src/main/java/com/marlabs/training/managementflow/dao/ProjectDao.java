package com.marlabs.training.managementflow.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.marlabs.training.managementflow.entity.Project;

public interface ProjectDao extends CrudRepository<Project,Long>{
	
	List<Project> findByArchived(boolean archived);

	

}
