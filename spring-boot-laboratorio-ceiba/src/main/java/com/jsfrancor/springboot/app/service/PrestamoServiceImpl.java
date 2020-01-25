package com.jsfrancor.springboot.app.service;

import java.util.List;

import javax.transaction.Transactional;

import com.jsfrancor.springboot.app.dao.IPrestamoDao;
import com.jsfrancor.springboot.app.models.entity.Prestamo;

public class PrestamoServiceImpl implements IPrestamoService{

	private IPrestamoDao prestamoDao; 
	
	@Override
	@Transactional
	public List<Prestamo> findAll() {
		return (List<Prestamo>) prestamoDao.findAll();
	}

	@Override
	@Transactional
	public void save(Prestamo prestamo) {
		prestamoDao.save(prestamo);
	}

}
