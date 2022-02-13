package com.ingesis.cursoJpa.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity(name="FACTURA")
public class Factura implements Serializable{
	@Id
	@Column(name="id_factura")
	private Integer idFactura;
	
	@Column(name="numero_factura")
	private Integer numeroFactura;
	
	@Column(name="serie")
	private String serie;
	
	@JoinColumn(name = "id_cliente")
	@ManyToOne 
	private Cliente cliente;
	 
	//@JoinColumn(name = "id_vendedor", referencedColumnName = "id_vendedor",
	//		    table="vendedor")
	//@ManyToOne 
	//private Vendedor Vendedor; 
	 
	@Column(name="fecha")
	private Data fecha;
	
	@Column(name="monto_total")
	private Double montoTotal;

	@JoinColumn(name = "idFactura", referencedColumnName = "idFactura", insertable = false, updatable = false)
	@OneToMany(fetch=FetchType.LAZY) 
	private List<DetalleFactura> detalleFactura;
	 
	
}
