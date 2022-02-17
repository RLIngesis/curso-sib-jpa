package com.ingesis.cursoJpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ingesis.cursoJpa.dto.FacturaDto;
import com.ingesis.cursoJpa.entity.Cliente;
import com.ingesis.cursoJpa.entity.Factura;
import com.ingesis.cursoJpa.logic.FacturaLogic;
import com.ingesis.cursoJpa.service.FacturaService;

@RestController
public class FacturaController {

	@Autowired
	private FacturaService facturaService;
	
	@Autowired
	private FacturaLogic facturaLogic;
	
	@GetMapping("api/v1/facturas")
	public Factura getCliente(Integer idFactura) {
		return facturaService.getFacturaById(idFactura);
	}
	
	@GetMapping("api/v1/facturaBasic")
	public FacturaDto getFacturaBasic(Integer idFactura) {
		return facturaLogic.getBasicFactura(idFactura);
	}
	
	@GetMapping("api/v1/facturaFull")
	public FacturaDto getFullFactura(Integer idFactura) {
		return facturaLogic.getFullFactura(idFactura);
	}
	
	@PostMapping("api/v1/factura")
	public Factura crearFactura(@RequestBody Factura factura) {
		return facturaService.crearFactura(factura);
	}
	
	@PostMapping("api/v1/facturaAndInventory")
	public void crearFacturaAndInsertInventory(@RequestBody Factura factura) {
		 facturaLogic.crearFactura(factura);
	}
}
