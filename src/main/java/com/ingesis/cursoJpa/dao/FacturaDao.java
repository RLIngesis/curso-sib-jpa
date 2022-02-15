package com.ingesis.cursoJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ingesis.cursoJpa.entity.Factura;

@Repository
public class FacturaDao {
	
	@PersistenceContext
	EntityManager em;
	
	public Factura getFacturaById(Integer idFactura) {
		Query query = em.createNamedQuery("getFacturaById")
						.setParameter("idFacturaParam", idFactura);
		
		List<Factura> facturas = query.getResultList();
		Factura factura;
		if(null!=facturas && facturas.size() >0) {
			factura = facturas.get(0);
		}else {
			factura = new Factura();
		}
		return factura;
	}
	
}
