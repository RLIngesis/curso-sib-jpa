package com.ingesis.cursoJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.ingesis.cursoJpa.entity.Municipio;

@Component
public class MunicipioDao {

	@PersistenceContext
	EntityManager em;
	
	public List<Municipio> findAllByPais(Integer idPais) {
		Query q = this.em.createNamedQuery("Municipio.findAllByPais").setParameter("idPais", idPais);
		return q.getResultList();
	}
}
