package com.api.minhalojadegames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.minhalojadegames.model.ProdutoModel;
import com.api.minhalojadegames.repository.ProdutoRepository;


@RestController
@CrossOrigin("*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping("/produtos")
	public List<ProdutoModel> getAll(){
		return repository.findAll();
	}
	
	@GetMapping("/produtos/nome/{nome}")
	public List<ProdutoModel> getById(@PathVariable String nome){
		return repository.findByNome(nome);
	}
	
	@PostMapping("/produtos")
	public ProdutoModel post (@RequestBody ProdutoModel model){
		repository.save(model);
		return model;
	}
	
	@PutMapping("/produtos/{id}")
	public ProdutoModel put (@PathVariable Long id, @RequestBody ProdutoModel model){
		model.setId(id);
		return model;
	}
	
	@DeleteMapping("/produtos/{id}")
	public String delete(@PathVariable long id) {
		repository.deleteById(id);
		return "Sucesso!";
	}
	
}
