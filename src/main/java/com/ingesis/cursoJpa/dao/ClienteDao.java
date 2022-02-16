package com.ingesis.cursoJpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ingesis.cursoJpa.entity.Cliente;
import com.ingesis.cursoJpa.entity.Factura;

@Repository
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
	
	
	public List<Cliente> findAllClientesCriteria(){
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Cliente> cq = cb.createQuery(Cliente.class);
		
		Root<Cliente> emi = cq.from(Cliente.class);
		
		CriteriaQuery<Cliente> select = cq.select(emi);

		
		TypedQuery<Cliente> q = this.em.createQuery(select);
		List<Cliente> listaFactuaras = q.getResultList();
		
		return listaFactuaras;
	}
	
	public Cliente findClienteById(Integer idCliente){
		List<Cliente> listaClientes;
		Cliente cliente;
		
		Query q = em.createNamedQuery("Cliente.findById");
			  q.setParameter("idCliente", idCliente);
			  
		listaClientes = q.getResultList();
		
		if(null == listaClientes || listaClientes.size() == 0) {
			cliente = new Cliente();
		}else {
			cliente = listaClientes.get(0);
		}
		
		return cliente;
	}
	
	public Cliente findClienteByReference(Integer idCliente) {
		Cliente cliente = em.getReference(Cliente.class, idCliente);
		return cliente;
	}
	
	public Cliente findClienteByNameAndNit(String nombre, String nit){
		List<Cliente> listaClientes;
		Cliente cliente;
		
		Query q = em.createNamedQuery("Cliente.findByNombreAndNit");
			  q.setParameter("nombre", nombre);
			  q.setParameter("nit", nit);
			  
		listaClientes = q.getResultList();
		
		if(null == listaClientes || listaClientes.size() == 0) {
			cliente = new Cliente();
		}else {
			cliente = listaClientes.get(0);
		}
		
		return cliente;
	}
	
	public List<Cliente> findAllByPais(Integer idPais){
		Query q = this.em.createNamedQuery("Cliente.findByPais")
				.setParameter("idPais", idPais);
		return q.getResultList();
	}
	
	public List<Cliente> findAllByDepartamento(Integer idDepartamento) {
		Query q = this.em.createNamedQuery("Cliente.findByDepartamento")
				.setParameter("idDepartamento", idDepartamento);
		return q.getResultList();
	}
}
