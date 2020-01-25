package com.jsfrancor.springboot.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.jsfrancor.springboot.app.dao.ILibroDao;
import com.jsfrancor.springboot.app.models.entity.Libro;

public class LibroServiceImpl implements ILibroService{

	@Autowired
	private ILibroDao libroDao;
	
	@Override
	@Transactional
	public List<Libro> findAll() {
		return (List<Libro>) libroDao.findAll();
	}

	@Override
	@Transactional
	public void save(Libro libro) {
		libroDao.save(libro);		
	}

	@Override
	@Transactional
	public Libro findOne(Long id) {
		libroDao.findById(id);
		return null;
	}

}
