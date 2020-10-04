package com.api.produto.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.api.produto.modelo.ProdutoModelo;

public interface ProdutoRepositorio extends CrudRepository<ProdutoModelo, Integer>{ //sempre pede o modelo ao qual está se relacionando, desse caso, ProdutoModelo já criado. O ID solicitado, é a variável da pk, nesse caso int.

	//Listar todos os produtos
	List<ProdutoModelo> findAll(); //findAll(); = select*from do MySQL
	
	// Pesquisar por código
	ProdutoModelo findByCodigo (int codigo); // comando que busca pelo parâmentro digitado, nesse caso, na coluna código. 
	
	// Remover produto
	void delete (ProdutoModelo produto); // deleta o produto passado como parâmetro.
	
	// Cadastrar/Alterar produto
	//ProdutoModelo save(ProdutoModelo produto) | esse foi feito dessa forma, funciona, mas o a estrutura correta é como segue abaixo:
	<ProdMod extends ProdutoModelo> ProdMod save (ProdMod produto); //cria uma classe temporária que representa o ProdutoModelo usado no código.
	
	
}
