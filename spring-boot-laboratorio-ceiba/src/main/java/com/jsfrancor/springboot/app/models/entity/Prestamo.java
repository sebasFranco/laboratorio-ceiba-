package com.jsfrancor.springboot.app.models.entity;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "prestamos")
public class Prestamo {
	
	@Id
	private int id;
	
	@NotEmpty
	private String nombrePersona;
	
	@NotEmpty
	private String isbnLibro;
	
	@NotEmpty
	@Column(name = "fecha_prestamo")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaPrestamo;
	
	@Column(name = "fecha_entrega_maxima")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaEntregaMaxima;

	
	@PrePersist
	public void prePersist() {
		fechaPrestamo = new Date();
	}
	
	/*Genera la fecha de entrega de los libros palindromos
	 * Entra Fecha de prestamos - LocalDate
	 * Sale Fecha de entrega - LocalDate
	 * */
	public LocalDate generarFechaEntrega (LocalDate fecha) {
		
		for(int i=0; i<15; i++){
    		if(fecha.getDayOfWeek()== DayOfWeek.SUNDAY){
    			i--;
        	}
    		fecha = fecha.plusDays(1);
    	}
		
		return fecha;	
	}
	
	/*Valia si el ISBN del libro es palindromo
	 * Sale True si el libro es palindromo - False si no lo es
	 * */
	public boolean validarPalindromo(String ISBN) {
			
		List<Character> list = new ArrayList<>();
		for (char ch: ISBN.toCharArray()) {
			list.add(ch);
		}
		
		int centro = (int)(list.size()/2);
		
		for (int i = 0; i < centro; i++) {
			if (list.get(i) != list.get(list.size()-i-1)){
				return false;
			}
		}
		
		return true;
	}
	
	/*Valia si el ISBN del libro suma mas de 30
	 * Sale True si el libro sumas mas de 30 - False si es menos de 30
	 * */
	public boolean sumaNumISBN(String ISBN) {
		
		List<Character> list = new ArrayList<>();
		for (char ch: ISBN.toCharArray()) {
			list.add(ch);
		}
		
		int sumaISBN;
		
		for (int i = 0; i < list.size(); i++) {
			int c = (int)list.get(i);
			if (c>48 && c<58){
				sumaISBN += (c-48);
			}
		}
		return sumaISBN>30;
	}
	
	
	//Get and Setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public String getIsbnLibro() {
		return isbn;
	}

	public void setIsbnLibro(String isbnLibro) {
		this.isbn = isbnLibro;
	}

	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public Date getFechaEntregaMaxima() {
		return fechaEntregaMaxima;
	}

	public void setFechaEntregaMaxima(Date fechaEntregaMaxima) {
		this.fechaEntregaMaxima = fechaEntregaMaxima;
	}

}
