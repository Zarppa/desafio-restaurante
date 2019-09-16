package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbserver.desafioRastaurante.entity.Votacao;

@Repository
public interface ProfissionalRepository extends JpaRepository<Votacao, Integer> {
	
	

}
