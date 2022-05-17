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

import br.pro.victor.drogaria.domain.Funcionario;

import br.pro.victor.drogaria.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping("/")
	public List<Funcionario> listar(){
		List<Funcionario> funcionarios = funcionarioService.listar();
		return funcionarios; 
	}
	
	@PostMapping("/")
	public Funcionario inserir(@RequestBody Funcionario funcionario) {
		Funcionario funcionarioSalvo = funcionarioService.inserir(funcionario);
		return funcionarioSalvo;
	}
	
	@DeleteMapping("/{codigo}")
	public Funcionario excluir(@PathVariable Integer codigo) {
		Funcionario funcionario = funcionarioService.excluir(codigo);
		return funcionario; 
	}
	
	@PutMapping("/")
	public Funcionario editar(@RequestBody Funcionario funcionario) {
		Funcionario funcionarioEd = funcionarioService.editar(funcionario);
		return funcionarioEd; 
	}
		
}
