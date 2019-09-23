package com.dbserver.desafioRastaurante.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Arrays;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbserver.desafioRastaurante.entities.Profissional;
import com.dbserver.desafioRastaurante.entities.Restaurante;
import com.dbserver.desafioRastaurante.repository.ProfissionalRepository;
import com.dbserver.desafioRastaurante.repository.RestauranteRepository;


@Service
public class DbService {
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	public void instantiateTestDatabase() {
		
		criaBD();
		populaDadosRestaurantes();
		
		populaProfissionais();
		
	}

	private void populaProfissionais() {
		Profissional p1 = new Profissional(null,"Guilherme Palma", "guilherme.palma@dbserver.com.br");
		Profissional p2 = new Profissional(null,"João da Silva", "joao.silva@dbserver.com.br");
		Profissional p3 = new Profissional(null,"Fernanda Martins", "fernanda.martins@dbserver.com.br");
		Profissional p4 = new Profissional(null,"Ana Maia", "ana.maia@dbserver.com.br");
		Profissional p5 = new Profissional(null,"Lucas Gomes", "lucas.gomes@dbserver.com.br");
		Profissional p6 = new Profissional(null,"Leticia Glass", "leticia.glass@dbserver.com.br");
		Profissional p7 = new Profissional(null,"Eduardo Santos", "eduardo.santos@dbserver.com.br");
		
		profissionalRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7));
	}

	private void populaDadosRestaurantes() {
		Restaurante r1 = new Restaurante(null, "Palatos", "Av. Cristóvão Colombo, 1971 - Floresta, Porto Alegre");
		Restaurante r2 = new Restaurante(null, "Panorama Gastronomico", " Prédio 41 - PUCRS - Avenida Ipiranga, 6681 - Praia de Belas, Porto Alegre");
		Restaurante r3 = new Restaurante(null, "Via Imperatore", " R. da República, 509 - Cidade Baixa, Porto Alegre");
		Restaurante r4 = new Restaurante(null, "Restaurante Sabor Familia", "PUCRS, Av. Ipiranga, 6881 - Partenon, Porto Alegre");
		Restaurante r5 = new Restaurante(null, "Silva Lanches", "Vila Joao Pessoa, Porto Alegre");
		
		restauranteRepository.saveAll(Arrays.asList(r1,r2,r3,r4,r5));
	}
	
	public void criaBD() {
		try {
	        String databaseName = "votacao_restaurante";
	        String userName = "root";
	        String password = "";

	        String url = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
	        
	        Connection connection = DriverManager.getConnection(url,userName, password);
	        String sql = "CREATE DATABASE IF NOT EXISTS " + databaseName;        
	     
	        Statement statement = connection.createStatement();
	        statement.executeUpdate(sql);
	        statement.close();	        

	    } catch (Exception e) {
	        e.printStackTrace();
	}
		
	}

}
