package com.ul.api.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ul.api.util.statusEnum;

@Entity
@Table(name = "project")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)

	private Long id;
	private String name;
	private LocalDateTime dateCreated;
	private boolean archived;
	private statusEnum status;

	public Project() {

	}

	public Project(Long id, String name, LocalDateTime dateCreated, boolean archived, statusEnum status) {
		super();
		this.id = id;
		this.name = name;
		this.dateCreated = dateCreated;
		this.archived = archived;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public boolean isArchived() {
		return archived;
	}

	public void setArchived(boolean archived) {
		this.archived = archived;
	}

	public statusEnum getStatus() {
		return status;
	}

	public void setStatus(statusEnum inProgress) {
		this.status = inProgress;
	}

}
