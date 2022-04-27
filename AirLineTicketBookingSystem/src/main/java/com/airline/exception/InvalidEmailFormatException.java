package com.airline.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidEmailFormatException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidEmailFormatException(String message) {
		super(message);
	}

}
