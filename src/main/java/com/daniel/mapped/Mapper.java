package com.daniel.mapped;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.daniel.entity.Profesor;
import com.daniel.model.ProfesorModel;

@Component("mapper")
public class Mapper {

	public static List<ProfesorModel> convertirLista(List<Profesor> profesores) {
		List<ProfesorModel> profesoresModelo = new ArrayList<>();
		for (Profesor profesor : profesores) {
			profesoresModelo.add(new ProfesorModel(profesor));
		}
		return profesoresModelo;
	}

}
