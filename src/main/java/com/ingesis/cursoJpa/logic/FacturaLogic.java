package com.ingesis.cursoJpa.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ingesis.cursoJpa.dto.ClienteDto;
import com.ingesis.cursoJpa.dto.FacturaDto;
import com.ingesis.cursoJpa.dto.VendedorDto;
import com.ingesis.cursoJpa.entity.Factura;
import com.ingesis.cursoJpa.service.FacturaService;

@Component
public class FacturaLogic {
	
	@Autowired
	private FacturaService facturaService;

	public FacturaDto getBasicFactura(Integer idFactura) {
		Factura factura = facturaService.getFacturaById(idFactura);
		FacturaDto facturaBasic = new FacturaDto();
		VendedorDto vendedorBasic = new VendedorDto();
		
		facturaBasic.setIdFactura(factura.getIdFactura());
		facturaBasic.setIdCliente(factura.getIdCliente());
		facturaBasic.setIdVendedor(factura.getIdVendedor());
		facturaBasic.setFecha(factura.getFecha());
		facturaBasic.setMontoTotal(factura.getMontoTotal());
		facturaBasic.setSerie(factura.getSerie());
		facturaBasic.setNumeroFactura(factura.getNumeroFactura());
		
		vendedorBasic.setNombre(factura.getVendedor().getNombre());
		vendedorBasic.setPuesto(factura.getVendedor().getPuesto());
		facturaBasic.setVendedor(vendedorBasic);
		
		return facturaBasic;
	}
	
	public FacturaDto getFullFactura(Integer idFactura) {
		Factura factura = facturaService.getFacturaById(idFactura);
		FacturaDto facturaFull = new FacturaDto();
		VendedorDto vendedorBasic = new VendedorDto();
		ClienteDto clienteDto = new ClienteDto();
		
		facturaFull.setIdFactura(factura.getIdFactura());
		facturaFull.setIdCliente(factura.getIdCliente());
		facturaFull.setIdVendedor(factura.getIdVendedor());
		facturaFull.setFecha(factura.getFecha());
		facturaFull.setMontoTotal(factura.getMontoTotal());
		facturaFull.setSerie(factura.getSerie());
		facturaFull.setNumeroFactura(factura.getNumeroFactura());
		
		vendedorBasic.setNombre(factura.getVendedor().getNombre());
		vendedorBasic.setPuesto(factura.getVendedor().getPuesto());
		facturaFull.setVendedor(vendedorBasic);
		
		clienteDto.setNombre(factura.getCliente().getNombre());
		clienteDto.setNit(factura.getCliente().getNit());
		clienteDto.setTelefono(factura.getCliente().getTelefono());
		clienteDto.setMunicipio(factura.getCliente().getMunicipio().getNombre());
		facturaFull.setCliente(clienteDto);
		
		facturaFull.cargarDetalleFactura(factura.getDetalleFactura());
		
		return facturaFull;
	}
}
