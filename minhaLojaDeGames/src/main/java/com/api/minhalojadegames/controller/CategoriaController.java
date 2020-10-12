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

import com.api.minhalojadegames.model.CategoriaModel;
import com.api.minhalojadegames.repository.CategoriaRepository;

@RestController
@CrossOrigin("*")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repository;

	@GetMapping("/categorias")
	public List<CategoriaModel> getAll() {
		return repository.findAll();
	}

	@GetMapping("/categorias/nome/{nome}")
	public List<CategoriaModel> getByNome(@PathVariable String nome) {
		return repository.findByNome(nome);
	}

	@PostMapping("/categorias")
	public CategoriaModel post(@RequestBody CategoriaModel model) {
		repository.save(model);
		return model;
	}

	@PutMapping("/categorias/{id}")
	public CategoriaModel put(@PathVariable Long id, @RequestBody CategoriaModel model) {
		model.setId(id);
		repository.save(model);
		return model;
	}

	@DeleteMapping("/categorias/{id}")
	public String delete(@PathVariable long id) {
		repository.deleteById(id);
		return "Sucesso!";
	}

}
