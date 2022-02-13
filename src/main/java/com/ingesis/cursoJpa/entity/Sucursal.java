package com.ingesis.cursoJpa.entity;

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
@Entity
public class Sucursal {

	@Id
	@Column(name="id_sucursal")
	private Integer idSucursal;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="direccion")
	private String direccion;
	
	@JoinTable(name = "sucursal_vendedor",
               joinColumns = {@JoinColumn(name = "id_sucursal")},
               inverseJoinColumns = {@JoinColumn(name = "id_vendedor")})
	@ManyToMany(fetch=FetchType.LAZY)
	private List<Vendedor> vendedor;
}
