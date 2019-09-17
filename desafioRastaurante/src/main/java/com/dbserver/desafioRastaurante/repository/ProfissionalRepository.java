package com.dbserver.desafioRastaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbserver.desafioRastaurante.entities.Profissional;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Integer> {
	
	

}
