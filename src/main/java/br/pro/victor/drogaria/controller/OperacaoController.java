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
import br.pro.victor.drogaria.domain.Operacao;
import br.pro.victor.drogaria.service.OperacaoService;

@RestController
@RequestMapping("/operacao")
public class OperacaoController {
	
	@Autowired
	private OperacaoService operacaoService;
	
	@GetMapping("/")
	public List<Operacao> listar(){
		List<Operacao> operacao = operacaoService.listar();
		return operacao; 
	}
	
	@PostMapping("/")
	public Operacao inserir(@RequestBody Operacao operacao) {
		Operacao operacaoSalvo = operacaoService.inserir(operacao);
		return operacaoSalvo;
	}
	
	@DeleteMapping("/{codigo}")
	public Operacao excluir(@PathVariable Integer codigo) {
		Operacao operacao = operacaoService.excluir(codigo);
		return operacao; 
	}
	
	@PutMapping("/")
	public Operacao editar(@RequestBody Operacao operacao) {
		Operacao operacaoEd = operacaoService.editar(operacao);
		return operacaoEd; 
	}
}
