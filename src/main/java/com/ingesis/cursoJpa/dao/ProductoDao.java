package com.ingesis.cursoJpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ingesis.cursoJpa.entity.Producto;
import com.ingesis.cursoJpa.entity.ProductoPK;

@Repository
public class ProductoDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Producto> findByIdCategoria(Integer idCategoria){
		Query query = em.createNamedQuery("findByIdCategoria")
						.setParameter("idCategoria", idCategoria);
		List<Producto> productos = query.getResultList();
		if(null==productos || productos.size()==0) {
			productos = new ArrayList<>();
		}

		return productos;
	}
	
	public Producto buscarPorId(ProductoPK productoPK){
		return em.find(Producto.class, productoPK);
	}
	
	public Producto crear(Producto producto) {
		em.persist(producto);
		return producto;
	}
	
	public void modificar(Integer idProducto, Integer idCategoria,String desripcionProducto) {
		Producto producto = buscarPorId(new ProductoPK(idProducto, idCategoria));
		producto.setDescripcion(desripcionProducto);
	}
}
