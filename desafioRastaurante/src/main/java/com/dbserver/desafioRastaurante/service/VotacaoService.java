package com.dbserver.desafioRastaurante.service;

import com.dbserver.desafioRastaurante.dto.ProfissionalDTO;
import com.dbserver.desafioRastaurante.entity.Votacao;

public interface VotacaoService {
	
	Votacao iniciarVotacao();	
	Votacao apurarVencedor(ProfissionalDTO profissional);

}
