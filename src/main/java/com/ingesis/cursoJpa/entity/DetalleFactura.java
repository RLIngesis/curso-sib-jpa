package com.ingesis.cursoJpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class DetalleFactura implements Serializable{

	@EmbeddedId
	private DetalleFacturaId detalleFacturaId;
	
	@Column
	private Integer noProductos;
	
	@Column
	private Double precioUnitario;
	
	@Column 
	private Integer cantidad;
}
