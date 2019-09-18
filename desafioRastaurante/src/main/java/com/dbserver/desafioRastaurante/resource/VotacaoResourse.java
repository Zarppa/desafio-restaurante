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
import com.dbserver.desafioRastaurante.dto.VotacaoDTO;
import com.dbserver.desafioRastaurante.dto.VotoDTO;
import com.dbserver.desafioRastaurante.entities.Votacao;
import com.dbserver.desafioRastaurante.entities.Voto;
import com.dbserver.desafioRastaurante.service.VotacaoService;

@RestController
@RequestMapping(value="/votacao")
public class VotacaoResourse {
	
	
	@Autowired
	private VotacaoService service;
	
	@RequestMapping(value="/iniciar", method=RequestMethod.POST)
	public ResponseEntity<VotacaoDTO> iniciarVotacao(@Valid @RequestBody ProfissionalDTO profissionalDTO) {
		Votacao votacao = service.iniciarVotacao(profissionalDTO);		
		return ResponseEntity.ok().body(VotacaoDTO.criar(votacao));
	}
	@RequestMapping(value="/{idVotacao}/votar", method=RequestMethod.POST)	
	public ResponseEntity<VotoDTO> votar(@Valid @RequestBody VotoDTO votoDTO, @PathVariable Integer idVotacao) {
		Voto voto = service.votar(idVotacao, votoDTO);		
		return ResponseEntity.ok().body(VotoDTO.criar(voto));
		
	}

}
