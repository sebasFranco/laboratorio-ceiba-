package com.jsfrancor.springboot.app.service;

import java.util.List;

import com.jsfrancor.springboot.app.models.entity.Libro;

public interface ILibroService {

	
	public List<Libro> findAll();
	
	public void save(Libro libro);
	
	public Libro findOne(Long id);
	
	
}
