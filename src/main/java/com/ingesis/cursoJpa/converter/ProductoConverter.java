package com.ingesis.cursoJpa.converter;

import com.ingesis.cursoJpa.converter.utils.AbstractConverter;
import com.ingesis.cursoJpa.dto.ProductoDto;
import com.ingesis.cursoJpa.entity.Producto;

public class ProductoConverter extends AbstractConverter<Producto, ProductoDto> {

	@Override
	public Producto toEntity(ProductoDto dto) {
		Producto producto = new Producto();
		producto.setIdProducto(dto.getIdProducto());
		producto.setCodigoProducto(dto.getCodigoProducto());
		producto.setIdCategoria(dto.getIdCategoria());
		producto.setDescripcion(dto.getDescripcion());
		producto.setUnidadMedida(dto.getUnidadMedida());
		
		return producto;
	}

	@Override
	public ProductoDto toDTO(Producto entity) {
		ProductoDto productoDto = new ProductoDto();
		productoDto.setIdProducto(entity.getIdProducto());
		productoDto.setIdCategoria(entity.getIdCategoria());
		productoDto.setDescripcion(entity.getDescripcion());
		productoDto.setUnidadMedida(entity.getUnidadMedida());
		productoDto.setCodigoProducto(entity.getCodigoProducto());
		
		return productoDto;
	}
	
}
