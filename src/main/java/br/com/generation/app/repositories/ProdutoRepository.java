package br.com.generation.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.generation.app.models.Produto;


@Repository
public interface ProdutoRepository extends JpaRepository< Produto ,Long > {
	public List<Produto> findAllByNomeContainingIgnoreCase (String nome);
}
