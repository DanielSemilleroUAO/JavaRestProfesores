package com.daniel.service;

import java.util.List;

import com.daniel.entity.Curso;

public interface CursoService {
	
	public List<Curso> findAll();
	
	public void saveCurso(Curso curso);
	
	public List<Curso> getCursoProfesor(Long id);
	
}
