//Interface com o Jpa para o banco de operações

package br.pro.victor.drogaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pro.victor.drogaria.domain.Operacao;

public interface OperacaoRepository extends JpaRepository<Operacao, Integer> {

}
