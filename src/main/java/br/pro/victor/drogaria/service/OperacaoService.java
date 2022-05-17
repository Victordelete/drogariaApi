package br.pro.victor.drogaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pro.victor.drogaria.domain.Operacao;
import br.pro.victor.drogaria.exception.RecursoNaoEncontradoException;
import br.pro.victor.drogaria.repository.OperacaoRepository;

@Service
public class OperacaoService {
	@Autowired
	private OperacaoRepository operacaoRepository; 
	
	//Serviço para listagem de operações
	public List<Operacao> listar(){
		List<Operacao> operacao = operacaoRepository.findAll();
		return operacao; 
	}
	
	//Serviço para inserção de operacao
	public Operacao inserir(Operacao operacao) {
		Operacao resultado = operacaoRepository.save(operacao);
		Optional<Operacao> operacaoOpt = Optional.ofNullable(resultado);
		if(operacaoOpt.isEmpty()) {
			throw new RecursoNaoEncontradoException();
		}
		Operacao operacaoSalvo = operacaoOpt.get(); 
		return operacaoSalvo; 
	}
	
	//Serviço para exclusão de Operacoes
	public Operacao excluir(Integer codigo) {
		Optional<Operacao> operacao = operacaoRepository.findById(codigo);
		if(operacao.isEmpty()) {
			throw new RecursoNaoEncontradoException();
		}
		//so deleto 
		operacaoRepository.delete(operacao.get());
		
		return operacao.get();
	}
	
	//Serviço para edição do cadastro de Operações
	//Talvez seja necessário adicionar uma validação de acesso do
	//funcionário na edição por segurança
	public Operacao editar(Operacao operacao) {
		Optional<Operacao> resultado = operacaoRepository.findById(operacao.getCodigoOperacao());
		if(resultado.isEmpty()) {
			throw new RecursoNaoEncontradoException();
		}
		//caso o cadastro exista eu salvo na mesma posição
		operacaoRepository.save(operacao);
		
		return operacao; 
	}

}
