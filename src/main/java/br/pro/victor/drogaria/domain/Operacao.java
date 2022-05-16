package br.pro.victor.drogaria.domain;

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
public class Operacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoOperacao; 
	
	private char tipoOperacao; //C para Compra V para Venda
	
	produto BigDecimal preco; 
	
	
	
	private Produto produto; 
	
}
