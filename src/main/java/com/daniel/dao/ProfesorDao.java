package com.daniel.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.daniel.entity.Profesor;

public interface ProfesorDao extends CrudRepository<Profesor, Long> {
	
	public Profesor findByEmail(String email);
	
	public Profesor findByEmailAndPassword(String email, String password);
	
	@Query("SELECT p from Profesor p where p.nombre LIKE %:name%")
	public List<Profesor> findByNombreLike(@Param("name") String name);
	
	public Optional<Profesor> findById(Long id);
	
	@Query("SELECT p from Profesor p where p.id = ?1")
	public Optional<Profesor> findByIdSQL(Long id);
	
}
