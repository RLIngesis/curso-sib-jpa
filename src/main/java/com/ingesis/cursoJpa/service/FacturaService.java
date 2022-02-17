package com.ingesis.cursoJpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ingesis.cursoJpa.dao.FacturaDao;
import com.ingesis.cursoJpa.entity.Factura;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class FacturaService {
	
	@Autowired
	private FacturaDao facturaDao;
	
	@Transactional(readOnly=true)
	public Factura getFacturaById(Integer idFactura) {
		return facturaDao.getFacturaById(idFactura);
	}
	
	@Transactional(readOnly = true)
	public List<Factura> getFacturasByCriteria(String nombreCliente, String telefono, String nit, String fecha, String fechaFin){
		return facturaDao.getFacturasByCriteria(nombreCliente, telefono, nit, fecha, fechaFin);
	}
	
	@Transactional(readOnly = true)
	public List<Factura> getFacturasByCriteriaLab( String fecha, String fechaFin, String nombre, String municipio, String vendedor, Integer... factura){
		return facturaDao.getFacturasByCriteriaLab(fecha, fechaFin, nombre, municipio, vendedor, factura);
	}
	@Transactional(readOnly = true)
	public List<Factura> getFacturasBySinCriteria(String nombreCliente, String telefono){
		return facturaDao.getFacturasBySinCriteria(nombreCliente, telefono);
	}
	
	@Transactional(readOnly = true)
	public List<Factura> getFacturasByItemMonto(Double monto) {
		return facturaDao.getFacturasByItemMonto(monto);
	}
}
