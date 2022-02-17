package com.ingesis.springdata.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "Departamento")
public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_departamento")
    private Integer idDepartamento;

    @Column(nullable = false)
    private String nombre;

    @JoinColumn(name = "id_pais")
    @ManyToOne
    private Pais pais;


    @OneToMany(mappedBy = "departamento", fetch = FetchType.LAZY)
    private List<Municipio> municipios;

    @Override
    public int hashCode() {
        return Objects.hash(idDepartamento);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Departamento other = (Departamento) obj;
        return Objects.equals(idDepartamento, other.idDepartamento);
    }
}
