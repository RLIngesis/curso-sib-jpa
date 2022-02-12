package com.ingesis.cursoJpa.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;

import lombok.Data;

@Data
@Embeddable
public class DetalleFacturaId implements Serializable {

	@Basic(optional = false)
	@Column(name="idDetalleFactura")
	private Integer idDetalleFactura;
	
	@Basic(optional = false)
	@Column(name="idFactura")
	private Integer idFactura;
	
	@Basic(optional = false)
	@Column(name="idProducto")
	private Integer idProducto;
	
	@Basic(optional = false)
	@Column(name="idCategoria")
	private Integer idCategoria;
}
