package br.com.fiap.iotintegration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
@SequenceGenerator(name = "botao", sequenceName = "SQ_BOTAO", allocationSize = 1)
public class Botao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "botao")
	private Long id;
	private String estadoBotao;
}
