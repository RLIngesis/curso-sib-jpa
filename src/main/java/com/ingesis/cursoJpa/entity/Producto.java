package com.ingesis.cursoJpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
@NamedQueries({
	@NamedQuery(name="findByIdCategoria", query="SELECT p FROM Producto p WHERE p.idCategoria=:idCategoria")
})
@Data
@Entity
@IdClass(ProductoPK.class)
@Table(name="PRODUCTO")
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
