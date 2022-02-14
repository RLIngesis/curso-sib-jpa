package com.ingesis.cursoJpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ingesis.cursoJpa.testContext.TestPersistenceContext;

@SpringBootApplication
public class CursoJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoJpaApplication.class, args);
	}	
}
