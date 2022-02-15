package com.ingesis.cursoJpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ingesis.cursoJpa.entity.Producto;

@Repository
public class ProductoDao {
	
	@PersistenceContext
	EntityManager em;
	
	public List<Producto> findByIdCategoria(Integer idCategoria){
		Query query = em.createNamedQuery("findByIdCategoria")
						.setParameter("idCategoria", idCategoria);
		List<Producto> productos = query.getResultList();
		if(null==productos || productos.size()==0) {
			productos = new ArrayList<>();
		}

		return productos;
	}
}
