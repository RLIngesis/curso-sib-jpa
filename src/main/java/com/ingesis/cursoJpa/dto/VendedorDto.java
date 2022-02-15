package com.ingesis.cursoJpa.dto;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.Data;

@Data
public class VendedorDto {

	private Integer idVendedor;
	private String nombre;
	private String puesto;
	
	
}
