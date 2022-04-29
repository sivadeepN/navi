package com.example.exceptions;

public class InvalidInputException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidInputException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public InvalidInputException(String message)
	{
		super(message);
	}

}
