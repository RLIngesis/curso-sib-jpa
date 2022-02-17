package com.ingesis.cursoJpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ingesis.cursoJpa.auxs.InventarioAux;
import com.ingesis.cursoJpa.dto.FacturaDto;
import com.ingesis.cursoJpa.entity.Cliente;
import com.ingesis.cursoJpa.entity.Factura;
import com.ingesis.cursoJpa.entity.Inventario;
import com.ingesis.cursoJpa.logic.FacturaLogic;
import com.ingesis.cursoJpa.service.FacturaService;
import com.ingesis.cursoJpa.service.InventarioService;

@RestController
public class InventarioController {

	@Autowired
	private InventarioService inventarioService;

	
	@GetMapping("api/v1/inventario")
	public Inventario getCliente(Integer idInventario) {
		return inventarioService.getInventarioById(idInventario);
	}
	
	@GetMapping("api/v1/allInvetarioByIdProducto")
	public List<Inventario> findInventarioByIdProducto(Integer idProducto){
		return inventarioService.findInventarioByIdProducto(idProducto);
	}

	
	@PostMapping("api/v1/inventario")
	public Inventario crearFactura(@RequestBody Inventario inventario) {
		return inventarioService.crearInventario(inventario);
	}
	
	@GetMapping("api/v1/inventarioProducto")
	public InventarioAux getTotalQuantityByIdProducto(Integer idProducto) {
		return inventarioService.getTotalQuantityByIdProducto(idProducto);
	}
}
