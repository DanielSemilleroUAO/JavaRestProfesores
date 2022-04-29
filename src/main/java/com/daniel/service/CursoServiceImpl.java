package com.daniel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daniel.dao.CursoDao;
import com.daniel.entity.Curso;

@Service
public class CursoServiceImpl implements CursoService{
	
	@Autowired
	private CursoDao cursoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Curso> findAll() {
		// TODO Auto-generated method stub
		return (List<Curso>) cursoDao.findAll();
	}

	@Override
	public void saveCurso(Curso curso) {
		// TODO Auto-generated method stub
		cursoDao.save(curso);
	}

	@Override
	public List<Curso> getCursoProfesor(Long id) {
		// TODO Auto-generated method stub
		return (List<Curso>) cursoDao.findByProfesorId(id);
	}

}
