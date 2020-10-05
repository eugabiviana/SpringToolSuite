package com.api.minhaescola;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlunoController {
	
	@Autowired
	private AlunoRepository repository;
	
	@GetMapping("/aluno")
	public ResponseEntity<List<Aluno>> findAll(){
		
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/aluno/{id}")
	public ResponseEntity<Aluno> findByID(@PathVariable Long id){
		
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
		
	}
	
	@PostMapping("/aluno")
	public ResponseEntity<Aluno> postAluno(@RequestBody Aluno aluno){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(aluno));
		
	}
	
	@PutMapping("/aluno/{id}")
	public ResponseEntity<Aluno> putAluno(@PathVariable Long id, @RequestBody Aluno aluno){
		aluno.setId_aluno(id);
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(aluno));
	}
	
	@DeleteMapping("/aluno/{id}")
	public void deletar(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
}