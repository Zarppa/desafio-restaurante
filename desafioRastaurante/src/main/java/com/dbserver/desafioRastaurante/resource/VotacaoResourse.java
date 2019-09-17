package com.dbserver.desafioRastaurante.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dbserver.desafioRastaurante.dto.VotacaoDTO;
import com.dbserver.desafioRastaurante.entities.Votacao;
import com.dbserver.desafioRastaurante.service.VotacaoService;

@RestController
@RequestMapping(value="/votacao")
public class VotacaoResourse {
	
	
	@Autowired
	private VotacaoService service;
	
	@RequestMapping(value="/votar", method=RequestMethod.POST)
	public ResponseEntity<VotacaoDTO> iniciarVotacao() {
		Votacao votacao = service.iniciarVotacao();
		
		return ResponseEntity.ok().body(VotacaoDTO.criar(votacao));
	}

}
