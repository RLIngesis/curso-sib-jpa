package com.ingesis.cursoJpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import lombok.Data;

@Data
@Embeddable
public class InventarioId implements Serializable {
	
	@Column(name="idInventario")
	private Integer idInventario;
	
	@Column(name="idProducto")
	private Integer idProducto;
	
	@Column(name="idCategoria")
	private Integer idCategoria;
	
}
