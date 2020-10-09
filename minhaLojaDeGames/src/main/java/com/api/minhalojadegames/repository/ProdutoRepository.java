package com.api.minhalojadegames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.minhalojadegames.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	public List<Produto> findAllByTituloIgnoreCase(String titulo);
	
}
