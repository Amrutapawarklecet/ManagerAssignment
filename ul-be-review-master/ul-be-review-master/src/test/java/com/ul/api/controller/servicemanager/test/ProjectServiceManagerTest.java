package com.ul.api.controller.servicemanager.test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.modelmapper.ModelMapper;

import com.ul.api.DTO.ProjectDTO;
import com.ul.api.domain.Project;
import com.ul.api.repository.ProjectRepository;
import com.ul.api.service.ProjectServiceImpl;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class ProjectServiceManagerTest {

	@InjectMocks
	private ProjectServiceImpl projectServiceImpl;
	@Mock
	private ProjectRepository projectRepository;
	@Mock
	private ModelMapper modelMaper;

	@Test
	public void createProjectTest() {
		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setArchived(false);
		LocalDateTime dateCreated = LocalDateTime.now();
		projectDTO.setDateCreated(dateCreated);
		projectDTO.setName("Test");
		projectDTO.setId((long) 111111111);

		ProjectDTO projectactual = new ProjectDTO();
		projectactual.setArchived(false);
		projectactual.setDateCreated(dateCreated);
		projectactual.setName("Test");
		projectactual.setId((long) 111111111);

		Mockito.lenient().when(projectServiceImpl.createProject(projectDTO)).thenReturn(projectactual);

	}

	@Test
	public void nonArchivedProjectTest() {
		List<ProjectDTO> nonArchivedProjects = new ArrayList<>();
		LocalDateTime dateCreated = LocalDateTime.now();
		ProjectDTO projectactual = new ProjectDTO();
		projectactual.setArchived(false);
		projectactual.setDateCreated(dateCreated);
		projectactual.setName("Test");
		projectactual.setId((long) 111111111);
		nonArchivedProjects.add(projectactual);

		Mockito.lenient().when(projectServiceImpl.nonArchivedProject()).thenReturn(nonArchivedProjects);

	}

	@Test
	public void archiveProjectTest() {
		Optional<Project> projectDataOptional = Optional.ofNullable(new Project());
		Mockito.lenient().when(projectRepository.findById((long) 112)).thenReturn(projectDataOptional);
		LocalDateTime dateCreated = LocalDateTime.now();
		ProjectDTO projectactual = new ProjectDTO();
		projectactual.setArchived(false);
		projectactual.setDateCreated(dateCreated);
		projectactual.setName("Test");
		projectactual.setId((long) 112);
		Mockito.lenient().when(projectServiceImpl.archiveProject((long) 112)).thenReturn(projectactual);
	}
}
