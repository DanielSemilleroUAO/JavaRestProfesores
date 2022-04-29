package com.daniel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daniel.dao.LenguajeDao;
import com.daniel.entity.Lenguaje;

@Service
public class LenguajeServiceImpl implements LenguajeService {
	
	@Autowired
	private LenguajeDao lenguajeDao;

	@Override
	@Transactional(readOnly = true)
	public List<Lenguaje> findAll() {
		// TODO Auto-generated method stub
		return (List<Lenguaje>) lenguajeDao.findAll();
	}

	@Override
	@Transactional
	public void saveLenguaje(Lenguaje lenguaje) {
		// TODO Auto-generated method stub
		lenguajeDao.save(lenguaje);
	}

	@Override
	public Lenguaje findLenguajeById(Lenguaje lenguaje) {
		// TODO Auto-generated method stub
		return lenguajeDao.findByIdSQL(lenguaje.getId());
	}

}
