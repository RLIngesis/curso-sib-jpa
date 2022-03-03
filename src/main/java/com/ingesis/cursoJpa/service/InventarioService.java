package com.ingesis.cursoJpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ingesis.cursoJpa.auxs.InventarioAux;
import com.ingesis.cursoJpa.dao.InventarioDao;
import com.ingesis.cursoJpa.entity.DetalleFactura;
import com.ingesis.cursoJpa.entity.Inventario;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class InventarioService {
	
	@Autowired
	private InventarioDao inventarioDao;
	
	@Transactional(readOnly=true)
	public Inventario getInventarioById(Integer idInventario) {
		return inventarioDao.getInventarioById(idInventario);
	}
	
	@Transactional(readOnly=true)
	public InventarioAux getTotalQuantityByIdProducto(Integer idProducto) {
		return inventarioDao.getTotalQuantityByIdProducto(idProducto);
	}

	@Transactional(readOnly=true)
	public List<Inventario> findInventarioByIdProducto(Integer idProducto){
		return inventarioDao.findInventarioByIdProducto(idProducto);
	}
	
	@Transactional
	public Inventario crearInventario(Inventario inventario) {
		return inventarioDao.crearInventario(inventario);
	}
	
	@Transactional
	public void registrarInventario(List<DetalleFactura> detalleFactura) {
		 inventarioDao.actualizarInventarioPorDetalleFactura(detalleFactura);
	}
	

}
