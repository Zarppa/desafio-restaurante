package com.dbserver.desafioRastaurante.repository;

import java.util.Calendar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dbserver.desafioRastaurante.entities.Votacao;

@Repository
public interface VotacaoRepository extends JpaRepository<Votacao, Integer> {
	
	
	@Transactional(readOnly = true)
	Votacao findByDataVotacao(Calendar dataVotacao);
}
