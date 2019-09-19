package com.dbserver.desafioRastaurante.dto;

public class ResultadoVoto implements Comparable<ResultadoVoto>{

	private Integer idRestaurante;
	private Integer qtdVotos;

	public ResultadoVoto() {
	}

	public ResultadoVoto(Integer idRestaurante, Integer qtdVotos) {
		super();
		this.idRestaurante = idRestaurante;
		this.qtdVotos = qtdVotos;
	}

	public Integer getIdRestaurante() {
		return idRestaurante;
	}

	public void setIdRestaurante(Integer idRestaurante) {
		this.idRestaurante = idRestaurante;
	}

	public Integer getQtdVotos() {
		return qtdVotos;
	}

	public void setQtdVotos(Integer qtdVotos) {
		this.qtdVotos = qtdVotos;
	}

	@Override
	public int compareTo(ResultadoVoto arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
