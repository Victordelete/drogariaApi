//Interface entre a categoria e o JPARepository para estruturar a API

package br.pro.victor.drogaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pro.victor.drogaria.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Short> {

}
