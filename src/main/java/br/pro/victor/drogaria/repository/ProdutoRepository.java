//Interface entre a classe do Produto e o JPARepository para estruturar a API

package br.pro.victor.drogaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pro.victor.drogaria.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
