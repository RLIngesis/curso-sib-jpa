package com.ingesis.cursoJpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ingesis.cursoJpa.entity.Cliente;

@RestController
public class TestController {

	@GetMapping("api/v1/test")
	public String getTest() {
		return "prueba";
	}
	
}
