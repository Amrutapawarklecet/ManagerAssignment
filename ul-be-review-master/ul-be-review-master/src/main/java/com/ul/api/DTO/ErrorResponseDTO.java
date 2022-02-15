package com.ul.api.DTO;

public class ErrorResponseDTO<T> {
private T message;
	
	public T getMessage() {
		return message;
	}

	public void setMessage(T message) {
		this.message = message;
	}

	public ErrorResponseDTO(T message) {
		this.message = message;
	}

}
