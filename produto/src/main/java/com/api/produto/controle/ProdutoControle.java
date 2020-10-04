package com.api.produto.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.produto.repositorio.ProdutoRepositorio;

@RestController // Responsável por criar a estrutura MVC para trabalhar com API's
@RequestMapping("/api") // Define a url que quando for requisitada chamara o metodo
public class ProdutoControle {
	//Ações
	@Autowired
	private ProdutoRepositorio acoes;
	
	// Início
	@RequestMapping(value="", method=RequestMethod.GET) // valor vazio, porque essa será a API principal. 
	public @ResponseBody String inicio() { // Essa Annotation faz com que o return seja exibido no navegador.
		return "Bem vindo a API de produtos!";
	}
	
	// Sobre
	@RequestMapping(value="/sobre", method=RequestMethod.GET)
	public @ResponseBody String sobre() {
		return "Sobre API...";
	}
	
	// Contato
	@RequestMapping(value="/contato", method=RequestMethod.GET)
	public @ResponseBody String contato() {
		return "Fale conosco. =)";
	}
	
}
