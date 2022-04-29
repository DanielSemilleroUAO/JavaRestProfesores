package com.daniel.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daniel.dao.ProfesorDao;
import com.daniel.entity.Profesor;

@Service
public class ProfesorServiceImpl implements ProfesorService{
	
	@Autowired
	private ProfesorDao profesorDao;
	
	Logger logger = LoggerFactory.getLogger(ProfesorServiceImpl.class);
	
	@Override
	@Transactional(readOnly = true)
	public List<Profesor> findAll() {
		// TODO Auto-generated method stub
		return (List<Profesor>) profesorDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Profesor findProfesor(Profesor profesor) {
		// TODO Auto-generated method stub
		return (Profesor) profesorDao.findByEmail(profesor.getEmail());
	}

	@Override
	@Transactional(readOnly = true)
	public Profesor checkProfesorLogin(Profesor profesor) {
		// TODO Auto-generated method stub
		logger.info(profesor.getEmail());
		logger.info(profesor.getPassword());
		return (Profesor) profesorDao.findByEmailAndPassword(profesor.getEmail(), profesor.getPassword());
	}

	@Override
	@Transactional
	public void deleteProfesor(Profesor profesor) {
		// TODO Auto-generated method stub
		profesorDao.deleteById(profesor.getId());
	}

	@Override
	@Transactional
	public Profesor updateProfesor(Profesor profesor) {
		// TODO Auto-generated method stub
		return (Profesor) profesorDao.save(profesor);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Profesor> findProfesorById(Long id) {
		// TODO Auto-generated method stub
		return profesorDao.findById(id);
	}

	@Override
	@Transactional
	public void deleteProfesor(Long id) {
		// TODO Auto-generated method stub
		profesorDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Profesor findById(Long id) {
		// TODO Auto-generated method stub
		return profesorDao.findByIdSQL(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Profesor findByIdSQL(Long id) {
		// TODO Auto-generated method stub
		return (Profesor) profesorDao.findByIdSQL(id).orElse(null);
	}

	@Override
	@Transactional
	public void save(Profesor profesor) {
		// TODO Auto-generated method stub
		profesorDao.save(profesor);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Profesor> findProfesorByName(String name) {
		// TODO Auto-generated method stub
		return profesorDao.findByNombreLike(name);
	}

	@Override
	@Transactional
	public void deleteAllProfesores() {
		// TODO Auto-generated method stub
		profesorDao.deleteAll();
		
	}

}
