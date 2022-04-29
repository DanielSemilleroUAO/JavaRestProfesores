package com.daniel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.service.LenguajeService;
import com.daniel.entity.Lenguaje;


@RestController
@RequestMapping("/api/v1")
public class LneguajeController {

	@Autowired
	private LenguajeService lenguajeService;
	
	@GetMapping("/lenguajes")
	public ResponseEntity<?> listaLenguajes(){
		List<Lenguaje> lenguajes = lenguajeService.findAll();
		if(lenguajes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(lenguajes, HttpStatus.OK);
	}
	
	@PostMapping("/lenguajes")
	public ResponseEntity<?> crearLenguaje(@RequestBody Lenguaje lenguaje){
		lenguajeService.saveLenguaje(lenguaje);
		return new ResponseEntity<>(lenguaje, HttpStatus.CREATED);
	}
 	
}
