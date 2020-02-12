package br.com.tmelo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Cidade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	private String estado;

	@ManyToMany(mappedBy = "cidades")
	private List<Cliente> clientes = new ArrayList<Cliente>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer pId) {
		this.id = pId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String pNome) {
		this.nome = pNome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String pEstado) {
		this.estado = pEstado;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> pClientes) {
		this.clientes = pClientes;
	}

	public Cidade() {
	}

	public Cidade(Integer pId, String pNome, String pEstado) {
		super();
		this.id = pId;
		this.nome = pNome;
		this.estado = pEstado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
