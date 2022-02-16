package com.ingesis.cursoJpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("api/v1/facturaCriteria")
	public List<FacturaDto> getFullFacturaCriteria(@RequestParam(value="nombre", required = false) String nombre, 
			@RequestParam(value="telefono", required=false) String telefono,
			@RequestParam(value="nit", required=false) String nit) {
		return facturaLogic.getFullFacturaCriteria(nombre, telefono, nit);
	}
	
	@GetMapping("api/v1/facturaSinCriteria")
	public List<FacturaDto> getFullFacturaSinCriteria(@RequestParam(value="nombre", required = false) String nombre,
			@RequestParam(value="telefono", required=false) String telefono,
			@RequestParam(value="nit", required=false) String nit) {
		return facturaLogic.getFullFacturaSinCriteria(nombre, telefono, nit);
	}
}
