package com.dbserver.desafioRastaurante.entity;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Votacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@OneToMany(mappedBy = "Voto", cascade = CascadeType.ALL)
	private List<Voto> votos;
	
	@JsonFormat(pattern="dd/MM/yyyy hh:mm")
	private Date dataVotacao;
	
	@JsonIgnore
	private Boolean ativa;
	
	@JsonIgnore
	private Restaurante vencedor;
	

	public Votacao(Integer id, List<Voto> votos, Date dataVotacao, Boolean ativa, Restaurante vencedor) {
		this.id = id;
		this.votos = votos;
		this.dataVotacao = dataVotacao;
		this.ativa = ativa;
		this.vencedor = vencedor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}

	public Date getDataVotacao() {
		return dataVotacao;
	}

	public void setDataVotacao(Date dataVotacao) {
		this.dataVotacao = dataVotacao;
	}

	public Boolean getAtiva() {
		return ativa;
	}

	public void setAtiva(Boolean ativa) {
		this.ativa = ativa;
	}

	public Restaurante getVencedor() {
		return vencedor;
	}

	public void setVencedor(Restaurante vencedor) {
		this.vencedor = vencedor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ativa, dataVotacao, id, vencedor, votos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Votacao other = (Votacao) obj;
		return Objects.equals(ativa, other.ativa) && Objects.equals(dataVotacao, other.dataVotacao)
				&& Objects.equals(id, other.id) && Objects.equals(vencedor, other.vencedor)
				&& Objects.equals(votos, other.votos);
	}
}
