package com.booking.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidPassportException extends RuntimeException {


	private static final long serialVersionUID = 1L;
	
	public InvalidPassportException(String message) {
		super(message);
	}
}