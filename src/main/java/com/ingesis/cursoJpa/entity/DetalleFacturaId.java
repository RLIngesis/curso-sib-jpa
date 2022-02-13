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
	@Column(name="id_detalle_factura")
	private Integer idDetalleFactura;
	
	@Basic(optional = false)
	@Column(name="id_factura")
	private Integer idFactura;
	
	@Basic(optional = false)
	@Column(name="id_producto")
	private Integer idProducto;
	
	@Basic(optional = false)
	@Column(name="id_categoria")
	private Integer idCategoria;
}
