package br.com.tmelo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	private String sexo;

	private String dtNascimento;

	private Integer idade;

	@JsonBackReference
	@ManyToMany
	@JoinTable(name = "CLIENTE_CIDADE", joinColumns = @JoinColumn(name = "cliente_id"), inverseJoinColumns = @JoinColumn(name = "cidade_id"))
	private List<Cidade> cidades = new ArrayList<Cidade>();

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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String pSexo) {
		this.sexo = pSexo;
	}

	public String getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(String pDtNascimento) {
		this.dtNascimento = pDtNascimento;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer pIdade) {
		this.idade = pIdade;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> pCidades) {
		this.cidades = pCidades;
	}

	public Cliente() {
	}

	public Cliente(Integer pId, String pNome, String pSexo, String pDtNascimento, Integer pIdade) {
		super();
		this.id = pId;
		this.nome = pNome;
		this.sexo = pSexo;
		this.dtNascimento = pDtNascimento;
		this.idade = pIdade;

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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
