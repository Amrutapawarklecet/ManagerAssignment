package com.ul.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ul.api.DTO.ErrorResponseDTO;


@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponseDTO<String>> handleResourceNotFound(ResourceNotFoundException ex) {
		ErrorResponseDTO<String> errorResponse = new ErrorResponseDTO<String>(ex.getMessage());

		return new ResponseEntity<ErrorResponseDTO<String>>(errorResponse, HttpStatus.NOT_FOUND);

	}

}
