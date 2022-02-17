package com.ingesis.cursoJpa.auxs;

import lombok.Data;

@Data
public class InventarioAux {
	private String nombreProducto;
	private Long cantidad;
	private Double ganancia;
	
	public InventarioAux() {
		
	}
	
	public InventarioAux(String nombreProducto, Long cantidad, Double ganancia) {
		this.nombreProducto = nombreProducto;
		this.cantidad = cantidad;
		this.ganancia = ganancia;
	}
}
