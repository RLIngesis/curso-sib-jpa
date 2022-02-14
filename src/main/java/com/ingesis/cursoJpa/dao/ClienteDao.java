package com.ingesis.cursoJpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Component;
import com.ingesis.cursoJpa.entity.Cliente;

@Component
public class ClienteDao {

	@PersistenceContext
	EntityManager em;
	
	
	public List<Cliente> findAllClientes(){
		List<Cliente> listaClientes;
		Query q = em.createNamedQuery("Cliente.findAll");
		listaClientes = q.getResultList();
		
		if(null == listaClientes) {
			listaClientes = new ArrayList<>();
		}
		
		return listaClientes;
	}
}
