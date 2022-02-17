package com.ingesis.cursoJpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ingesis.cursoJpa.entity.Cliente;
import com.ingesis.cursoJpa.entity.Producto;
import com.ingesis.cursoJpa.logic.ClienteLogic;
import com.ingesis.cursoJpa.service.ClienteService;
import com.ingesis.cursoJpa.service.ProductoService;

@RestController
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	
	@GetMapping("api/v1/findByIdCategoria")
	public List<Producto> getProductos(Integer idCategoria) {
		return productoService.findByIdCategoria(idCategoria);
	}
	
	@GetMapping("api/v1/findBYVentasDep")
	public List<Producto> getProductosByVentasDep(Integer... departamento) {
		return productoService.getProductoVendidosPorDepartamentos(departamento);
	}
	
}
