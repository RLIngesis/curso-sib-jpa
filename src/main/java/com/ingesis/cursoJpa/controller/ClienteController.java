package com.ingesis.cursoJpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ingesis.cursoJpa.entity.Cliente;
import com.ingesis.cursoJpa.logic.ClienteLogic;
import com.ingesis.cursoJpa.service.ClienteService;

@RestController
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired 
	private ClienteLogic clienteLogic;
	
	@GetMapping("api/v1/clientes")
	public List<Cliente> getClientes() {
		return clienteService.findAllClientes();
	}
	
	@GetMapping("api/v1/cliente")
	public Cliente getCliente(Integer idCliente) {
		return clienteService.findClienteById(idCliente);
	}
	
	@GetMapping("api/v1/clienteRef")
	public Cliente getClienteByRef(Integer idCliente) {
		return clienteService.findClienteByReference(idCliente);
	}
	
	@GetMapping("api/v1/clienteByNombreAndNit")
	public Cliente getClienteByNombreAndNit(String nombre, String nit) {
		return clienteService.findClienteByNombreAndNit(nombre,nit);
	}
	
	@GetMapping("api/v1/equalsExample1")
	public String equalsExample() {
		return clienteLogic.clienteEqualsExample();
	}
	
	@GetMapping("api/v1/equalsExample2")
	public String equalsExample2() {
		return clienteLogic.clienteEqualsExampleByRef();
	}
}
