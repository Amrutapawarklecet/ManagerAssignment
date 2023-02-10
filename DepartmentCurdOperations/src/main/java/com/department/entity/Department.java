package com.department.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//To make a particular class as an entity so we can annonate with entity .
@Entity
@Getter
@Setter
@NoArgsConstructor //default constructor
@AllArgsConstructor //paramiterized constructor 
@ToString
public class Department {
	
	@Id //To make as a primary key 
	@GeneratedValue(strategy= GenerationType.AUTO) //how you want to generate the primary key
	private Long departmentId;
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;
	
}
