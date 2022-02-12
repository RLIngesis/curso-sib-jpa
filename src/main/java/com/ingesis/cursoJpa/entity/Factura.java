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
@Entity
public class Factura implements Serializable{
	@Id
	private Integer idFactura;
	
	@Column(name="numeroFactura")
	private Integer numeroFactura;
	
	@Column(name="serie")
	private String serie;
	
	/*
	 * @JoinColumn(name = "idCliente", referencedColumnName = "idCliente",
	 * table="cliente")
	 * 
	 * @ManyToOne private Cliente cliente;
	 * 
	 * @JoinColumn(name = "idVendedor", referencedColumnName = "idVendedor",
	 * table="vendedor")
	 * 
	 * @ManyToOne private Vendedor Vendedor;
	 */
	
	@Column(name="fecha")
	private Data fecha;
	
	@Column(name="montoTotal")
	private Double montoTotal;

	/*
	 * @JoinColumn(name = "idFactura", referencedColumnName = "idFactura",
	 * table="DetalleFactura")
	 * 
	 * @OneToMany(fetch=FetchType.LAZY) private List<DetalleFactura> detalleFactura;
	 */
	
}
