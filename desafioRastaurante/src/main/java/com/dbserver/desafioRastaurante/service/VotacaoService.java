package com.dbserver.desafioRastaurante.service;

import org.springframework.stereotype.Service;

import com.dbserver.desafioRastaurante.dto.ProfissionalDTO;
import com.dbserver.desafioRastaurante.dto.VotacaoDTO;
import com.dbserver.desafioRastaurante.dto.VotoDTO;
import com.dbserver.desafioRastaurante.entities.Restaurante;
import com.dbserver.desafioRastaurante.entities.Votacao;
import com.dbserver.desafioRastaurante.entities.Voto;

@Service
public interface VotacaoService {
	
	Votacao iniciarVotacao(ProfissionalDTO profissionalDTO);	
	Restaurante apurarVencedor(ProfissionalDTO profissional, Integer Idvotacao);
	Voto votar(Integer idVotacao, VotoDTO voto);

}
