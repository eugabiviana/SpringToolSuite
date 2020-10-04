package com.api.produto.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // <-- serve para criar uma tabela no MySQL
@Table(name="produtos") // esse é o comando para renomear a tabela, se isso não fosse feito, ela se chamaria produto.modelo, igual ao pacote.
public class ProdutoModelo {

	@Id // define que a coluna codigo é a primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //é o equivalente ao AUTO INCREMENT do MySQL
	@Column(name="codigo") //essa anotação define o nome que a coluna terá ao ser criada no MySQL.
	private int codigo;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="valor")
	private double valor;
	
	//GETTERS AND SETTERS
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
			
}
