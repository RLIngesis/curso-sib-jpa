package com.ingesis.cursoJpa.logic;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ingesis.cursoJpa.dto.SucursalDto;
import com.ingesis.cursoJpa.dto.VendedorDto;
import com.ingesis.cursoJpa.entity.Sucursal;
import com.ingesis.cursoJpa.entity.Vendedor;
import com.ingesis.cursoJpa.service.SucursalService;

@Component
public class SucursalLogic {
	@Autowired
	private SucursalService sucursalService;
	
	public SucursalDto findSucursalById(Integer idSucursal) {
		SucursalDto sucursalDto = new SucursalDto();
		Sucursal sucursal = sucursalService.findSucursalById(idSucursal);
		
		sucursalDto.setIdSucursal(sucursal.getIdSucursal());
		sucursalDto.setNombre(sucursal.getNombre());
		sucursalDto.setDireccion(sucursal.getDireccion());
		
		List<VendedorDto> listaVendedores = new LinkedList<>();
		for(Vendedor vendedor : sucursal.getVendedor()) {
			VendedorDto vendedorDto = new VendedorDto();
			vendedorDto.setIdVendedor(vendedor.getIdVendedor());
			vendedorDto.setNombre(vendedor.getNombre());
			vendedorDto.setPuesto(vendedor.getPuesto());
			listaVendedores.add(vendedorDto);
		}
		
		sucursalDto.setVendedores(listaVendedores);
		return sucursalDto;
	}
}
