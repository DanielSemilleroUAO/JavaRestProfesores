package com.daniel.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.daniel.entity.Lenguaje;

public interface LenguajeDao extends CrudRepository<Lenguaje, Long>{
	
	@Query("select l from Lenguaje l where l.id = ?1")
	public Lenguaje findByIdSQL(Long id);

}
