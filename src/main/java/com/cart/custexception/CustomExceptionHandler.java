package com.cart.custexception;


public class CustomExceptionHandler extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomExceptionHandler(Exception s) {
        super(s);
        System.out.println(s);
    }
}