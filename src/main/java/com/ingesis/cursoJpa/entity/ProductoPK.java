package com.ingesis.cursoJpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
public class ProductoPK implements Serializable {

	@Column(name="id_producto")
	private Integer idProducto;
	
	@Column(name="id_categoria")
	private Integer idCategoria;

	public ProductoPK(Integer idProducto, Integer idCategoria) {
		super();
		this.idProducto = idProducto;
		this.idCategoria = idCategoria;
	}
	
}
