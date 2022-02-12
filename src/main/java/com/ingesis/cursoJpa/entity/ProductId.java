package com.ingesis.cursoJpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
public class ProductId implements Serializable {

	@Column(name="idProducto")
	private Integer idProducto;
	
	@Column(name="idCategoria")
	private Integer idCategoria;
}
