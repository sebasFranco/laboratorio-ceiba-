package com.jsfrancor.springboot.app.models.entity;

import java.util.Date;

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
		return isbnLibro;
	}

	public void setIsbnLibro(String isbnLibro) {
		this.isbnLibro = isbnLibro;
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
