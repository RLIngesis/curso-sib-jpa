package com.ingesis.cursoJpa.testContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ingesis.cursoJpa.entity.Cliente;
import com.ingesis.cursoJpa.entity.Municipio;

public class TestPersistenceContext {
	
	public EntityManagerFactory emf;
	
	public TestPersistenceContext(String pu) {
		this.emf = Persistence.createEntityManagerFactory(pu);
	}
	
    public void probandoEstadoManagedConTranaccion() {
        
        EntityManager em = emf.createEntityManager();
   
        em.getTransaction().begin();
        
        Cliente juana = em.find(Cliente.class,1);
        System.out.println("Juana: "+juana.getTelefono());
        juana.setTelefono("(502) 8675969");
        
        em.getTransaction().commit();
        
        em.close();
    }

    public void probandoEstadoManagedSinTranaccion() {
        
        EntityManager em = emf.createEntityManager();
   
        Cliente juana = em.find(Cliente.class,1);
        System.out.println("Juana: "+juana.getTelefono());
        juana.setTelefono("(502) 8675969");
                
        em.close();
   }

    public void probandoEstadoManagedTranaccionPosterior() {
        
        EntityManager em = emf.createEntityManager();
   
        Cliente juana = em.find(Cliente.class,1);
        System.out.println("Juana: "+juana.getTelefono());
        juana.setTelefono("(502) 8675969");
        
        em.getTransaction().begin();
        em.close();
    }
    
    public void probandoFlushExplicitoSinTransaccion() {
        EntityManager em = emf.createEntityManager();
        
        Cliente juana = em.find(Cliente.class,1);
        juana.setTelefono("(502) 8675969");
        
        em.flush();            
        em.close();    	
    }
    
    public void ordenEjecucionOperacionesSQLEnElFlush() {
        EntityManager em = emf.createEntityManager();
        
        
        em.getTransaction().begin();
        
        em.remove(em.find(Cliente.class, 16));     //delete
        
        Cliente cliente = new Cliente();
        cliente.setIdCliente(100);
        cliente.setNombre("Rony Lemus");
        cliente.setDireccion("Ciudad Guatemala");
        em.persist(cliente);                       //insert
        
        Cliente juana = em.find(Cliente.class,1);
        juana.setTelefono("(502) 8675969");         //update
        
        em.getTransaction().commit();            
        em.close();    	
    	
    }
    
    public void flushAnteriorAQueries() {
        EntityManager em = emf.createEntityManager();
        
        
        em.getTransaction().begin();
        
        Cliente cliente = new Cliente();
        cliente.setIdCliente(100);
        cliente.setNombre("Rony Lemus");
        cliente.setDireccion("Ciudad Guatemala");
        em.persist(cliente);                       //insert
        
        em.createQuery("select c from Cliente c").getResultList();
        
        
        em.getTransaction().commit();            
        em.close();    	
    	
    }
    
    public void erroresDeIntegridad() {
        EntityManager em = emf.createEntityManager();
        
        
        em.getTransaction().begin();
        
        Cliente clienteEliminar = em.find(Cliente.class, 16);         
        em.remove(clienteEliminar);     //delete
        
        Cliente cliente = new Cliente();
        cliente.setIdCliente(clienteEliminar.getIdCliente());
        cliente.setNombre("Rony Lemus");
        cliente.setDireccion("Ciudad GT");
        
        em.persist(cliente);            //insert
        
        em.getTransaction().commit();            
        em.close();    	
    	
    }    

    public void probarLazyAndEagerLoading() {
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        Municipio muni = em.find(Municipio.class, 1);
        em.close();    	
    	
    }    
    
    
}
