package com.ingesis.cursoJpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ingesis.cursoJpa.dao.DepartamentoDao;
import com.ingesis.cursoJpa.dao.SucursalDao;
import com.ingesis.cursoJpa.entity.Municipio;
import com.ingesis.cursoJpa.entity.Sucursal;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class SucursalService {

	private final SucursalDao sucursalDao;

	@Autowired
	public SucursalService(SucursalDao sucursalDao) {
		this.sucursalDao = sucursalDao;
	}

	
	 public Sucursal findSucursalById(Integer idSucursal) {
		 return sucursalDao.findSucursalById(idSucursal); 
	 }
	 
}
