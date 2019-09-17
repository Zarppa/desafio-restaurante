package com.dbserver.desafioRastaurante.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;

import com.dbserver.desafioRastaurante.dto.ProfissionalDTO;
import com.dbserver.desafioRastaurante.dto.VotacaoDTO;
import com.dbserver.desafioRastaurante.entities.Votacao;
import com.dbserver.desafioRastaurante.repository.VotacaoRepository;
import com.dbserver.desafioRastaurante.util.CalendarUtil;
import com.dbserver.desafioRastaurante.util.Validator;

public class VotacaoServiceImpl implements VotacaoService {

	
	
	@Autowired
	private VotacaoRepository votacaoRepository;
	
	@Override
	public Votacao iniciarVotacao() {
		
		Calendar hoje = CalendarUtil.truncate(Calendar.getInstance());
		Votacao votacao = votacaoRepository.findByDataVotacao(hoje);
		
		if(Validator.has(votacao)) {
			
		}
		
		inserir(setParametrosIniciarVotacao(hoje));
		
		return null;
	}
	
	private Votacao setParametrosIniciarVotacao(Calendar hoje) {
		Votacao votacao = new Votacao();
		votacao.setDataVotacao(hoje);
		votacao.setAtiva(Boolean.TRUE);
		return votacao;
	}

	public Votacao inserir(Votacao votacao) {
		votacao.setId(null);
		votacao = votacaoRepository.save(votacao);
		return votacao;
	}

	@Override
	public Votacao apurarVencedor(ProfissionalDTO profissional, VotacaoDTO votacao) {
		// TODO Auto-generated method stub
		return null;
	}

}
