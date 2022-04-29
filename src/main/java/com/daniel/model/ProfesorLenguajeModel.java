package com.daniel.model;

import com.daniel.entity.Lenguaje;
import com.daniel.entity.Profesor;

public class ProfesorLenguajeModel {
	
	private Profesor profesor;
	
	private Lenguaje lenguaje;

	public ProfesorLenguajeModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProfesorLenguajeModel(Profesor profesor, Lenguaje lenguaje) {
		super();
		this.profesor = profesor;
		this.lenguaje = lenguaje;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Lenguaje getLenguaje() {
		return lenguaje;
	}

	public void setLenguaje(Lenguaje lenguaje) {
		this.lenguaje = lenguaje;
	}
	
	
	
}
