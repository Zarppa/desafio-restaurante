package com.dbserver.desafioRastaurante.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dbserver.desafioRastaurante.entities.Profissional;
import com.dbserver.desafioRastaurante.entities.Voto;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Integer> {
	
	@Transactional(readOnly=true)
	@Query("SELECT v FROM Voto v where v.profissional =:profissional and v.dataVoto = :dataVoto")
	public Voto buscarVotoPorProfissionaleData(@Param("profissional") Profissional profissional, @Param("dataVoto") Date dataVoto);

}
