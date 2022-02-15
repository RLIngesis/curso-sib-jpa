package com.ingesis.cursoJpa.dto;

import javax.persistence.Column;

import lombok.Data;

@Data
public class DetalleFacturaDto {
	private Integer noFila;
	private Double precioUnitario;
	private Integer cantidad;
}
