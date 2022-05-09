//Classe em que os serviçoes realizados pela API são realizados

package br.pro.victor.drogaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pro.victor.drogaria.domain.Categoria;
import br.pro.victor.drogaria.exception.RecursoNaoEncontradoException;
import br.pro.victor.drogaria.repository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository; 
	
	//Serviço de BUSCA de categorias pelo código
	public Categoria buscarPorCodigo(Short codigo) {
		Optional<Categoria> resultado = categoriaRepository.findById(codigo);
		
		if(resultado.isEmpty()) {
			throw new RecursoNaoEncontradoException();
		}
		
		Categoria categoria = resultado.get();
		return categoria;
	}
	
	//Serviço de LISTAGEM de todas as categórias
	public List<Categoria> listar(){ //buscar tudo
		List<Categoria> resultado = categoriaRepository.findAll();
		return resultado; 
	}
	
	//Serviço de INSERÇÃO no BancoDados
	public Categoria inserir(Categoria categoria){
		Categoria resultado = categoriaRepository.save(categoria);  
		Optional<Categoria> resultadoOpt = Optional.ofNullable(resultado); 
		if(resultadoOpt.isEmpty()) {
			throw new RecursoNaoEncontradoException();
		}
		
		Categoria categoriaRetorno = resultadoOpt.get();
		return categoriaRetorno;
	}
	
	//Serviço de EXCLUSÃO no BancodeDados
	public Categoria excluir(Short codigo) {
		Optional<Categoria> categoria = categoriaRepository.findById(codigo);
		categoriaRepository.delete(categoria.get());
		Categoria categoriaRetorno = categoria.get();
		return categoriaRetorno;
	}
	
	//Serviço para EDITAR no BancoDeDados
	public Categoria editar(Categoria categoria) {
		Categoria categoriaEditada = categoriaRepository.save(categoria); 
		return categoriaEditada; 
	}
}
