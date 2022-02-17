package com.ingesis.cursoJpa.logic;

import java.util.Random;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ingesis.cursoJpa.converter.ProductoConverter;
import com.ingesis.cursoJpa.dto.ProductoDto;
import com.ingesis.cursoJpa.entity.Producto;
import com.ingesis.cursoJpa.entity.ProductoPK;
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
		producto.setIdProducto(obtenerNuevoIdProducto());
		producto = productoService.crear(producto);
		return productoConverter.toDTO(producto);
	}
	
	public ProductoDto buscarPorId(Integer idProducto, Integer idCategoria) {
		ProductoConverter productoConverter = new ProductoConverter();
		Producto producto = productoService.buscarPorId(new ProductoPK(idProducto, idCategoria));
		ProductoDto productoDto = productoConverter.toDTO(producto);
		return productoDto;
	}
	
	private Integer obtenerNuevoIdProducto() {
		Random random = new Random();
		return random.nextInt(100*3);
	}
	
}
