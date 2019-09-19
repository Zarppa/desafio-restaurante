package com.dbserver.desafioRastaurante.dto;

public class ResultadoVotoDTO implements Comparable<ResultadoVotoDTO>{

	private Integer idRestaurante;
	private Integer qtdVotos;

	public ResultadoVotoDTO() {
	}

	public ResultadoVotoDTO(Integer idRestaurante, Integer qtdVotos) {
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
	public int compareTo(ResultadoVotoDTO arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
