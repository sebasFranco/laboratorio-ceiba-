package com.jsfrancor.springboot.app.service;

import java.util.List;

import com.jsfrancor.springboot.app.models.entity.Prestamo;

public interface IPrestamoService {
	
	public List<Prestamo> findAll();
	
	public void save(Prestamo prestamo);
	
}
