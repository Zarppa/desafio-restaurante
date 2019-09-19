package com.dbserver.desafioRastaurante.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Votacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "VOTACAO_VOTO",
		joinColumns = @JoinColumn(name = "VOTACAO_ID"),
		inverseJoinColumns = @JoinColumn(name = "VOTO_ID")
	)
	private List<Voto> votos;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataVotacao;
	
	@JsonIgnore
	private Boolean ativa;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_profissional")
	private Profissional facilitador;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_restaurante")
	private Restaurante vencedor;
	
	public Votacao() {
	
	}

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

	public Profissional getFacilitador() {
		return facilitador;
	}

	public void setFacilitador(Profissional facilitador) {
		this.facilitador = facilitador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ativa == null) ? 0 : ativa.hashCode());
		result = prime * result + ((dataVotacao == null) ? 0 : dataVotacao.hashCode());
		result = prime * result + ((facilitador == null) ? 0 : facilitador.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((vencedor == null) ? 0 : vencedor.hashCode());
		result = prime * result + ((votos == null) ? 0 : votos.hashCode());
		return result;
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
		if (ativa == null) {
			if (other.ativa != null)
				return false;
		} else if (!ativa.equals(other.ativa))
			return false;
		if (dataVotacao == null) {
			if (other.dataVotacao != null)
				return false;
		} else if (!dataVotacao.equals(other.dataVotacao))
			return false;
		if (facilitador == null) {
			if (other.facilitador != null)
				return false;
		} else if (!facilitador.equals(other.facilitador))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (vencedor == null) {
			if (other.vencedor != null)
				return false;
		} else if (!vencedor.equals(other.vencedor))
			return false;
		if (votos == null) {
			if (other.votos != null)
				return false;
		} else if (!votos.equals(other.votos))
			return false;
		return true;
	}
}
