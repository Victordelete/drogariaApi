//Classe com as definições para funcionários. 
//

package br.pro.victor.drogaria.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoFuncionario; 
	
	@Column(length = 50, nullable = false, unique = false)
	private String nomeFuncionario;
	
	//Seria melhor criar uma tabela com os cargos existentes
	//e referenciar, porém vai ser uma melhoria futura. 
	@Column(length = 50, nullable = false, unique = false)
	private String cargoFuncionario;
	
	//com a lógica anterior seria melhor associar o nível
	//de acesso ao cargo, mas será abordado no futuro. 
	@Column(nullable = false)
	private char nivelAcessoFuncionario;
	
	@Column(nullable = false, precision = 5, scale = 2)
	private BigDecimal salarioFuncionario; 
	
	@Column
	private LocalDate dataAdmissaoFuncionario; 
}
