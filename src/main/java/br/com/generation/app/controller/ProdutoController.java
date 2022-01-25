package br.com.generation.app.controller;

import java.util.List;

import br.com.generation.app.models.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.generation.app.repositories.ProdutoRepository;



@RestController
@RequestMapping("/produtos")
@CrossOrigin("*")

public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public ResponseEntity <List <br.com.generation.app.models.Produto>>  findAllProduto(){
		return ResponseEntity.ok(produtoRepository.findAll());	
		
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Produto> findByIDProduto(@PathVariable Long id){
		return produtoRepository.findById(id)
			.map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());	
	}
	
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Produto>> findByNome (@PathVariable String nome){
		return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<Produto> post (@RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
		
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Produto> put (@RequestBody Produto produto) {
		
		return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produto));
	}
	
	@DeleteMapping("/apagar/{id}")

	public void delete(@PathVariable long id)  {

		produtoRepository.deleteById (id);

	}
	
	
	
	
	

}
