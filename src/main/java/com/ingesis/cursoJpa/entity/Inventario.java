package com.ingesis.cursoJpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="INVENTARIO")
public class Inventario implements Serializable {
	
	@EmbeddedId
	private InventarioId inventarioId;
	
	@Column(name="cantidad", nullable = false)
	private Integer cantidad;
	
	@Column(name="precio", nullable=false)
	private double precio;
}
