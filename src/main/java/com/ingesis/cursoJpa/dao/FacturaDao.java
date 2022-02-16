package com.ingesis.cursoJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

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
	
	
	public List<Factura> getFacturasByCriteria(String nombreCliente, String telefono, String nit){
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Factura> cq = cb.createQuery(Factura.class);
		
		Root<Factura> emi = cq.from(Factura.class);
		
		CriteriaQuery<Factura> select = cq.select(emi);
		
		Expression where = null;
		
		if(nombreCliente != null && nombreCliente.length()>0) {
			Expression c1 = emi.get("cliente").get("nombre");
			Expression c2 = cb.literal("%"+nombreCliente+"%");
			
			Expression comparacion = cb.like(c1, c2);
			if(where==null) {
				where = comparacion;
			}
		}
		
		
		if(telefono != null && telefono.length()>0) {
			Expression c1 = emi.get("cliente").get("telefono");
			Expression c2 = cb.literal(telefono);
			
			Expression comparacion = cb.equal(c1, c2);
			if(where==null) {
				where = comparacion;
			}else {
				where = cb.and(where, comparacion);
			}
		}
		
		if(telefono != null && telefono.length()>0) {
			Expression c1 = emi.get("cliente").get("nit");
			Expression c2 = cb.literal(nit);
			
			Expression comparacion = cb.equal(c1, c2);
			if(where==null) {
				where = comparacion;
			}else {
				where = cb.or(where, comparacion);
			}
		}
		
		if (where!=null) {
			select.where(where);
		}
		
		
		TypedQuery<Factura> q = this.em.createQuery(select);
		List<Factura> listaFactuaras = q.getResultList();
		
		return listaFactuaras;
	}
	
	public List<Factura> getFacturasBySinCriteria(String nombreCliente, String telefono) {
		String select = "Select f "
						+ " From Cliente c, Factura f"
						+ " Where c.idCliente = f.idCliente ";
		
		String condiciones = "";
		if(nombreCliente != null && nombreCliente.length()>0) {
			condiciones = condiciones + " and c.nombre ='"+nombreCliente+"'";
		}
		
		if(telefono != null && telefono.length()>0) {
			condiciones = condiciones + " and c.telefono ='"+telefono+"'";
		}
		
		select = select + condiciones;
		
		TypedQuery<Factura> q = this.em.createQuery(select, Factura.class);
		
		List<Factura> listaFactuaras = q.getResultList();
		return listaFactuaras;
		
	}
	
}
