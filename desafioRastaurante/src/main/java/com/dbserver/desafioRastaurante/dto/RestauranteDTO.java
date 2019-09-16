package com.dbserver.desafioRastaurante.dto;

import java.io.Serializable;

public class RestauranteDTO implements Serializable {

	private static final long serialVersionUID = -5904302112212396530L;

	private Integer id;
	private String nome;
	private String logradouro;
	
	public RestauranteDTO(Integer id, String nome, String logradouro) {
		this.id = id;
		this.nome = nome;
		this.logradouro = logradouro;
	}
	
	public Integer getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getLogradouro() {
		return logradouro;
	}
	
}
