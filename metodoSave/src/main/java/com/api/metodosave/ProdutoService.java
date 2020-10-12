package com.api.metodosave;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional //evita dados inconsistentes
public class ProdutoService {

	@Autowired // injetanto o Repository no Service através dessa annotation
	private ProdutoRepository repo; 

	public void save(TableProduto produto) {
		repo.save(produto);
	}

}
