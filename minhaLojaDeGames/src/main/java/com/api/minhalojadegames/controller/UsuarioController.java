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

import com.api.minhalojadegames.model.UsuarioModel;
import com.api.minhalojadegames.repository.UsuarioRepository;


@RestController
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;

	@GetMapping("/usuarios")
	public List<UsuarioModel> getAll() {
		return repository.findAll();
	}

	@GetMapping("/usuarios/nome/{nome}")
	public List<UsuarioModel> getById(@PathVariable String nome) {
		return repository.findByNome(nome);				
	}

	@PostMapping("/usuarios")
	public UsuarioModel post(@RequestBody UsuarioModel model) {
		repository.save(model);
		return model;
	}

	@PutMapping("/usuarios/{id}")
	public UsuarioModel put(@PathVariable Long id, @RequestBody UsuarioModel model) {
		model.setId(id);
		repository.save(model);
		return model;
	}

	@DeleteMapping("/usuarios/{id}")
	public String delete(@PathVariable Long id) {
		repository.deleteById(id);
		return "Sucesso!";
	}

}
