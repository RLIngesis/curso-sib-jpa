package com.ingesis.cursoJpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ingesis.cursoJpa.dao.ClienteDao;
import com.ingesis.cursoJpa.dao.ProductoDao;
import com.ingesis.cursoJpa.entity.Categoria;
import com.ingesis.cursoJpa.entity.Cliente;
import com.ingesis.cursoJpa.entity.Producto;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ProductoService {
	
	private ProductoDao productoDao;
	
	@Autowired
	public ProductoService(ProductoDao productoDao) {
		this.productoDao = productoDao;
	}
	
	@Transactional(readOnly = true)
	public List<Producto> findByIdCategoria(Integer idCategoria){
		return productoDao.findByIdCategoria(idCategoria);
	}
	
	
	@Transactional(readOnly = true)
	public List<Producto> getProductoVendidosPorDepartamentos(Integer... departamento){
		return productoDao.getProductoVendidosPorDepartamentos(departamento);
	}

}
