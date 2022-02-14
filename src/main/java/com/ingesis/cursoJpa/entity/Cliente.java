package com.ingesis.cursoJpa.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@NamedQueries({
	@NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
	@NamedQuery(name = "Cliente.findById", query = "SELECT c FROM Cliente c WHERE c.idCliente =:idCliente")
})
@Entity
@Table(name="CLIENTE")
public class Cliente implements Serializable {

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

	@Override
	public int hashCode() {
		return Objects.hash(idCliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(idCliente, other.idCliente);
	}

    
     
}