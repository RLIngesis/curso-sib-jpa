package com.ingesis.cursoJpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
@NamedQueries({
	@NamedQuery(name="Inventario.findInventarioByIdProducto", query="SELECT i FROM Inventario i WHERE i.inventarioId.idProducto=:idProducto"),

	@NamedQuery(name="Inventario.getTotalQuantityByIdProducto", 
				query="SELECT NEW com.ingesis.cursoJpa.auxs.InventarioAux(p.descripcion,sum(i.cantidad),sum(i.precio)) FROM Inventario i, Producto p "
				    + " WHERE i.inventarioId.idProducto = p.idProducto"
				    + "   and i.inventarioId.idProducto=:idProducto "),
})
@Data
@Entity
@Table(name="INVENTARIO")
public class Inventario implements Serializable {
	
	@EmbeddedId
	private InventarioPK inventarioId;
	
	@Column(name="cantidad", nullable = false)
	private Integer cantidad;
	
	@Column(name="precio", nullable=false)
	private double precio;
}
