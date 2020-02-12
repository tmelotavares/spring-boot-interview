package br.com.tmelo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.tmelo.entities.Cidade;
import br.com.tmelo.entities.Cliente;
import br.com.tmelo.repositories.CidadeRepository;
import br.com.tmelo.repositories.ClienteRepository;

@SpringBootApplication
public class SpringBootInterviewApplication implements CommandLineRunner {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository; 
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootInterviewApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		Cidade cid1 = new Cidade (null,"Vitória","Pernambuco");
		Cidade cid2 = new Cidade (null,"Recife","Pernambuco");
		
		Cliente cli1 = new Cliente(null,"Fred","","",1);
		Cliente cli2 = new Cliente(null,"Rod","","",1);
		Cliente cli3 = new Cliente(null,"Will","","",1);
		
		cid1.getClientes().addAll(Arrays.asList(cli1,cli2,cli3));
		cid2.getClientes().addAll(Arrays.asList(cli2));
		
		cli1.getCidades().addAll(Arrays.asList(cid1));
		cli2.getCidades().addAll(Arrays.asList(cid1));
		cli3.getCidades().addAll(Arrays.asList(cid1));
		
		cidadeRepository.saveAll(Arrays.asList(cid1,cid2));
		
		clienteRepository.saveAll(Arrays.asList(cli1,cli2,cli3));
		
		
	}

}

