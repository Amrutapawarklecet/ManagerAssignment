package com.ul.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ul.api.domain.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

	public List<Project> findByArchivedTrue();
	public List<Project> findByArchivedFalse();
}
