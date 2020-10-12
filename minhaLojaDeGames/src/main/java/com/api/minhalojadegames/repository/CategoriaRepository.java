package com.api.minhalojadegames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.minhalojadegames.model.CategoriaModel;

//Aqui eu coloco a minha categoria e o FindyByNome
@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
	public List<CategoriaModel> findByNome(String nome);

}
