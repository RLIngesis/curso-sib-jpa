package com.ingesis.cursoJpa.dto;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ingesis.cursoJpa.entity.Categoria;

import lombok.Data;

@Data
public class ProductoDto {
	
	private Integer idProducto;
	private Integer idCategoria; 
	private String codigoProducto;
	private String descripcion;
	private String unidadMedida;

}
