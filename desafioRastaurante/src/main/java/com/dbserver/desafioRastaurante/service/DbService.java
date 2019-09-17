package com.dbserver.desafioRastaurante.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbserver.desafioRastaurante.entity.Restaurante;
import com.dbserver.desafioRastaurante.repository.RestauranteRepository;

@Service
public class DbService {
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	public void instantiateTestDatabase() {
		
		Restaurante r1 = new Restaurante(null, "Palatos", "Av. Cristóvão Colombo, 1971 - Floresta, Porto Alegre");
		Restaurante r2 = new Restaurante(null, "Panorama Gastronomico", " Prédio 41 - PUCRS - Avenida Ipiranga, 6681 - Praia de Belas, Porto Alegre");
		Restaurante r3 = new Restaurante(null, "Via Imperatore", " R. da República, 509 - Cidade Baixa, Porto Alegre");
		Restaurante r4 = new Restaurante(null, "Restaurante Sabor Familia", "PUCRS, Av. Ipiranga, 6881 - Partenon, Porto Alegre");
		Restaurante r5 = new Restaurante(null, "Silva Lanches", "Vila Joao Pessoa, Porto Alegre");
		
		
		restauranteRepository.saveAll(Arrays.asList(r1,r2,r3,r4,r5));
		
		
	}

}
