package com.jsfrancor.springboot.app.dao;


import org.springframework.data.repository.CrudRepository;

import com.jsfrancor.springboot.app.models.entity.Libro;

public interface ILibroDao extends CrudRepository<Libro, Long>{
	
}
