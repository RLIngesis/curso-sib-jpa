package com.ingesis.cursoJpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ingesis.cursoJpa.entity.Cliente;
import com.ingesis.cursoJpa.service.ClienteService;

@RestController
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("api/v1/clientes")
	public List<Cliente> getClientes() {
		Cliente cliente = new Cliente();
		return clienteService.findAllClientes();
	}
}
