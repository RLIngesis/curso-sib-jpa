package com.ingesis.cursoJpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Cliente {

    @Id
    private Integer id;
    
    @Column(nullable = false)
    private String name;

}