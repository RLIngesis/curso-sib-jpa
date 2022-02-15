package com.ingesis.cursoJpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ingesis.cursoJpa.dao.MunicipioDao;
import com.ingesis.cursoJpa.entity.Municipio;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class MunicipioService {
	
	
	private final MunicipioDao municipioDao;
	
	@Autowired
	public MunicipioService(MunicipioDao municipioDao) {
		this.municipioDao = municipioDao;
	}
	
	public List<Municipio> findAllByPais(Integer idPais) {
		return this.municipioDao.findAllByPais(idPais);
	}
}
