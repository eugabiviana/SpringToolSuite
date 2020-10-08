package com.api.metodosave;
import javax.persistence.*;


@Entity
public class Produto {	
	private Long id;
	private String nome;
	private String marca;
	private String criado_em;
	private float preco;
	
	//getters and setters 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getCriado_em() {
		return criado_em;
	}
	public void setCriado_em(String criado_em) {
		this.criado_em = criado_em;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	//constructor 
	protected Produto() {
		
	}
	
	protected Produto (Long id, String nome, String marca, String criado_em, float preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.marca = marca;
		this.criado_em = criado_em;
		this.preco = preco; 
		 
	}

}
