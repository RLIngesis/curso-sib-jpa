package com.ingesis.cursoJpa.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ingesis.cursoJpa.entity.Cliente;
import com.ingesis.cursoJpa.service.ClienteService;

@Component
public class ClienteLogic {
	
	@Autowired
	private ClienteService clienteService;

	public void clienteEqualsExample() {
		Cliente cliente1 = clienteService.findClienteById(1);
		Cliente cliente2 = new Cliente();
		cliente2.setIdCliente(1);
		System.out.println("Comparacion de clientes por PK: "+ cliente1.equals(cliente2));
	}
}
