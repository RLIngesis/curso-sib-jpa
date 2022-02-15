package com.ingesis.cursoJpa.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.ingesis.cursoJpa.entity.Cliente;
import com.ingesis.cursoJpa.entity.DetalleFactura;
import com.ingesis.cursoJpa.entity.Vendedor;

import lombok.Data;

@Data
public class FacturaDto {

private Integer idFactura;
	
	private Integer numeroFactura;
	private String serie;
	private Integer idCliente;
	private Integer idVendedor;
	private ClienteDto cliente;
	private VendedorDto Vendedor; 
	private Date fecha;
	private Double montoTotal;
	private List<DetalleFacturaDto> detalleFactura;
	
	public void cargarDetalleFactura(List<DetalleFactura> detalleFactura) {
		if(detalleFactura!=null && detalleFactura.size() > 0) {
			this.detalleFactura = new ArrayList<>();
			for(DetalleFactura detalle : detalleFactura) {
				DetalleFacturaDto nuevoDetalle = new DetalleFacturaDto();
				nuevoDetalle.setNoFila(detalle.getNoFila());
				nuevoDetalle.setCantidad(detalle.getCantidad());
				nuevoDetalle.setPrecioUnitario(detalle.getPrecioUnitario());
				this.detalleFactura.add(nuevoDetalle);
			}
		}else {
			this.detalleFactura = new ArrayList<>();
		}
	}
	
}
