package com.ingesis.cursoJpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ingesis.cursoJpa.dao.DepartamentoDao;
import com.ingesis.cursoJpa.entity.Municipio;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class DepartamentoService {

	private final DepartamentoDao departamentoDao;
	
	@Autowired
	public DepartamentoService(DepartamentoDao departamentoDao) {
		this.departamentoDao = departamentoDao;
	}
	
	/*
	 * public List<Municipio> findMunicipiosByDepartamento(Integer idDepartamento) {
	 * return departamentoDao.findMunicipiosByDepartamento(idDepartamento); }
	 */
}
