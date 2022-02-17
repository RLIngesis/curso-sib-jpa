package com.ingesis.cursoJpa.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Value;

import com.ingesis.cursoJpa.TimeTracker;
import com.ingesis.cursoJpa.entity.CsvFile;
import org.springframework.beans.factory.annotation.Autowired;

public class CsvFileService {
    @Autowired
    private TimeTracker timeTracker;
    @PersistenceContext
    private EntityManager em;
    @Value("${com.ingesis.batch.commitRows}")
    private Integer commitRows;
	
	@Transactional
    public void insert(List<CsvFile> csvFileList) {
        timeTracker.start("InsertInDB-All");
        for (int i = 0; i < csvFileList.size(); i++) {
            CsvFile csvFile = csvFileList.get(i);
            em.persist(csvFile);
            if (i % commitRows == 0) {
                em.flush();
                System.out.println(
                        String.format("%d rows inserted/commited @ %tc", commitRows, new Date())
                );
            }
        }
        em.flush();
        em.clear();
        timeTracker.stop("InsertInDB-All");
    }
	
}
