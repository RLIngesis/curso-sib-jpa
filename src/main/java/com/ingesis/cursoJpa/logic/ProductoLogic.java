package com.ingesis.cursoJpa.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ingesis.cursoJpa.converter.ProductoConverter;
import com.ingesis.cursoJpa.dto.ProductoDto;
import com.ingesis.cursoJpa.entity.Producto;
import com.ingesis.cursoJpa.service.ProductoService;

@Component
public class ProductoLogic {

	private ProductoService productoService;
	
	
	@Autowired
	public ProductoLogic(ProductoService productoService) {
		this.productoService = productoService;
	}
	
	
	public ProductoDto crear(ProductoDto productoDto) {
		ProductoConverter productoConverter = new ProductoConverter();
		Producto producto = productoConverter.toEntity(productoDto);
		producto = productoService.crear(producto);
		return productoConverter.toDTO(producto);
	}
	
	public ProductoDto buscarPorId(Integer idProducto) {
		ProductoConverter productoConverter = new ProductoConverter();
		Producto producto = productoService.buscarPorId(idProducto);
		ProductoDto productoDto = productoConverter.toDTO(producto);
		return productoDto;
	}
	
}
