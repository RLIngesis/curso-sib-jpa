package com.ingesis.springdata.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "DETALLE_FACTURA")
public class DetalleFactura implements Serializable {

    @EmbeddedId
    private DetalleFacturaPK detalleFacturaId;

    @Column(name = "no_fila")
    private Integer noFila;

    @Column(name = "precio_unitario")
    private Double precioUnitario;

    @Column(name = "cantidad")
    private Integer cantidad;

    @JoinColumn(name = "id_factura", referencedColumnName = "id_factura", insertable = false, updatable = false)
    @ManyToOne
    private Factura factura;
}
