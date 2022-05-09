package br.pro.victor.drogaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pro.victor.drogaria.service.ProdutoService;
import br.pro.victor.drogaria.domain.Produto;

@RestController
@RequestMapping("produto")
public class ProdutoController {
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public List<Produto> listar(){
		List<Produto> produtos = produtoService.listar();
		return produtos; 
	}
	
	@PostMapping
	public Produto inserir(@RequestBody Produto produto) {
		//Manejo de erro ainda não implementado
		//Alterar mensagem para o caso em que a categoria já foi implementada
		Produto produtoSalvo = produtoService.inserir(produto);
		return produtoSalvo; 
	}
	
	@DeleteMapping("/{codigo}")
	public Produto excluir(@PathVariable Integer codigo) {
		Produto produto = produtoService.excluir(codigo);
		return produto; 
	}
	
	@PutMapping
	public Produto editar(@RequestBody Produto produto) {
		Produto produtoEditado = produtoService.editar(produto);
		return produtoEditado; 
	}
}
