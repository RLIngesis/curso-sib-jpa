package com.ingesis.cursoJpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ingesis.cursoJpa.dao.ClienteDao;
import com.ingesis.cursoJpa.entity.Categoria;
import com.ingesis.cursoJpa.entity.Cliente;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ClienteService {
	
	private ClienteDao clienteDao;
	
	@Autowired
	public ClienteService(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}
	
	@Transactional(readOnly = true)
	public List<Cliente> findAllClientes(){
		return clienteDao.findAllClientes();
	}
	
	@Transactional(readOnly = true)
	public Cliente findClienteById(Integer idCliente){
		return clienteDao.findClienteById(idCliente);
	}
	
	@Transactional(readOnly = true)
	public Cliente findClienteByReference(Integer idCliente){
		return clienteDao.findClienteByReference(idCliente);
	}
	
	@Transactional(readOnly = true)
	public Cliente findClienteByNombreAndNit(String nombre, String nit){
		return clienteDao.findClienteByNameAndNit(nombre, nit);
	}
	
	@Transactional(readOnly = true)
	public List<Cliente> findAllByPais(Integer idPais){
		return clienteDao.findAllByPais(idPais);
	}
	
	@Transactional(readOnly = true)
	public List<Cliente> findAllByDepartamento(Integer idDepartamento) {
		return clienteDao.findAllByDepartamento(idDepartamento);
	}
	
}
