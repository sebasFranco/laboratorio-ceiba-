package com.jsfrancor.springboot.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsfrancor.springboot.app.dao.IPrestamoDao;
import com.jsfrancor.springboot.app.models.entity.Prestamo;

@Service
public class PrestamoServiceImpl implements IPrestamoService{

	@Autowired
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
