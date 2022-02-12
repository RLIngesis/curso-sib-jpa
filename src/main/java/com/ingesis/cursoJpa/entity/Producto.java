package com.ingesis.cursoJpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
@IdClass(ProductId.class)
public class Producto implements Serializable {

	@Id
	private Integer idProducto;

	@Id
	private Integer idCategoria;

	@ManyToOne(fetch=FetchType.LAZY) 
	private Categoria categoria;

	@Column
	private String codigoProducto;

	@Column
	private String descripcion;

	@Column
	private String unidadMedida;
}
