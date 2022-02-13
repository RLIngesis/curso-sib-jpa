package com.ingesis.cursoJpa.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity(name="VENDEDOR")
public class Vendedor implements Serializable {

	@Id
	@Column(name="id_vendedor")
	private Integer idVendedor;
	
	@Column(name="nombre")
	private String nombre;

	@Column(name="puesto")
	private String puesto;
	
	@JoinTable(name = "sucursal_vendedor",
                joinColumns = {@JoinColumn(name = "id_vendedor")},
                inverseJoinColumns = {@JoinColumn(name = "id_sucursal")})
	@ManyToMany(fetch=FetchType.LAZY)
	private List<Sucursal> sucursales;
}
