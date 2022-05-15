package br.pro.victor.drogaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pro.victor.drogaria.domain.Funcionario;
import br.pro.victor.drogaria.exception.RecursoNaoEncontradoException;
import br.pro.victor.drogaria.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	//Serviço para listagem de funcionários
	public List<Funcionario> listar(){
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		return funcionarios; 
	}
	
	//Serviço para inserção de funcionários
	public Funcionario inserir(Funcionario funcionario) {
		Funcionario resultado = funcionarioRepository.save(funcionario);
		Optional<Funcionario> funcionarioOpt = Optional.ofNullable(resultado);
		if(funcionarioOpt.isEmpty()) {
			throw new RecursoNaoEncontradoException();
		}
		Funcionario funcionarioSalvo = funcionarioOpt.get(); 
		return funcionarioSalvo; 
	}
	
	//Serviço para exclusão de Funcionários
	public Funcionario excluir(Integer codigo) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(codigo);
		if(funcionario.isEmpty()) {
			throw new RecursoNaoEncontradoException();
		}
		//so deleto 
		funcionarioRepository.delete(funcionario.get());
		
		return funcionario.get();
	}
	
	//Serviço para edição do cadastro de Funcionários
	public Funcionario editar(Funcionario funcionario) {
		Optional<Funcionario> resultado = funcionarioRepository.findById(funcionario.getCodigoFuncionario());
		if(resultado.isEmpty()) {
			throw new RecursoNaoEncontradoException();
		}
		//caso o cadastro exista eu salvo na mesma posição
		Funcionario funcionarioEd = resultado.get();
		funcionarioRepository.save(funcionario);
		
		return funcionario; 
	}
}
