package com.servico.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired //responsavel por executar comandos previamente disponiveis do repositorio
	private ServicoRepository repository; //é uma boa prática colocar esse nome igual ao da classe
	
	@GetMapping("/servicos")
	public List<ServicoModel> pegarTodos(){ //entre parenteses é um método.
		return repository.findAll();
	}
	
	//requerer a resposta e fazer o save
	@PostMapping("/servicos")
	public ServicoModel criar(@RequestBody ServicoModel model) {
		repository.save(model);
		return model;
	}
	
	@GetMapping("/servico/nome/{nome}")
	public List<ServicoModel> buscarPorNome(@PathVariable String nome){
		return repository.findByNome(nome);
	}
	
	@PutMapping("/servicos/{id}")
	public ServicoModel atualizar(@PathVariable Long id, @RequestBody ServicoModel model) {
		model.setId(id);
		repository.save(model);
		return model;
	}
	
	@DeleteMapping("/servicos/{id}")
	public String remover(@PathVariable Long id) {
		repository.deleteById(id);
		return "sucesso";
	}
}
