package com.ingesis.cursoJpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ingesis.cursoJpa.dto.ClienteDto;
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
	public List<ClienteDto> getClientes() {
		return clienteLogic.findAllClientes();
	}
	
	@GetMapping("api/v1/clientes/criteria")
	public List<ClienteDto> getClientesCriteria() {
		return clienteLogic.findAllClientesCriteria();
	}
	
	@GetMapping("api/v1/cliente")
	public ClienteDto getCliente(Integer idCliente) {
		return clienteLogic.findClienteById(idCliente);
	}
	
	@GetMapping("api/v1/clienteRef")
	public ClienteDto getClienteByRef(Integer idCliente) {
		return clienteLogic.findClienteByReference(idCliente);
	}
	
	@GetMapping("api/v1/clienteByNombreAndNit")
	public ClienteDto getClienteByNombreAndNit(String nombre, String nit) {
		return clienteLogic.findClienteByNombreAndNit(nombre,nit);
	}
	
	@GetMapping("api/v1/equalsExample1")
	public String equalsExample() {
		return clienteLogic.clienteEqualsExample();
	}
	
	@GetMapping("api/v1/equalsExample2")
	public String equalsExample2() {
		return clienteLogic.clienteEqualsExampleByRef();
	}
	
	@GetMapping("api/v1/listaHash")
	public void listaHash() {
		 clienteLogic.ejemploHashMap();
	}
	
	@GetMapping("api/v1/listaArray")
	public void listaArray() {
		 clienteLogic.ejemploLista();
	}
}
