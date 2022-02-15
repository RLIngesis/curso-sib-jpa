package com.ingesis.cursoJpa.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@NamedQueries({
	@NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
	@NamedQuery(name = "Cliente.findById", query = "SELECT c FROM Cliente c WHERE c.idCliente =:idCliente"),
	@NamedQuery(name = "Cliente.findByNombreAndNit", query = "SELECT c FROM Cliente c WHERE c.nombre =:nombre and c.nit =:nit"),
	@NamedQuery(name = "Cliente.findByPais", query = "SELECT c FROM Cliente c WHERE c.municipio.departamento.pais.idPais=:idPais"),
	@NamedQuery(name = "Cliente.findByDepartamento", query = "SELECT c FROM Cliente c WHERE c.municipio.departamento.idDepartamento =:idDepartamento")
	
})
@Entity
@Table(name="CLIENTE")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name="id_cliente")
    private Integer idCliente;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String nit;
    
    @Column(nullable = false)
    private String telefono;
    
    @Column(nullable = false)
    private String email;
    
    @JoinColumn(name = "id_municipio", nullable=false)
	@ManyToOne 
	private Municipio municipio;
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Cliente))
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(idCliente, other.getIdCliente());
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCliente);
	}


    
     
}