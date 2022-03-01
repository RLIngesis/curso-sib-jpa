package com.ingesis.cursoJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.ingesis.cursoJpa.entity.Sucursal;

@Component
public class SucursalDao {

	@PersistenceContext
	EntityManager em;
	
	
	public Sucursal findSucursalById(Integer idSucursal) {
		Sucursal sucursal = this.em.find(Sucursal.class, idSucursal);
		return sucursal;
	}
	
}
