package com.api.minhalojadegames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.minhalojadegames.model.Produto;
import com.api.minhalojadegames.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

	public List<Produto> findAllByUsuarioIgnoreCase(String usuario);
	
	public List<Produto> findAllByIdIgnoreCase(String id);
	
}
