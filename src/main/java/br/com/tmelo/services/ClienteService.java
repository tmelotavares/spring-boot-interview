package br.com.tmelo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tmelo.entities.Cliente;
import br.com.tmelo.repositories.ClienteRepository;
import br.com.tmelo.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

	public Cliente insert(Cliente obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Cliente update(Cliente obj) {
		buscar(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}

	public List<Cliente> search(String nome) {
		return repo.search(nome);

	}

}
