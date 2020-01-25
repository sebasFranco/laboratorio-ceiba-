package com.jsfrancor.springboot.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.jsfrancor.springboot.app.models.entity.Prestamo;

public interface IPrestamoDao extends CrudRepository<Prestamo, Long>{

}
