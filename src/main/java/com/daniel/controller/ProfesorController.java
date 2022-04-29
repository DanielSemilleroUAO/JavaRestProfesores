package com.daniel.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.entity.Profesor;
import com.daniel.mapped.Mapper;
import com.daniel.model.ProfesorModel;
import com.daniel.service.ProfesorService;
import com.daniel.service.ProfesorServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class ProfesorController {
	
	Logger logger = LoggerFactory.getLogger(ProfesorController.class);
	
	@Autowired
	private ProfesorService profesorService;
	
	@GetMapping("/profesores")
	@ResponseStatus(HttpStatus.OK)
	public List<Profesor> getProfesores(){
		return profesorService.findAll();
	}
	
	@PostMapping("/sing_up")
	public ResponseEntity<Void> addProfesor(@RequestBody Profesor profesor){
		if(profesorService.findProfesor(profesor) == null) {
			profesorService.save(profesor);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	} 
	
	@GetMapping("/profesores/{name}")
	public ResponseEntity<List<Profesor>> getProfesoresByName(@PathVariable("name") String name){
		return new ResponseEntity<List<Profesor>>((List<Profesor>) profesorService.findProfesorByName(name), HttpStatus.OK);
	}
	
	@PutMapping("/profesores/{id}")
	public ResponseEntity<?> updateProfesor(@PathVariable("id") Long id, @RequestBody Profesor profesor){
		Profesor profesorDB = profesorService.findById(id);
		if( profesorDB != null) {
			profesorDB.setNombre(profesor.getNombre());
			profesorDB.setEmail(profesor.getEmail());
			profesorService.updateProfesor(profesorDB);
			return new ResponseEntity<>(profesorDB, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	} 
	
	
	@PutMapping("/update_sql")
	public ResponseEntity<?> updateProfesorSql(@RequestBody Profesor profesor){
		Profesor profesorDB = profesorService.findByIdSQL(profesor.getId());
		if( profesorDB != null) {
			profesorDB.setNombre(profesor.getNombre());
			profesorDB.setEmail(profesor.getEmail());
			profesorService.updateProfesor(profesorDB);
			return new ResponseEntity<>(profesorDB, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	} 
	
	
	@DeleteMapping("/profesores/{id}")
	public ResponseEntity<?> deleteProfesor(@PathVariable("id") Long id){
		if( profesorService.findById(id) != null) {
			profesorService.deleteProfesor(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	} 
	
	@DeleteMapping("/profesores")
	public ResponseEntity<?> deleteAllProfesor(){
		profesorService.deleteAllProfesores();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginProfesor(@RequestBody Profesor profesor){
		Profesor profesorDB = profesorService.checkProfesorLogin(profesor);
		if(profesorDB != null) {
			List<Profesor> profesores = new ArrayList<>();
			profesores.add(profesorDB);
			return new ResponseEntity<>(Mapper.convertirLista(profesores),HttpStatus.OK);
		} 
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	

}
