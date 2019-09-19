package com.dbserver.desafioRastaurante.config;

import org.mockito.Mockito;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.dbserver.desafioRastaurante.service.VotacaoService;

@Profile("test")
@Configuration
public class VotacaoServiceConfiguration {
	
	public VotacaoService votacaoService() {
	      return Mockito.mock(VotacaoService.class);
	   }
	
}
