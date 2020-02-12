package br.com.tmelo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tmelo.entities.Cidade;
import br.com.tmelo.repositories.CidadeRepository;
import br.com.tmelo.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repo;

	public Cidade buscar(Integer id) {
		Optional<Cidade> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cidade.class.getName()));
	}

	public Cidade insert(Cidade obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Cidade update(Cidade obj) {
		buscar(obj.getId());
		return repo.save(obj);
	}

	public List<Cidade> search(String nome, String estado) {
		return repo.search(nome, estado);

	}

}
