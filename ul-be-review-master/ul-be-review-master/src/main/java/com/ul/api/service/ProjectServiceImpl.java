package com.ul.api.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ul.api.DTO.ProjectDTO;
import com.ul.api.domain.Project;
import com.ul.api.exception.ResourceNotFoundException;
import com.ul.api.repository.ProjectRepository;
import com.ul.api.util.statusEnum;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	ModelMapper modelMapper;

	public ProjectDTO createProject(ProjectDTO projectData) {
		LocalDateTime dateCreated = LocalDateTime.now();
		Project project = new Project(); // We can use builder pattern as well,but due time constraints implemented this
											// way
		project.setName(projectData.getName());
		project.setStatus(statusEnum.IN_PROGRESS);
		project.setDateCreated(dateCreated);
		project.setArchived(false);
		Project savedProject = projectRepository.save(project);
		return modelMapper.map(savedProject, ProjectDTO.class);
		 
	}

	public List<ProjectDTO> nonArchivedProject() {
		List<Project> nonArchivedProjects = projectRepository.findByArchivedFalse();
		return nonArchivedProjects.stream()
				.map(nonArchivedProject -> modelMapper.map(nonArchivedProject, ProjectDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public ProjectDTO archiveProject(Long id) {
		Optional<Project> projectData = projectRepository.findById(id);
		if (projectData.isPresent()) {
			Project updatedProject = projectData.get();
			updatedProject.setArchived(true);
			return modelMapper.map(projectRepository.save(updatedProject), ProjectDTO.class);
		}
		throw new ResourceNotFoundException("Project Details Not Found!!");

	}

	@Override
	public ProjectDTO stausProject(Long id) {
		Optional<Project> projectdata =projectRepository.findById(id);
		if(projectdata.isPresent()) {
			Project sProject=projectdata.get();
			sProject.setStatus(statusEnum.FINISHED);
			return modelMapper.map(projectRepository.save(sProject),ProjectDTO.class);
		}
		throw new ResourceNotFoundException("Project Details Not Found!!");
		
	}

}
