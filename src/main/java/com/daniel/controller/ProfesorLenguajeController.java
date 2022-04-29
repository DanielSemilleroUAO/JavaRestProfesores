package com.daniel.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.entity.Lenguaje;
import com.daniel.entity.Profesor;
import com.daniel.model.ProfesorLenguajeModel;
import com.daniel.service.LenguajeService;
import com.daniel.service.ProfesorService;

@RestController
@RequestMapping("api/v1")
public class ProfesorLenguajeController {

	@Autowired
	private LenguajeService lenguajeService;
	
	
	@Autowired
	private ProfesorService profesorService;
	
	@GetMapping("/lenguajes/{idProfesor}")
	public ResponseEntity<?> listaLenguajesProfesor(@PathVariable("idProfesor") Long idProfesor){
		Profesor profesorDB = profesorService.findById(idProfesor);
		if(profesorDB != null) {
			Collection<Lenguaje> listaLenguajes = profesorDB.getLenguajes();
			if(listaLenguajes.isEmpty()){
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(listaLenguajes, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
	}
	
	@PostMapping("/lenguajes/profesores")
	public ResponseEntity<?> saveLenguajeProfesor(@RequestBody ProfesorLenguajeModel profesor){
		Profesor profesorDB = profesorService.findById(profesor.getProfesor().getId());
		if(profesorDB != null) {
			Lenguaje lenguajeDB = lenguajeService.findLenguajeById(profesor.getLenguaje());
			profesorDB.getLenguajes().add(lenguajeDB);
			profesorService.save(profesorDB);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
	}
	
}
