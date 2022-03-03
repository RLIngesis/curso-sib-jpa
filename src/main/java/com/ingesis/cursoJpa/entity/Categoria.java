package com.ingesis.cursoJpa.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="CATEGORIA")
public class Categoria implements Serializable {

	@Id
	@Column(name="id_categoria")
	private Integer idCategoria;
	
	@Column(nullable = false, length = 100)
	private String nombre;
	
	@Column(nullable = false, length = 400)
	private String descripcion;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Categoria))
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(descripcion, other.getDescripcion()) && Objects.equals(idCategoria, other.getIdCategoria())
				&& Objects.equals(nombre, other.getNombre());
	}

	@Override
	public int hashCode() {
		return Objects.hash(descripcion, idCategoria, nombre);
	}


}
