package com.jsfrancor.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "libros")
public class Libro implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String isbn;
	
	@NotEmpty
	private String nombre;
	
	private int cantidad;

	private static final long serialVersionUID = 1L;
	
	public Libro(){

	}
	
	public Libro(Long id, @NotEmpty String isbn, @NotEmpty String nombre, int cantidad) {
		this.id = id;
		this.isbn = isbn;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
