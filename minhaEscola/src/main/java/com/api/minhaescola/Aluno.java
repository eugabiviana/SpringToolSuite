package com.api.minhaescola;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="minha_escola")
public class Aluno {

	@Id // PK 
	@GeneratedValue(strategy = GenerationType.SEQUENCE) // auto increment
	private Long id_aluno;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="matriculado")
	private boolean matriculado;

	//Getters and Setters
	public Long getId_aluno() {
		return id_aluno;
	}

	public void setId_aluno(Long id) {
		this.id_aluno = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isMatriculado() {
		return matriculado;
	}

	public void setMatriculado(boolean matriculado) {
		this.matriculado = matriculado;
	}	
	
}
