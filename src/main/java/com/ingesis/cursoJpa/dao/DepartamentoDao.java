package com.ingesis.cursoJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.ingesis.cursoJpa.entity.Departamento;
import com.ingesis.cursoJpa.entity.Municipio;

@Component
public class DepartamentoDao {

	@PersistenceContext
	EntityManager em;
	
	
	public List<Municipio> findMunicipiosByDepartamento(Integer idDepartamento) {
		Departamento d = this.em.find(Departamento.class, idDepartamento);
		return d.getMunicipios();
	}
	
}
