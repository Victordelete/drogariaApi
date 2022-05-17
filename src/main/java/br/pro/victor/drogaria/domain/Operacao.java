package br.pro.victor.drogaria.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Operacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoOperacao; 
	
	@Column(nullable = false)
	private char tipoOperacao; //C para Compra V para Venda
	
	@Column(nullable = false, precision = 5, scale = 2)
	private BigDecimal precoOperacao; //Não necessáriamente é o preço de estoque 
	
	@ManyToOne
	@JoinColumn(nullable = false, unique = false)
	private Produto produto;
	
	@Column
	private LocalDate data; 
	
	@ManyToOne
	@JoinColumn(nullable = false, unique = false)
	private Funcionario funcionario;
		
}
