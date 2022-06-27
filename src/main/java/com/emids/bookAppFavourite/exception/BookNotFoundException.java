package com.emids.bookAppFavourite.exception;


public class BookNotFoundException extends Exception {
	private String message;

	public BookNotFoundException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "BookNotFoundException [message=" + message + "]";
	}

}
