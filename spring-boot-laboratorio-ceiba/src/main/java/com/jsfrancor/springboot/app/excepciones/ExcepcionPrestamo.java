package com.jsfrancor.springboot.app.excepciones;

public class ExcepcionPrestamo extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ExcepcionPrestamo(String message) {
		super(message);
	}
}