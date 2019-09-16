package com.dbserver.desafioRastaurante.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.dbserver.desafioRastaurante.entity.Restaurante;
import com.dbserver.desafioRastaurante.entity.Voto;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class VotacaoDTO implements Serializable {
	
	private static final long serialVersionUID = 1057213343943760989L;
	
	private Integer id;
	private Date dataVotacao;
	private List<VotoDTO> votos;
	private Boolean ativa;
	private RestauranteDTO vencedor;
	
	public VotacaoDTO(Integer id, Date dataVotacao, List<VotoDTO> votos, Boolean ativa, RestauranteDTO vencedor) {
		this.id = id;
		this.dataVotacao = dataVotacao;
		this.votos = votos;
		this.ativa = ativa;
		this.vencedor = vencedor;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDataVotacao() {
		return dataVotacao;
	}
	public void setDataVotacao(Date dataVotacao) {
		this.dataVotacao = dataVotacao;
	}
	public List<VotoDTO> getVotos() {
		return votos;
	}
	public void setVotos(List<VotoDTO> votos) {
		this.votos = votos;
	}
	public Boolean getAtiva() {
		return ativa;
	}
	public void setAtiva(Boolean ativa) {
		this.ativa = ativa;
	}
	public RestauranteDTO getVencedor() {
		return vencedor;
	}
	public void setVencedor(RestauranteDTO vencedor) {
		this.vencedor = vencedor;
	}
}
