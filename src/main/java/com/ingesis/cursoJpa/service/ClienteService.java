package com.ingesis.cursoJpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ingesis.cursoJpa.dao.ClienteDao;
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
}
