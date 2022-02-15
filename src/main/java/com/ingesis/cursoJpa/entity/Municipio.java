package com.ingesis.cursoJpa.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@NamedQueries({
	@NamedQuery(name = "Municipio.findAllByPais", query = "SELECT m FROM Municipio m WHERE m.departamento.pais.idPais=:idPais"),
})
@Entity
@Table(name="MUNICIPIO")
public class Municipio implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_municipio")
	private Integer idMunicipio;
	
	@Column(nullable = false)
	private String nombre;
	
	@JoinColumn(name = "id_departamento", referencedColumnName ="id_departamento")
	@ManyToOne 
	private Departamento departamento;
	
	@Override
	public int hashCode() {
		return Objects.hash(idMunicipio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Municipio other = (Municipio) obj;
		return Objects.equals(idMunicipio, other.idMunicipio);
	}
}
