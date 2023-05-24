package com.blog.app.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserNotFoundExpection extends RuntimeException{
	
	String resourceName;
	String fieldName;
	String fieldValue;
	public UserNotFoundExpection(String resourceName, String fieldName, String fieldValue) {
		super(String.format("%s is not found with %s:%s", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

}
