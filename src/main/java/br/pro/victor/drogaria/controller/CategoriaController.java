//Controlador para a categoria Categoria em que estão as categórias
//de produtos da minha farmácia. 
//Victor Hugo Marques

package br.pro.victor.drogaria.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.pro.victor.drogaria.domain.Categoria;
import br.pro.victor.drogaria.exception.RecursoNaoEncontradoException;
import br.pro.victor.drogaria.service.CategoriaService;

@RestController
@RequestMapping("categorias")
public class CategoriaController {
	@Autowired
	private CategoriaService categoriaService; 
	
	@GetMapping
	public List<Categoria> listar(){
		List<Categoria> categorias = categoriaService.listar();
		return categorias; 
	}
	
	@GetMapping("/{codigo}")
	public Categoria buscar(@PathVariable Short codigo) {
		try {	
			Categoria categoria = categoriaService.buscarPorCodigo(codigo);
			return categoria;
		}
		catch (RecursoNaoEncontradoException excecao) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada.", excecao);
		}
	}
	
	@PostMapping()
	public Categoria inserir(@RequestBody Categoria categoria) {
		//Manejo de erro ainda não implementado
		//Alterar mensagem para o caso em que a categoria já foi implementada
		Categoria categoriaSalva = categoriaService.inserir(categoria);
		return categoriaSalva;
	}
	
	@DeleteMapping("/{codigo}")
	public Categoria excluir(@PathVariable Short codigo) {
		Categoria categoria = categoriaService.excluir(codigo);
		return categoria; 
	}
	
	@PutMapping
	public Categoria editar(@RequestBody Categoria categoria) {
		Categoria categoriaEditada = categoriaService.editar(categoria); 
		return categoriaEditada; 
	}
	
}
