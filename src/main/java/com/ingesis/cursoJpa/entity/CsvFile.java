package com.ingesis.cursoJpa.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "DEMO_CSV_FILE")
@Data
public class CsvFile {
    @Id
    @Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "CsvFileId")
    @TableGenerator(name = "CsvFileId", table = "cfg_secuencia",
            pkColumnName = "cod_secuencia", pkColumnValue = "id_csv_file",
            valueColumnName = "correlativo", initialValue = 1, allocationSize = 1)
    private Long id;
    @Column(name = "PROCESS_ID", nullable = false)
    private String processUuid;
    @Column(name = "LINE_TEXT", nullable = false)
    private String lineText;

}
