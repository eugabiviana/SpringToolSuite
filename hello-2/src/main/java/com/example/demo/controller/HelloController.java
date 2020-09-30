package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helllo-2")

public class HelloController {
	
	@GetMapping
	public String hello() {
		return "Os objetivos para aprendizagem dessa semana são:"
				+ "Consegui entender os comandos do STS e aprender como mudar a porta em uso, pois minha aplicação não roda.";
	}

}
