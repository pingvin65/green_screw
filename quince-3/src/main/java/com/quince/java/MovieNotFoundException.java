package com.quince.java;

public class MovieNotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	public MovieNotFoundException(long id) {
        super(String.format("Book is not found with id : '%s'", id));
        }
	
	
}
