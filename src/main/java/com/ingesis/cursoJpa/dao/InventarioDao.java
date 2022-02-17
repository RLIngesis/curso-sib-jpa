package com.ingesis.cursoJpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ingesis.cursoJpa.auxs.InventarioAux;
import com.ingesis.cursoJpa.entity.Cliente;
import com.ingesis.cursoJpa.entity.DetalleFactura;
import com.ingesis.cursoJpa.entity.Factura;
import com.ingesis.cursoJpa.entity.Inventario;
import com.ingesis.cursoJpa.entity.InventarioPK;
import com.ingesis.cursoJpa.entity.Vendedor;

@Repository
public class InventarioDao {
	
	@PersistenceContext
	EntityManager em;
	
	public Inventario getInventarioById(Integer idInventario) {
		Inventario inventario = em.find(Inventario.class,idInventario);

		if(null == inventario) {
			inventario = new Inventario();
		}
		return inventario;
	}
	
	public Inventario crearInventario(Inventario inventario) {
		em.persist(inventario);
		em.flush();
		em.refresh(inventario);
		return inventario;
	}
	
	public List<Inventario> findInventarioByIdProducto(Integer idProducto){
		List<Inventario> listaInventario;
		Query q = em.createNamedQuery("Inventario.findInventarioByIdProducto");
			  q.setParameter("idProducto", idProducto);
		listaInventario = q.getResultList();
		
		if(null == listaInventario || listaInventario.size() == 0) {
			listaInventario = new ArrayList<>();
		}
		
		return listaInventario;
	}
	
	public InventarioAux getTotalQuantityByIdProducto(Integer idProducto){
		List<InventarioAux> listaInventario;
		InventarioAux inventarioAux = new InventarioAux();
		Query q = em.createNamedQuery("Inventario.getTotalQuantityByIdProducto");
			  q.setParameter("idProducto", idProducto);
		listaInventario = q.getResultList();
		
		if(null == listaInventario || listaInventario.size() == 0) {
			listaInventario = new ArrayList<>();
		}else {
			inventarioAux = listaInventario.get(0);
		}
		
		return inventarioAux;
	}
	
	public void actualizarInventarioPorDetalleFactura(List<DetalleFactura> detalleFactura) {
		if(null != detalleFactura && detalleFactura.size() > 0) {
			for(DetalleFactura detalle: detalleFactura) {
				Inventario inventario = new Inventario();
				InventarioPK inventarioPk = new InventarioPK();
				
				inventario.setCantidad(detalle.getCantidad()*-1);
				inventario.setPrecio(detalle.getPrecioUnitario());
				
				inventarioPk.setIdProducto(detalle.getDetalleFacturaId().getIdProducto());
				inventarioPk.setIdCategoria(detalle.getDetalleFacturaId().getIdCategoria());
				
				inventario.setInventarioId(inventarioPk);
				em.persist(inventario);
			}
		}
	}
	
}
