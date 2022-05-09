package br.pro.victor.drogaria.repository;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.pro.victor.drogaria.domain.Produto;

@SpringBootTest
public class ProdutoRepositoryTests {
	@Autowired //spring ira gerencia o objeto injetando a instancia de gerencia
	private ProdutoRepository produtoRepository;
	
	@Test 
	public void inserir () {
		
		Produto p1 = new Produto(
				null,
				"Coca Cola",
				Byte.valueOf("15"),
				BigDecimal.valueOf(10.50),
				LocalDate.of(2022, 04, 23),
				null);
		
		Produto p2 = new Produto(
				null,
				"Heineken",
				Byte.valueOf("23"),
				BigDecimal.valueOf(8.00),
				LocalDate.of(2022, 05, 05),
				null);
		
		produtoRepository.save(p1);
		produtoRepository.save(p2);
	}
}
