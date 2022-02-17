package com.ingesis.cursoJpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingesis.cursoJpa.dao.ProductoDao;
import com.ingesis.cursoJpa.entity.Producto;
import com.ingesis.cursoJpa.entity.ProductoPK;

@Service
@Transactional
public class ProductoService {
	
	private ProductoDao productoDao;
	
	@Autowired
	public ProductoService(ProductoDao productoDao) {
		this.productoDao = productoDao;
	}
	
	public List<Producto> findByIdCategoria(Integer idCategoria){
		return productoDao.findByIdCategoria(idCategoria);
	}

	public Producto buscarPorId(ProductoPK productoPk){
		return productoDao.buscarPorId(productoPk);
	}

	public Producto crear(Producto producto) {
		return productoDao.crear(producto);
	}

	public void modificar(Integer idProducto, Integer idCategoria,String descripcion) {
		productoDao.modificar(idProducto, idCategoria, descripcion);
	}

}
