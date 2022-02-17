package com.ingesis.cursoJpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
	

	public Factura crearFactura(Factura factura) {
		return facturaDao.crearFactura(factura);
	}
}
