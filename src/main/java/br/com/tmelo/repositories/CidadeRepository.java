package br.com.tmelo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.tmelo.entities.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

	@Query("SELECT obj FROM Cidade obj WHERE obj.nome = :nome OR obj.estado = :estado")
	List<Cidade> search(@Param("nome") String nome, @Param("estado") String estado);

}
