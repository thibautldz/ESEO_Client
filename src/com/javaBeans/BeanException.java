package com.javaBeans;

public class BeanException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BeanException(String message) {
        super(message);
        Ville ville = new Ville();
    }
}