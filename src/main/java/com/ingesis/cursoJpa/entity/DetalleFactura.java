package com.ingesis.cursoJpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="DETALLE_FACTURA")
public class DetalleFactura implements Serializable{

	@EmbeddedId
	private DetalleFacturaId detalleFacturaId;
	
	@Column(name="no_fila")
	private Integer noFila;
	
	@Column(name="precio_unitario")
	private Double precioUnitario;
	
	@Column(name="cantidad") 
	private Integer cantidad;
}
