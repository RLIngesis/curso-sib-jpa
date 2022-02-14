package com.ingesis.cursoJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ingesis.cursoJpa.logic.ClienteLogic;

@SpringBootApplication
public class CursoJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoJpaApplication.class, args);
	}

}
