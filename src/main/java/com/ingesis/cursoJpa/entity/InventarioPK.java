package com.ingesis.cursoJpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.TableGenerator;

import lombok.Data;

@Data
@Embeddable
public class InventarioPK implements Serializable {
	
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "InventaroId")
    @TableGenerator(name = "InventaroId", table = "cfg_secuencia",
            pkColumnName = "cod_secuencia", pkColumnValue = "id_inventario",
            valueColumnName = "correlativo", initialValue = 1, allocationSize = 1)
	@Column(name="id_inventario")
	private Integer idInventario;
	
	@Column(name="id_producto")
	private Integer idProducto;
	
	@Column(name="id_categoria")
	private Integer idCategoria;
	
}
