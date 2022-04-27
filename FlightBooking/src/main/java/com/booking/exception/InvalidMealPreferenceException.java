package com.booking.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidMealPreferenceException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public InvalidMealPreferenceException(String message) {
		super(message);
	}

}
