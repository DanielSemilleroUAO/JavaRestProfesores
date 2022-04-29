package com.daniel.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.daniel.entity.Curso;

public interface CursoDao extends CrudRepository<Curso, Long>{
	
	public List<Curso> findByProfesorId(Long id);

}
