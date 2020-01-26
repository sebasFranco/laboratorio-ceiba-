package com.jsfrancor.springboot.app.testdatabuilder;

import com.jsfrancor.springboot.app.models.entity.Libro;

public class LibroTestDataBuilder {
	
	private static final long ID= 1;
	private static final String ISBN = "F01TSA0150";
	private static final String NOMBRE = "El principito";
	private static final int CANTIDAD = 1;
	
	private long id;
	private String isbn;
	private String nombre;
	private int cantidad;
	
	public LibroTestDataBuilder() {
		this.id = ID;
		this.isbn = ISBN;
		this.nombre = NOMBRE;
		this.cantidad = CANTIDAD;
		
	}
	
	public LibroTestDataBuilder conId(long id) {
		this.id=id;
		return this;
	}
	
	public LibroTestDataBuilder conIsbn(String isbn) {
		this.isbn=isbn;
		return this;
	}
	
	public LibroTestDataBuilder conNombre(String nombre) {
		this.nombre=nombre;
		return this;
	}
	
	public LibroTestDataBuilder conCantidad(int cantidad) {
		this.cantidad=cantidad;
		return this;
	}
	
	public Libro build() {
		return new Libro(this.id, this.isbn, this.nombre,this.cantidad);
	}
}