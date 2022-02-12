package com.ingesis.cursoJpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Vendedor implements Serializable {

	@Id
	private Integer idVendedor;
	
	@Column(name="nombre")
	private String nombre;

	@Column(name="puesto")
	private String puesto;
}
