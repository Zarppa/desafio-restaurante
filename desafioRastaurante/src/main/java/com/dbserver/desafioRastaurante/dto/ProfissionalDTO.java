package com.dbserver.desafioRastaurante.dto;

import java.io.Serializable;

import com.dbserver.desafioRastaurante.entities.Profissional;
import com.dbserver.desafioRastaurante.entities.Restaurante;
import com.dbserver.desafioRastaurante.service.validation.ProfissionaIInsert;
@ProfissionaIInsert	
public class ProfissionalDTO implements Serializable {

	private static final long serialVersionUID = -3163919888459770772L;

	private Integer id;
	private String nome;
	private String email;
	
	public ProfissionalDTO() {		
	}

	public ProfissionalDTO(Integer id, String nome, String email) {
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static ProfissionalDTO criar(Profissional profissional) {
		return new ProfissionalDTO(profissional.getId(), profissional.getNome(), profissional.getEmail());
	}
}
