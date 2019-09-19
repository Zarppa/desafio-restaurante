package com.dbserver.desafioRastaurante.integration.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.util.Calendar;
import java.util.Date;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.dbserver.desafioRastaurante.entities.Votacao;
import com.dbserver.desafioRastaurante.repository.VotacaoRepository;
import com.dbserver.desafioRastaurante.util.CalendarUtil;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VotacaoRepositoryIntegrationTest {
	
	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
    private VotacaoRepository votacaoRepository;
	
	private static final Date HOJE = CalendarUtil.truncate(Calendar.getInstance()).getTime();
	
	public void whenFindByDataVotacao_thenReturnVotacao() {
		
		Votacao votacao = new Votacao();
		votacao.setDataVotacao(HOJE);
	    entityManager.persist(votacao);
	    entityManager.flush();
	 
	    // when
	    Votacao encontrado = votacaoRepository.findByDataVotacao(votacao.getDataVotacao());
	 
	    // then
	    assertThat(encontrado.getDataVotacao())
	      .isEqualTo(votacao.getDataVotacao());
	}
}
	
	

