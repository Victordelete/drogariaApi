package br.pro.victor.drogaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pro.victor.drogaria.domain.Produto;
import br.pro.victor.drogaria.exception.RecursoNaoEncontradoException;
import br.pro.victor.drogaria.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	//Serviço para LISTAR produtos da farmácia
	public List<Produto> listar(){
		List<Produto> resultado = produtoRepository.findAll();
		return resultado;
	}
	
	//Serviço para INSERIR produtos da farmácia
	public Produto inserir(Produto produto) {
		Produto resultado = produtoRepository.save(produto);
		Optional<Produto> resultadoOpt = Optional.ofNullable(resultado);
		if(resultadoOpt.isEmpty()) {
			throw new RecursoNaoEncontradoException();
		}
		Produto produtoRetorno = resultadoOpt.get();
		return produtoRetorno; 
	}
	
	//Serviço para Excluir produtos da farmácia
	public Produto excluir(Integer codigo) {
		Optional<Produto> produto = produtoRepository.findById(codigo);
		produtoRepository.delete(produto.get());
		Produto produtoResultado = produto.get();
		return produtoResultado; 
	}

	//Serviço para EDITAR produtos na farmácia
	public Produto editar(Produto produto) {
		Produto produtoResultado = produtoRepository.save(produto);
		return produtoResultado; 
	}
}
