package com.ingesis.cursoJpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@NamedQueries({
	@NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
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

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
     
}