package com.daniel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.dao.CursoDao;
import com.daniel.entity.Curso;
import com.daniel.service.CursoService;

@RestController
@RequestMapping("/api/v1")
public class CursoController {

	@Autowired
	private CursoService cursoService;

	@GetMapping("/cursos")
	public ResponseEntity<?> getCursos() {
		List<Curso> cursos = cursoService.findAll();
		if (cursos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(cursos, HttpStatus.OK);
	}

	@PostMapping("/cursos")
	public ResponseEntity<?> createCurso(@RequestBody Curso curso) {
		cursoService.saveCurso(curso);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping("/cursos/{id_profesor}")
	public ResponseEntity<?> getCursosByProfesor(@PathVariable("id_profesor") Long idProfesor) {
		List<Curso> cursos = cursoService.getCursoProfesor(idProfesor);
		if (cursos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(cursos, HttpStatus.OK);
	}
}
