package com.ingesis.cursoJpa.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.ingesis.cursoJpa.entity.DetalleFactura;
import com.ingesis.cursoJpa.entity.Factura;
import com.ingesis.cursoJpa.entity.Factura_;

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
	
	public List<Factura> getFacturasByItemMonto(Double monto) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Factura> cq = cb.createQuery(Factura.class);
		
		Root<Factura> emi = cq.from(Factura.class);
		
		CriteriaQuery<Factura> select = cq.select(emi);
		
		Join<Factura, DetalleFactura> detalleFacturas = emi.join(Factura_.detalleFactura);
		
		Expression where = null;
		
		if(monto != null) {
			Expression c1 = detalleFacturas.get("precioUnitario");
			Expression c2 = cb.literal(monto);
			
			Expression comparacion = cb.ge(c1, c2);
			if(where==null) {
				where = comparacion;
			}
		}
		
		select.distinct(true);
		select.where(where);
		
		TypedQuery<Factura> q = this.em.createQuery(select);
		List<Factura> listaFactuaras = q.getResultList();
		
		return listaFactuaras;
	}
	
	public List<Factura> getFacturasByCriteriaLab( String fecha, String fechaFin, String nombre, String municipio, String vendedor, Integer... factura){
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Factura> cq = cb.createQuery(Factura.class);
		
		Root<Factura> emi = cq.from(Factura.class);
		
		CriteriaQuery<Factura> select = cq.select(emi);
		
		Expression where = null;
		
		if(nombre != null && nombre.length()>0) {
			Expression c1 = emi.get("cliente").get("nombre");
			Expression c2 = cb.literal("%"+nombre+"%");
			
			Expression comparacion = cb.like(c1, c2);
			if(where==null) {
				where = comparacion;
			} else {
				where = cb.and(where,comparacion);
			}
		}
		
		if(municipio != null && municipio.length()>0) {
			Expression c1 = emi.get("cliente").get("municipio").get("nombre");
			Expression c2 = cb.literal("%"+municipio+"%");
			
			Expression comparacion = cb.like(c1, c2);
			if(where==null) {
				where = comparacion;
			} else {
				where = cb.and(where,comparacion);
			}
		}
		
		if(vendedor != null && vendedor.length()>0) {
			Expression c1 = emi.get("Vendedor").get("nombre");
			Expression c2 = cb.literal("%"+vendedor+"%");
			
			Expression comparacion = cb.like(c1, c2);
			if(where==null) {
				where = comparacion;
			} else {
				where = cb.and(where,comparacion);
			}
		}
		
		if(factura != null && factura.length>0) {
			Expression c1 = emi.get("numeroFactura");
			Expression comparacion = c1.in(factura);
			
			if(where==null) {
				where = comparacion;
			} else {
				where = cb.and(where,comparacion);
			}
		}
		
		if((fecha==null || fecha.length()==0) && (fechaFin!=null && fechaFin.length()>0)) {
			Expression c1 = emi.get("fecha");
			Expression c2 = cb.literal(convertStringToDate(fechaFin));
			
			Expression comparacion = cb.le(c1, c2);
			
			if(where==null) {
				where = comparacion;
			} else {
				where = cb.and(where, comparacion);
			}
		} else if((fecha!=null && fecha.length()>0) && (fechaFin==null || fechaFin.length()==0)) {
			Expression c1 = emi.get("fecha");
			Expression c2 = cb.literal(convertStringToDate(fecha));
			
			Expression comparacion = cb.ge(c1, c2);
			
			if(where==null) {
				where = comparacion;
			} else {
				where = cb.and(where, comparacion);
			}
		} else if((fecha!=null && fecha.length()>0) && (fechaFin!=null && fechaFin.length()>0)) {
			Expression c1 = emi.get("fecha");
			Expression c2 = cb.literal(convertStringToDate(fecha));
			Expression c3 = cb.literal(convertStringToDate(fechaFin));
			
			Expression comparacion = cb.between(c1, c2, c3);
			
			if(where==null) {
				where = comparacion;
			} else {
				where = cb.and(where, comparacion);
			}
		}
		
		if (where!=null) {
			select.where(where);
		}
		
		select.orderBy(cb.asc(emi.get("cliente").get("nit")));
		
		TypedQuery<Factura> q = this.em.createQuery(select);
		List<Factura> listaFactuaras = q.getResultList();
		
		return listaFactuaras;
	}
	
	public List<Factura> getFacturasByCriteria(String nombreCliente, String telefono, String nit, String fecha, String fechafin){
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
			} else {
				where = cb.and(where, comparacion);
			}
		}
		
		if(nit != null && nit.length()>0) {
			Expression c1 = emi.get("cliente").get("nit");
			Expression c2 = cb.literal(nit);
			
			Expression comparacion = cb.equal(c1, c2);
			if(where==null) {
				where = comparacion;
			} else {
				where = cb.or(where, comparacion);
			}
		}
		
		
		if((fecha==null || fecha.length()==0) && (fechafin!=null && fechafin.length()>0)) {
			Expression c1 = emi.get("fecha");
			Expression c2 = cb.literal(convertStringToDate(fechafin));
			
			Expression comparacion = cb.le(c1, c2);
			
			if(where==null) {
				where = comparacion;
			} else {
				where = cb.and(where, comparacion);
			}
		} else if((fecha!=null && fecha.length()>0) && (fechafin==null || fechafin.length()==0)) {
			Expression c1 = emi.get("fecha");
			Expression c2 = cb.literal(convertStringToDate(fecha));
			
			Expression comparacion = cb.ge(c1, c2);
			
			if(where==null) {
				where = comparacion;
			} else {
				where = cb.and(where, comparacion);
			}
		} else if((fecha!=null && fecha.length()>0) && (fechafin!=null && fechafin.length()>0)) {
			Expression c1 = emi.get("fecha");
			Expression c2 = cb.literal(convertStringToDate(fecha));
			Expression c3 = cb.literal(convertStringToDate(fechafin));
			
			Expression comparacion = cb.between(c1, c2, c3);
			
			if(where==null) {
				where = comparacion;
			} else {
				where = cb.and(where, comparacion);
			}
		}
		
		if (where!=null) {
			select.where(where);
		}
		
		select.orderBy(cb.asc(emi.get("cliente").get("nit")));
		
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
	
	public static Date convertStringToDate(String fecha) {

        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
        Date retFecha = null;

        try {
            retFecha = formatoDelTexto.parse(fecha);
        } catch (ParseException ex) {
            return retFecha;
        }

        return retFecha;
    }
	
}
