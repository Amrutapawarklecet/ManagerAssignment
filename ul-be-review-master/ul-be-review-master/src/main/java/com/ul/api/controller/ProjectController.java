package com.ul.api.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ul.api.DTO.ProjectDTO;
import com.ul.api.service.ProjectServiceImpl;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author FL_LPT-250
 * 
 *
 */

@EnableSwagger2
@RestController
@RequestMapping("/api/v1/projectmanagment")
public class ProjectController {

	@Autowired
	private ProjectServiceImpl projectServiceImpl;
	public final static Logger LOGGER = LoggerFactory.getLogger(ProjectController.class);

	/**
	 * 
	 * @param projectDTO 
	 * creates a new project in Data Base with archived status
	 *                   false
	 * @return {@link ResponseEntity}
	 */

	@PostMapping("/projects")
	public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO projectDTO) {
		LOGGER.info("Start of createProject API");
		ProjectDTO savedProjectDTO = projectServiceImpl.createProject(projectDTO);
		return ResponseEntity.ok().body(savedProjectDTO);

	}

	/**
	 * Fetches all the projects with archived status false
	 * 
	 * @return {@link List}
	 */
	@GetMapping("/projects")
	public ResponseEntity<List<ProjectDTO>> getNonArchivedProjects() {
		LOGGER.info("Start of getNonArchivedProjects API");
		List<ProjectDTO> nonArchivedProject = projectServiceImpl.nonArchivedProject();
		return ResponseEntity.ok().body(nonArchivedProject);

	}

	/**
	 * 
	 * @param id changes project to archived.
	 * @return {@link ProjectDTO}
	 */
	@PutMapping("/projects/{id}")
	public ResponseEntity<ProjectDTO> archiveProject(@PathVariable Long id) {
		LOGGER.info("Start of archiveProject API");
		ProjectDTO archivedProjectDetails = projectServiceImpl.archiveProject(id);
		return ResponseEntity.ok().body(archivedProjectDetails);

	}
	
	@PutMapping("/projects/status/{id}")
	public ResponseEntity<ProjectDTO> stausProject(@PathVariable Long id){
		LOGGER.info("Start of  Status archiveProject API");
		ProjectDTO stausprojectDetails = projectServiceImpl.stausProject(id);
		return ResponseEntity.ok().body(stausprojectDetails);

	}

}
