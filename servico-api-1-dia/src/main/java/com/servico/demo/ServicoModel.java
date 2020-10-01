package com.servico.demo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity; //posso colocar depois de persistence.* <- isso abre todas a bibliotecas.
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table
public class ServicoModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE) // auto increment
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date data;
	
	//getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
		
}
