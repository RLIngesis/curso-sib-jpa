package com.ingesis.cursoJpa.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ingesis.cursoJpa.entity.Cliente;
import com.ingesis.cursoJpa.service.ClienteService;

@Component
public class ClienteLogic {
	
	@Autowired
	private ClienteService clienteService;

	public String clienteEqualsExample() {
		Cliente clienteBD = clienteService.findClienteById(1);
		Cliente clienteObj = new Cliente();
		clienteObj.setIdCliente(1);
		String salida = "";
		salida += "ClienteBD equals clienteJava? "+clienteBD.equals(clienteObj)+" -- ";
		salida += "ClienteJava equals clienteBD? "+clienteObj.equals(clienteBD);
		return salida;
	}
	
	public String clienteEqualsExampleByRef() {
		Cliente clienteBD = clienteService.findClienteByReference(1);
		Cliente clienteObj = new Cliente();
		clienteObj.setIdCliente(1);
		String salida = "";
		salida += "ClienteBD equals clienteJava? "+clienteBD.equals(clienteObj)+" -- ";
		salida += "ClienteJava equals clienteBD? "+clienteObj.equals(clienteBD);
		return salida;
	}
	
	public void ejemploHashMap() {
		Cliente clienteObj1 = new Cliente();
		Cliente clienteObj2 = new Cliente();
		Cliente clienteObj3 = new Cliente();
		clienteObj1.setNombre("Pedro");
		clienteObj1.setNombre("Mateo");
		clienteObj1.setNombre("Gonzales");
	}
	
	
}
