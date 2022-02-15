package com.ingesis.cursoJpa.logic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

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
		clienteObj1 = inicializarCliente("Pedro");
		clienteObj2 = inicializarCliente("Mateo");
		clienteObj3 = inicializarCliente("Gonzales");
		Collection<Cliente> nuevosClientes = new HashSet<>();
		nuevosClientes.add(clienteObj1);
		nuevosClientes.add(clienteObj2);
		nuevosClientes.add(clienteObj3);
		System.out.println("Inicio impresion en HashSet ");
		for(Cliente cliente : nuevosClientes) {
			System.out.println("Nombre desde hashset: "+cliente.getNombre());
		}
	}
	
	public void ejemploLista() {
		Cliente clienteObj1 = new Cliente();
		Cliente clienteObj2 = new Cliente();
		Cliente clienteObj3 = new Cliente();
		clienteObj1 = inicializarCliente("Pedro");
		clienteObj2 = inicializarCliente("Mateo");
		clienteObj3 = inicializarCliente("Gonzales");
		List<Cliente> nuevosClientes = new ArrayList<>();
		nuevosClientes.add(clienteObj1);
		nuevosClientes.add(clienteObj2);
		nuevosClientes.add(clienteObj3);
		System.out.println("Inicio impresion en ArrayList ");
		for(Cliente cliente : nuevosClientes) {
			System.out.println("Nombre desde lista: "+cliente.getNombre());
		}
	}
	
	public Cliente inicializarCliente(String nombre) {
		Cliente cliente = new Cliente();
		cliente.setNombre(nombre);
		cliente.setDireccion("ciudad");
		cliente.setEmail("email@gmail.com");
		cliente.setNit("nit");
		cliente.setTelefono("0920302");
		return cliente;
	}
	
}
