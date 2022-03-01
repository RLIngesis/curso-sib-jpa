package com.ingesis.cursoJpa.dto;

import java.util.List;

import lombok.Data;

@Data
public class SucursalDto {
	Integer idSucursal;
	String nombre;
	String direccion;
	List<VendedorDto> vendedores;
	
}
