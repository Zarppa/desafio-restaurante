package com.dbserver.desafioRastaurante.service;

import org.springframework.stereotype.Service;

import com.dbserver.desafioRastaurante.dto.ProfissionalDTO;
import com.dbserver.desafioRastaurante.dto.VotacaoDTO;
import com.dbserver.desafioRastaurante.entities.Votacao;

@Service
public interface VotacaoService {
	
	Votacao iniciarVotacao();	
	Votacao apurarVencedor(ProfissionalDTO profissional, VotacaoDTO votacao);

}
