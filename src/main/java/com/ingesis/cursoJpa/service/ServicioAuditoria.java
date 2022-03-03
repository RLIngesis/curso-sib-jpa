package com.ingesis.cursoJpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ingesis.cursoJpa.entity.Auditoria;
import com.ingesis.cursoJpa.entity.Cliente;

@Service
@Transactional(propagation =Propagation.REQUIRES_NEW)
public class ServicioAuditoria {
	
	@PersistenceContext
	private EntityManager em;

	public void log (String event) {
		
		Auditoria auditoria = new Auditoria();
		auditoria.setEvent(event);
		
		em.persist(auditoria);
	}


	public void log (Cliente cliente) {
		
		Auditoria auditoria = new Auditoria();
		String mensaje = String.format("Consulta num %d a %s",  cliente.getConsultas(),cliente.getNombre());
		auditoria.setEvent(mensaje);

		cliente.setConsultas((cliente.getConsultas()==null?1:cliente.getConsultas()+1));
		
		em.persist(auditoria);
	}

	public List<Auditoria> todas() {
		return em.createQuery("select a from Auditoria a order by a.id", Auditoria.class).getResultList();
	}

}
