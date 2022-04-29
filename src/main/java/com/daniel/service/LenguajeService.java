package com.daniel.service;

import java.util.List;

import com.daniel.entity.Lenguaje;

public interface LenguajeService {
	
	public List<Lenguaje> findAll();
	
	public void saveLenguaje(Lenguaje lenguaje);
	
	public Lenguaje findLenguajeById(Lenguaje lenguaje);

}
