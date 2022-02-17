package com.ingesis.springdata.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "VENDEDOR")
public class Vendedor implements Serializable {

    @Id
    @Column(name = "id_vendedor")
    private Integer idVendedor;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "puesto")
    private String puesto;

    @JoinTable(name = "sucursal_vendedor",
            joinColumns = {@JoinColumn(name = "id_vendedor")},
            inverseJoinColumns = {@JoinColumn(name = "id_sucursal")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Sucursal> sucursales;
}
