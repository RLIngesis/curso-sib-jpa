package com.ingesis.cursoJpa.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

import lombok.Data;

@Data
@Entity
@Table(name="PAIS")
public class Pais implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pais")
	private Integer idPais;
	
	@Column(nullable = false)
	private String nombre;
	
	@Override
	public int hashCode() {
		return Objects.hash(idPais);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		return Objects.equals(idPais, other.idPais);
	}
}
