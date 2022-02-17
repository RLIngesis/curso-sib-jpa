package com.ingesis.springdata.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class DetalleFacturaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_detalle_factura")
    private Integer idDetalleFactura;

    @Basic(optional = false)
    @Column(name = "id_factura")
    private Integer idFactura;

    @Basic(optional = false)
    @Column(name = "id_producto")
    private Integer idProducto;

    @Basic(optional = false)
    @Column(name = "id_categoria")
    private Integer idCategoria;
}
