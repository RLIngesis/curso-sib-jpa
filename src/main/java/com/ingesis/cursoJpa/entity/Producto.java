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
	@Column(name="id_producto")
	private Integer idProducto;

	@Id
	@Column(name="id_categoria")
	private Integer idCategoria;

	@JoinColumn(name="id_categoria", referencedColumnName = "id_categoria",insertable = false, updatable = false)
	@ManyToOne(fetch=FetchType.EAGER) 
	private Categoria categoria;

	@Column(name="codigo_producto")
	private String codigoProducto;

	@Column(name="descripcion")
	private String descripcion;

	@Column(name="unidad_medida")
	private String unidadMedida;
}
