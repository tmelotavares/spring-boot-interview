package br.com.tmelo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tmelo.entities.Cidade;
import br.com.tmelo.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repo;
	
	public Optional<Cidade> buscar(Integer id) {
		Optional<Cidade> obj = repo.findById(id);
		return obj;
	}
	
}
