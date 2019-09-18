package com.dbserver.desafioRastaurante.dto;

import java.io.Serializable;
import java.util.Date;

import com.dbserver.desafioRastaurante.entities.Voto;
import com.dbserver.desafioRastaurante.service.validation.VotoInsert;

@VotoInsert
public class VotoDTO implements Serializable {

	private static final long serialVersionUID = 816774703122477901L;
	
	private Integer id;
	private RestauranteDTO restauranteDTO;
	private ProfissionalDTO profissionalDTO;
	private Date dataVoto;
	
	public VotoDTO() {
	}

	public VotoDTO(RestauranteDTO restaurante, ProfissionalDTO profissional) {
		this.restauranteDTO = restaurante;
		this.profissionalDTO = profissional;
	}	

	public VotoDTO(Integer id, RestauranteDTO restauranteDTO, ProfissionalDTO profissionalDTO, Date dataVoto) {
		super();
		this.id = id;
		this.restauranteDTO = restauranteDTO;
		this.profissionalDTO = profissionalDTO;
		this.dataVoto = dataVoto;
	}



	public RestauranteDTO getIdRestaurante() {
		return restauranteDTO;
	}

	public void setIdRestaurante(RestauranteDTO restaurante) {
		this.restauranteDTO = restaurante;
	}

	public ProfissionalDTO getIdProfissional() {
		return profissionalDTO;
	}

	public void setIdProfissional(ProfissionalDTO profissional) {
		this.profissionalDTO = profissional;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RestauranteDTO getRestauranteDTO() {
		return restauranteDTO;
	}

	public void setRestauranteDTO(RestauranteDTO restauranteDTO) {
		this.restauranteDTO = restauranteDTO;
	}

	public ProfissionalDTO getProfissionalDTO() {
		return profissionalDTO;
	}

	public void setProfissionalDTO(ProfissionalDTO profissionalDTO) {
		this.profissionalDTO = profissionalDTO;
	}

	public Date getDataVoto() {
		return dataVoto;
	}

	public void setDataVoto(Date dataVoto) {
		this.dataVoto = dataVoto;
	}

	public static VotoDTO criar(Voto voto) {
		
		return new VotoDTO(voto.getId(), RestauranteDTO.criar(voto.getRestaurante()), ProfissionalDTO.criar(voto.getProfissional()), voto.getDataVoto());
				
				
		
	}
}
