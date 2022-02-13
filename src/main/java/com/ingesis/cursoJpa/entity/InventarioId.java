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
	
	@Column(name="id_inventario")
	private Integer idInventario;
	
	@Column(name="id_producto")
	private Integer idProducto;
	
	@Column(name="id_categoria")
	private Integer idCategoria;
	
}
