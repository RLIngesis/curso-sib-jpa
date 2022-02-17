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
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "SUCURSAL")
public class Sucursal {

    @Id
    @Column(name = "id_sucursal")
    private Integer idSucursal;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @JoinTable(name = "sucursal_vendedor",
            joinColumns = {@JoinColumn(name = "id_sucursal")},
            inverseJoinColumns = {@JoinColumn(name = "id_vendedor")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Vendedor> vendedor;
}
