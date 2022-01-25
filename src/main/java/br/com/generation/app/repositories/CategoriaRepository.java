package br.com.generation.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.generation.app.models.Categoria;

public interface CategoriaRepository  extends JpaRepository <Categoria, Long> {
	
	public List<Categoria> findAllByCategoriaContainingIgnoreCase(String categoria);

}
