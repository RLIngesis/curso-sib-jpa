package com.ingesis.cursoJpa.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ingesis.cursoJpa.entity.Municipio;

import lombok.Data;

@Data
public class ClienteDto {
    private Integer idCliente;
    private String nombre;
    private String direccion;
    private String nit;
    private String telefono;
    private String email;
	private String municipio;
}
