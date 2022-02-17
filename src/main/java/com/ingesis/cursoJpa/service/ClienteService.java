package com.ingesis.cursoJpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ingesis.cursoJpa.dao.ClienteDao;
import com.ingesis.cursoJpa.entity.Cliente;

@Service
@Transactional
public class ClienteService {
	
	private ClienteDao clienteDao;
	
	
	@Autowired
	private ServicioAuditoria servicioAuditoria;
	
	@Autowired
	public ClienteService(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}
	
	public void crear(Cliente cliente) {
		servicioAuditoria.log("Pre cliente: "+cliente.getNombre());
		clienteDao.crea(cliente);
	}
	
	public List<Cliente> findAllClientes(){
		return clienteDao.findAllClientes();
	}
	
	public Cliente findClienteById(Integer idCliente){
		Cliente cliente = clienteDao.findClienteById(idCliente);
		servicioAuditoria.log(cliente);
		
		if (cliente.getConsultas() > 3) {
			throw new RuntimeException("Muchas consultas");
		}
		
		return cliente;
	}
	
	public Cliente findClienteByReference(Integer idCliente){
		Cliente cliente = clienteDao.findClienteByReference(idCliente);
		return cliente;
	}
	
	public Cliente findClienteByNombreAndNit(String nombre, String nit){
		return clienteDao.findClienteByNameAndNit(nombre, nit);
	}
	
	public List<Cliente> findAllByPais(Integer idPais){
		return clienteDao.findAllByPais(idPais);
	}
	
	public List<Cliente> findAllByDepartamento(Integer idDepartamento) {
		return clienteDao.findAllByDepartamento(idDepartamento);
	}
	
	public void llenarDataTestRendimiento() {
		clienteDao.llenarDataTestRendimiento();
	}
	
	@Transactional(readOnly=true)
	public List<Cliente> problemaDeRendimiento() {
		return clienteDao.consultaTodoLosClientes();
	}
	
}
