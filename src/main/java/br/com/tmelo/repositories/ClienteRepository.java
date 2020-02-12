package br.com.tmelo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.tmelo.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	@Query("SELECT obj FROM Cliente obj WHERE obj.nome = :nome")
	List<Cliente> search(@Param("nome") String nome);
}
