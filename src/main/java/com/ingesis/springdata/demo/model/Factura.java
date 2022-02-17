package com.ingesis.springdata.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "getFacturaById", query = "SELECT f FROM Factura f WHERE f.idFactura =:idFacturaParam")
})
@Getter
@Setter
@Entity
@Table(name = "FACTURA")
public class Factura implements Serializable {
    @Id
    @Column(name = "id_factura")
    private Integer idFactura;

    @Column(name = "numero_factura")
    private Integer numeroFactura;

    @Column(name = "serie")
    private String serie;

    @Column(name = "id_cliente")
    private Integer idCliente;

    @Column(name = "id_vendedor", insertable = false, updatable = false)
    private Integer idVendedor;

    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    @JoinColumn(name = "id_vendedor", referencedColumnName = "id_vendedor")
    @ManyToOne(fetch = FetchType.EAGER)
    private Vendedor Vendedor;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "monto_total")
    private Double montoTotal;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "factura")
    private List<DetalleFactura> detalleFactura;


}
