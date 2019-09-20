package com.dbserver.desafioRastaurante.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dbserver.desafioRastaurante.dto.ProfissionalDTO;
import com.dbserver.desafioRastaurante.dto.RestauranteDTO;
import com.dbserver.desafioRastaurante.dto.VotacaoDTO;
import com.dbserver.desafioRastaurante.dto.VotoDTO;
import com.dbserver.desafioRastaurante.entities.Restaurante;
import com.dbserver.desafioRastaurante.entities.Votacao;
import com.dbserver.desafioRastaurante.entities.Voto;
import com.dbserver.desafioRastaurante.service.VotacaoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/votacao")
public class VotacaoResourse {
	
	
	@Autowired
	private VotacaoService service;
	
	@ApiOperation(value="Inicia uma votação para o almoço")
	@RequestMapping(value="/iniciar", method=RequestMethod.POST)
	public ResponseEntity<VotacaoDTO> iniciarVotacao(@Valid @RequestBody ProfissionalDTO profissionalDTO) {
		Votacao votacao = service.iniciarVotacao(profissionalDTO);		
		return ResponseEntity.ok().body(VotacaoDTO.criar(votacao));
	}
	@ApiOperation(value="Vota no restaurante desejado")
	@RequestMapping(value="/{idVotacao}/votar", method=RequestMethod.POST)	
	public ResponseEntity<VotoDTO> votar(@Valid @RequestBody VotoDTO votoDTO, @PathVariable Integer idVotacao) {
		Voto voto = service.votar(idVotacao, votoDTO);		
		return ResponseEntity.ok().body(VotoDTO.criar(voto));
		
	}
	@ApiOperation(value="Apura restaurante vencedor")
	@RequestMapping(value="/{idVotacao}/apurarVencedor", method=RequestMethod.POST)	
	public ResponseEntity<RestauranteDTO> apurarVotacao(@Valid @RequestBody ProfissionalDTO profissional, @PathVariable Integer idVotacao) {
		Restaurante vencedor = service.apurarVencedor(profissional, idVotacao);		
		return ResponseEntity.ok().body(RestauranteDTO.criar(vencedor));
		
	}

}
