package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-1")
public class HelloController {
	
	@GetMapping("/get1")
	public String hello() {
		return "Mentalidade de Persistência e Habilidade de Atenção aos detalhes.";
	}
	@GetMapping("/get2")
	public String hello2() {
		return "Mentalidade de Persistência e Habilidade de Atenção aos detalhes.2";
	}	
}
