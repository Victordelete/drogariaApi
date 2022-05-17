//Definições da minha classe de Categórias
//Inicialmente minha categória possui somente índice e nome

package br.pro.victor.drogaria.domain;

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
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Id geredado automatimaticamente
	private Short codigoCategoria;
	
	//String com o nome da minha Categoria
	@Column(length = 50, nullable = false, unique = true)
	private String nomeCategoria; 
	
}
