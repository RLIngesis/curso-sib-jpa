package com.ingesis.cursoJpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import org.springframework.stereotype.Repository;

import com.ingesis.cursoJpa.entity.Categoria;
import com.ingesis.cursoJpa.entity.Cliente;
import com.ingesis.cursoJpa.entity.DetalleFactura;
import com.ingesis.cursoJpa.entity.DetalleFactura_;
import com.ingesis.cursoJpa.entity.Factura;
import com.ingesis.cursoJpa.entity.Factura_;
import com.ingesis.cursoJpa.entity.Producto;
import com.ingesis.cursoJpa.entity.Producto_;

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
	
	public List<Producto> getProductoVendidosPorDepartamentos(Integer... departamentos) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Producto> cq = cb.createQuery(Producto.class);
		
		Root<Producto> emi = cq.from(Producto.class);
		CriteriaQuery<Producto> select = cq.select(emi);
		
		Subquery<DetalleFactura> detalleSubquery = cq.subquery(DetalleFactura.class);
		Root<DetalleFactura> detalleEmi = detalleSubquery.from(DetalleFactura.class);
		
		Expression detalleWhere = null;
		
		if(departamentos!=null && departamentos.length>0) {
			Expression c1 = detalleEmi.get("factura").get("cliente").get("municipio").get("departamento").get("idDepartamento");
			Expression comparacion = c1.in(departamentos);
			
			detalleWhere = comparacion;
		}
		
		Expression prdDetalle = detalleEmi.get("detalleFacturaId").get("idProducto");
		Expression prd = emi.get("idProducto");
		Expression comparacionPrd = cb.equal(prdDetalle, prd);
		
		detalleWhere = cb.and(detalleWhere, comparacionPrd);
		
		Expression catDetalle = detalleEmi.get("detalleFacturaId").get("idCategoria");
		Expression cat = emi.get("idCategoria");
		Expression comparacionCat = cb.equal(catDetalle, cat);
		
		detalleWhere = cb.and(detalleWhere, comparacionCat);
		
		detalleSubquery.select(detalleEmi)
						.where(detalleWhere);
		
		Expression where = null;
		
		where = cb.exists(detalleSubquery);
		select.where(where);
		
		TypedQuery<Producto> q = this.em.createQuery(select);
		List<Producto> listProductos = q.getResultList();
		
		return listProductos;
	}
}
