package com.ingesis.cursoJpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ingesis.cursoJpa.dto.ProductoDto;
import com.ingesis.cursoJpa.entity.Producto;
import com.ingesis.cursoJpa.logic.ProductoLogic;
import com.ingesis.cursoJpa.service.ProductoService;

@RestController
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private ProductoLogic productoLogic;

	
	@GetMapping("api/v1/findByIdCategoria")
	public List<Producto> getClientes(Integer idCategoria) {
		return productoService.findByIdCategoria(idCategoria);
	}
	
	@GetMapping("api/v1/producto/buscarPorIdProducto")
	public ProductoDto bucarPorIdProducto(Integer idProducto, Integer idCategoria) {
		return productoLogic.buscarPorId(idProducto,idCategoria);
	}
	
	
	@PostMapping("api/v1/producto/crear")
	public ProductoDto crear(@RequestBody ProductoDto producto) {
		return productoLogic.crear(producto);
	}
	
}
