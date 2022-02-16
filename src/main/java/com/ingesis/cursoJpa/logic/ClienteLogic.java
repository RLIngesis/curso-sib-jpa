package com.ingesis.cursoJpa.logic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ingesis.cursoJpa.dto.ClienteDto;
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
	
	public ClienteDto findClienteByReference(Integer idCliente){
		Cliente cliente = clienteService.findClienteByReference(idCliente);
		return mapToDto(cliente);
	}
	
	public List<ClienteDto> findAllClientes(){
		List<Cliente> clientes =  clienteService.findAllClientes();
		List<ClienteDto> clientesDto = new ArrayList<>();
		if(null != clientes && clientes.size()>0) {
			for(Cliente cliente: clientes) {
				clientesDto.add(mapToDto(cliente));
			}
		}
		return clientesDto;
	}
	
	public List<ClienteDto> findAllClientesCriteria(){
		List<Cliente> clientes =  clienteService.findAllClientesCriteria();
		List<ClienteDto> clientesDto = new ArrayList<>();
		if(null != clientes && clientes.size()>0) {
			for(Cliente cliente: clientes) {
				clientesDto.add(mapToDto(cliente));
			}
		}
		return clientesDto;
	}
	

	public ClienteDto findClienteById(Integer idCliente){
		Cliente cliente =  clienteService.findClienteById(idCliente);
		return mapToDto(cliente);
	}
	
	public ClienteDto findClienteByNombreAndNit(String nombre, String nit){
		Cliente cliente =  clienteService.findClienteByNombreAndNit(nombre, nit);
		return mapToDto(cliente);
	}
	
	public ClienteDto mapToDto(Cliente cliente) {
		ClienteDto clienteDto = new ClienteDto();
		if(cliente != null) {
			clienteDto.setNombre(cliente.getNombre());
			clienteDto.setDireccion(cliente.getDireccion());
			clienteDto.setEmail(cliente.getEmail());
			clienteDto.setNit(cliente.getNit());
			clienteDto.setTelefono(cliente.getTelefono());
			if(null!=cliente.getMunicipio()) {
				clienteDto.setMunicipio(cliente.getMunicipio().getNombre());
			}
		}
		return clienteDto;
	}
	
}
