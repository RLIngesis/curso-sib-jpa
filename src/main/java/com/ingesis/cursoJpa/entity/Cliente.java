package com.ingesis.cursoJpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Cliente implements Serializable {

    @Id
    private Integer id;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String nit;
    
    @Column(nullable = false)
    private String telefono;
    
    @Column(nullable = false)
    private String email;
    
     
}