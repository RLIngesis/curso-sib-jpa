package com.ingesis.cursoJpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ingesis.cursoJpa.entity.Cliente;

@Repository
public class ClienteDao {

	@PersistenceContext
	private EntityManager em;
	
	private static final int MILES = 150;
	
	
	public void crear(Cliente cliente) {
		em.persist(cliente);
	};
	
	public List<Cliente> findAllClientes(){
		List<Cliente> listaClientes;
		Query q = em.createNamedQuery("Cliente.findAll");
		listaClientes = q.getResultList();
		
		if(null == listaClientes) {
			listaClientes = new ArrayList<>();
		}
		
		return listaClientes;
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
	
	public void crea(Cliente cliente) {
		em.persist(cliente);
	}
	
	   
	public void llenarDataTestRendimiento() {
		
		System.out.println("---- inicializando BBDD ----");
		int idCliente = 1000;
		for (int i = 0; i < MILES * 1000; i++) {
			idCliente++;
		   Cliente persona = new Cliente();
		   persona.setIdCliente(idCliente);
	       persona.setNombre("persona " + i);
	       
		   em.persist(persona);
		}
		
		System.out.println("---- incialización completada -----");
	}
	
	public List<Cliente> consultaTodoLosClientes() {
		List<Cliente> resultado = new ArrayList<Cliente>(MILES * 1000);
		
		TypedQuery<Cliente> query = em.createQuery("select p from Cliente p where p.idCliente >= :inicio and  p.idCliente <= :fin", Cliente.class);
		
		for (int i = 0; i < MILES; i++) {
			query.setParameter("inicio",  (i * 1000L) + 1  );
			query.setParameter("fin", (i + 1) * 1000L);
			
			resultado.addAll(query.getResultList());
			//Se debe hacer un clear para que libere la caché del jpa
			em.clear();
		}
		
		return resultado;
	}
}
