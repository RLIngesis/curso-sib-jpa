package com.ingesis.cursoJpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ingesis.cursoJpa.entity.Cliente;
import com.ingesis.cursoJpa.entity.Municipio;
import com.ingesis.cursoJpa.service.ClienteService;
import com.ingesis.cursoJpa.service.DepartamentoService;
import com.ingesis.cursoJpa.service.MunicipioService;

@RestController
public class LaboratorioEntityController {

	@Autowired
	private DepartamentoService departamentoService;
	
	@Autowired
	private MunicipioService municipioService;
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("api/lab/entity")
	public String getTest() {
		
		System.out.println("TODOS LOS MUNICIPIOS DEL DEPARTAMENTO QUETZALTENANGO");
		List<Municipio> municipios = departamentoService.findMunicipiosByDepartamento(13);
		municipios.forEach(i ->	System.out.println(i.getNombre()));
		
		System.out.println("TODOS LOS MUNICIPIOS DEL PAIS GUATEMALA");
		List<Municipio> municipios2 = municipioService.findAllByPais(1);
		municipios2.forEach(i -> System.out.println(i.getNombre()));
		
		System.out.println("TODOS LOS CLIENTES DEL PAIS EL SALVADOR");
		List<Cliente> clientes = clienteService.findAllByPais(2);
		clientes.forEach(i -> System.out.println(i.getNombre()));
		
		System.out.println("TODOS LOS CLIENTES DEL DEPARTAMENTO SAN MARCOS");
		List<Cliente> clientes2 = clienteService.findAllByDepartamento(17);
		clientes2.forEach(i-> System.out.println(i.getNombre()));
		
		return "ok";
	}
	
}
