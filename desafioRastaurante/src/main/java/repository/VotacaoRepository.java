package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbserver.desafioRastaurante.entity.Profissional;

@Repository
public interface VotacaoRepository extends JpaRepository<Profissional, Integer> {
	
	

}
