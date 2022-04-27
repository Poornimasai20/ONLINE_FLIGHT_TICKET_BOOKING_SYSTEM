package com.booking.exception;

public class NoSuchPassengerIdException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	public NoSuchPassengerIdException(String msg) {
		super(msg);
	}
}
