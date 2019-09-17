package com.dbserver.desafioRastaurante.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Profissional implements Serializable{
	
	private static final long serialVersionUID = -565076010896599684L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String email;
	private Boolean facilitador;
	
	public Profissional(Integer id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.facilitador = Boolean.FALSE;
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
	
	

	public Boolean getFacilitador() {
		return facilitador;
	}

	public void setFacilitador(Boolean facilitador) {
		this.facilitador = facilitador;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, facilitador, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profissional other = (Profissional) obj;
		return Objects.equals(email, other.email) && Objects.equals(facilitador, other.facilitador)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}
}
