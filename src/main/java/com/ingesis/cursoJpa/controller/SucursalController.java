package com.ingesis.cursoJpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ingesis.cursoJpa.dto.SucursalDto;
import com.ingesis.cursoJpa.entity.Sucursal;
import com.ingesis.cursoJpa.logic.SucursalLogic;
import com.ingesis.cursoJpa.service.SucursalService;

@RestController
public class SucursalController {
	@Autowired
	private SucursalLogic sucursalLogic;
	
	@GetMapping("api/v1/findSucursalById")
	public SucursalDto findSucursalById(Integer idSucursal) {
		return sucursalLogic.findSucursalById(idSucursal);
	}
}
