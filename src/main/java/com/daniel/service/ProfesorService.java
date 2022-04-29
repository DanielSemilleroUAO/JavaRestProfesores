package com.daniel.service;

import java.util.List;
import java.util.Optional;

import com.daniel.entity.Profesor;

public interface ProfesorService {
	
	
	public List<Profesor> findAll();
	
	public Profesor findProfesor(Profesor profesor);
	
	public Profesor checkProfesorLogin(Profesor profesor);
	
	public void deleteProfesor(Profesor profesor);
	
	public Profesor updateProfesor(Profesor profesor);
	
	public Optional<Profesor> findProfesorById(Long id);
	
	public void deleteProfesor(Long id);
	
	public Profesor findById(Long id);
	
	public Profesor findByIdSQL(Long id);
	
	public void save(Profesor profesor);
	
	public List<Profesor> findProfesorByName(String name);
	
	
	public void deleteAllProfesores();

}
