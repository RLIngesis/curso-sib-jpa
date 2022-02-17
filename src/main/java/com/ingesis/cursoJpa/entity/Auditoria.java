package com.ingesis.cursoJpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

import lombok.Data;

@Data
@Entity
public class Auditoria {


	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "AuditoriaId")
    @TableGenerator(name = "AuditoriaId", table = "cfg_secuencia",
            pkColumnName = "cod_secuencia", pkColumnValue = "id_auditoria",
            valueColumnName = "correlativo", initialValue = 1, allocationSize = 1)
	@Column(name="id_auditoria")
	private Long idAuditoria;
	
	@Column(name="mensaje")
	private String event;	

}
