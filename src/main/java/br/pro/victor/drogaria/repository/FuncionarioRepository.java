package br.pro.victor.drogaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pro.victor.drogaria.domain.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{

}
