package com.ul.api.service;

import java.util.List;

import com.ul.api.DTO.ProjectDTO;
import com.ul.api.domain.Project;

public interface ProjectService {
	
	ProjectDTO createProject(ProjectDTO projectData);

	List<ProjectDTO> nonArchivedProject();

	ProjectDTO archiveProject(Long id);
	
	ProjectDTO stausProject(Long id);

}
